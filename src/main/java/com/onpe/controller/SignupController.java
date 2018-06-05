package com.onpe.controller;

import java.util.List;

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
	
    public static final String REDIRECT_SAME_PAGE = "redirect:/signup";
	
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
			
			if (usuario.getNombre().length() <= 0 || usuario.getPassword().length() <= 0 || usuario.getApellido().length() <= 0) {
				loadRedirect("Campo(s) incompleto(s)", redirect);
				return REDIRECT_SAME_PAGE;
			}
			
			if (!usuario.getPassword().equals(usuario.getApellido())) {
				loadRedirect("Contrasenias no coinciden", redirect);
				return REDIRECT_SAME_PAGE;
			}
			
			if (!isUserUnique(usuario)) {
				loadRedirect("Nombre de usuario ya existe", redirect);
				return REDIRECT_SAME_PAGE;
			}
			
			
			String auxpass = usuario.getPassword();
			usuario.setPassword(encoder.encodePass(auxpass));
			usuario.setCodigo("CODE");
			usuario.setEstado("ACT");
			usuario.setApellido("APELLIDO");
			usuario.setRol("ROLE_USER");
			
			usuarioService.save(usuario);
			
			loadRedirect("nuevo usuario creado", redirect);
			
			return "redirect:/login";
			
		} catch (Exception e) {
			
			model.addAttribute("message", result.toString());
			return "/signup";
		}
	}
	
	private boolean isUserUnique(Usuario user) {
		List<Usuario> users = usuarioService.findAll();
		
		for (Usuario existingUser : users) {
			if (user.getNombre().equals(existingUser.getNombre())) {
				return false;
			}
		}
		
		return true;	
	}
	
	private void loadRedirect(String customMessage, RedirectAttributes redirect) {
		redirect.addFlashAttribute("objResult", true);
		redirect.addFlashAttribute("resultado", customMessage);
	}
	
}
