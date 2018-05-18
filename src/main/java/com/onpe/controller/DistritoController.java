package com.onpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onpe.entity.Distrito;
import com.onpe.service.IDistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {
	
	@Autowired
	IDistritoService distritoService;
	
	@GetMapping("/list")
	public String listar(Model model) {
		List<Distrito> distritos = distritoService.findAll();
		model.addAttribute("distritos", distritos);
		
		return "distritolist";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		List<String> estados = new ArrayList<String>();
		estados.add("ACT");
		estados.add("INA");
		 
		model.addAttribute("estado", estados);
		
		model.addAttribute("distrito", distritoService.findById(id));
		
		return "distritoedit";
		
	}
	
	@PostMapping("/save")
	public String save(Distrito distrito, Model model) {
		Distrito objResult = distritoService.save(distrito);
		
		if(objResult == null) {
			model.addAttribute("resultado", "Ocurrio un error");
			return "mensaje";
		}else{
			model.addAttribute("resultado", "Distrito guardado");
			return "redirect:/distrito/list";
		
		}
	}
	
	@GetMapping("/add")
	public String crear(Model model) {
		
		List<String> estados = new ArrayList<String>();
		estados.add("ACT");
		estados.add("INA");
		
		model.addAttribute("estado", estados);
		
		model.addAttribute("distrito", new Distrito());

		
		return "distritoadd";

	}
		
}
