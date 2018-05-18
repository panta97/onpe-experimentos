package com.onpe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onpe.entity.Usuario;
import com.onpe.others.PasswordEncoder;
import com.onpe.service.UsuarioService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping
	public String signUp(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "signup";
	}
	
	@PostMapping
	public String save(@Valid Usuario usuario, BindingResult result, Model model) {
		try {
			
			String auxpass = usuario.getPassword();
			usuario.setPassword(encoder.encodePass(auxpass));
			usuario.setCodigo("CODE");
			usuario.setEstado("ACT");
			usuario.setApellido("APELLIDO");
			usuario.setRol("ROLE_USER");
			
			usuarioService.save(usuario);
			
			
			return "redirect:/home";
			
		} catch (Exception e) {
			
			model.addAttribute("message", result.toString());
			return "/signup";
		}
	}
	
	

}
