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

import com.onpe.entity.Candidato;
import com.onpe.service.ICandidatoService;
import com.onpe.service.IDistritoService;
import com.onpe.service.IPartidoPoliticoService;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	@Autowired
	ICandidatoService candidatoService;
	
	@Autowired
	IDistritoService distritoService;
	
	@Autowired
	IPartidoPoliticoService partidoService;
	
	@GetMapping("/list")
	public String listar(Model model) {
		
		List<Candidato> candidatos = candidatoService.findAll();
		model.addAttribute("candidatos", candidatos);
		
		return "candidatolist";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		List<String> estados = new ArrayList<String>();
		estados.add("ACT");
		estados.add("INA");
		
		model.addAttribute("estado", estados);
		
		model.addAttribute("distrito", distritoService.findAll());
		
		model.addAttribute("partido", partidoService.findAll());
		
		model.addAttribute("candidato", candidatoService.findById(id));
		
		return "candidatoedit";
		
	}
	
	@PostMapping("/save")
	public String save(Candidato candidato, Model model, RedirectAttributes redirect) {
		Candidato objResult = candidatoService.save(candidato);
		
		if(objResult == null) {
			model.addAttribute("resultado", "Ocurrio un error");
			return "mensaje";
		} else {
			redirect.addFlashAttribute("objResult", true);
			redirect.addFlashAttribute("resultado", "Candidato guardado");
			return "redirect:/candidato/list";
		}
	}
	
	@GetMapping("/add")
	public String crear(Model model) {
		
		List<String> estados = new ArrayList<String>();
		estados.add("ACT");
		estados.add("INA");
		
		model.addAttribute("estado", estados);
		
		model.addAttribute("distrito", distritoService.findAll());
		
		model.addAttribute("partido", partidoService.findAll());
		
		model.addAttribute("candidato", new Candidato());
		
		return "candidatoadd";
	}
	
}

