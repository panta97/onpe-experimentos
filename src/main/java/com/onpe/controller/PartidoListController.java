package com.onpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onpe.entity.PartidoPolitico;
import com.onpe.service.IPartidoPoliticoService;

@Controller
@RequestMapping("/partido/list")
public class PartidoListController {
	
	@Autowired
	IPartidoPoliticoService partidoPoliticoService;
	
	@GetMapping
	public String listar(Model model) {
		List<PartidoPolitico> partidos = partidoPoliticoService.findAll();
		model.addAttribute("partidos", partidos);
		
		return "partidolist";
	}
}
