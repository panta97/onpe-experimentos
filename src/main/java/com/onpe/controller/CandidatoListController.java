package com.onpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onpe.entity.Candidato;
import com.onpe.service.ICandidatoService;

@Controller
@RequestMapping("/candidato/list")
public class CandidatoListController {
	
	@Autowired
	ICandidatoService candidatoService;
	
	@GetMapping
	public String listar(Model model) {
		
		List<Candidato> candidatos = candidatoService.findAll();
		model.addAttribute("candidatos", candidatos);
		
		return "candidatolist";
	}
}
