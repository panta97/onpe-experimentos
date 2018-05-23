package com.onpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onpe.entity.PartidoPolitico;
import com.onpe.service.IPartidoPoliticoService;

@Controller
@RequestMapping("/partido")
public class PartidoController {
	
	@Autowired
	IPartidoPoliticoService partidoPoliticoService;
	
	@GetMapping("/list")
	public String listar(Model model) {
		List<PartidoPolitico> partidos = partidoPoliticoService.findAll();
		model.addAttribute("partidos", partidos);
		
		return "partidolist";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		List<String> estados = new ArrayList<String>();
		estados.add("ACT");
		estados.add("INA");
		
		model.addAttribute("estado", estados);
		
		model.addAttribute("partido", partidoPoliticoService.findById(id));
		
		return "partidoedit";
	}
	
	@PostMapping("/save")
	public String save(PartidoPolitico partido, Model model, RedirectAttributes redirect) {
		PartidoPolitico objResult = partidoPoliticoService.save(partido);
		
		if(objResult == null) {
			model.addAttribute("resultado", "Ocurrio un error");
			return "mensaje";
		}else{
			redirect.addFlashAttribute("objResult", true);
			redirect.addFlashAttribute("resultado", "Partido guardado");
			return "redirect:/partido/list";
		
		}
	}
	
	@GetMapping("/add")
	public String crear(Model model) {
		
		List<String> estados = new ArrayList<String>();
		estados.add("ACT");
		estados.add("INA");
		
		model.addAttribute("estado", estados);
		
		model.addAttribute("partido", new PartidoPolitico());
		
		return "partidoadd";
	}
	
}
