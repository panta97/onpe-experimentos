package com.onpe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String save(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes redirect) {
		try {
			
			if (usuario.getNombre().length() <= 0 || usuario.getPassword().length() <= 0) {
				redirect.addFlashAttribute("objResult", true);
				redirect.addFlashAttribute("resultado", "Campo(s) incompleto(s)");
				
				return "redirect:/signup";
			}
			
			
			String auxpass = usuario.getPassword();
			usuario.setPassword(encoder.encodePass(auxpass));
			usuario.setCodigo("CODE");
			usuario.setEstado("ACT");
			usuario.setApellido("APELLIDO");
			usuario.setRol("ROLE_USER");
			
			usuarioService.save(usuario);
			
			redirect.addFlashAttribute("objResult", true);
			redirect.addFlashAttribute("resultado", "nuevo usuario creado");
			
			return "redirect:/login";
			
		} catch (Exception e) {
			
			model.addAttribute("message", result.toString());
			return "/signup";
		}
	}
	
	

}
