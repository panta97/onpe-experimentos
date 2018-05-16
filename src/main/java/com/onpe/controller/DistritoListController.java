package com.onpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onpe.entity.Distrito;
import com.onpe.service.IDistritoService;

@Controller
@RequestMapping("/distrito/list")
public class DistritoListController {
	
	@Autowired
	IDistritoService distritoService;
	
	@GetMapping
	public String listar(Model model) {
		List<Distrito> distritos = distritoService.findAll();
		model.addAttribute("distritos", distritos);
		
		return "distritolist";
	}
}
