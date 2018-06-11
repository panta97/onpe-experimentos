package com.onpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onpe.entity.Distrito;
import com.onpe.repository.DistritoRepository;

@Service
public class DistritoService implements IDistritoService{
	
	@Autowired
	private DistritoRepository distritoRepository;

	//CREATE
	@Override
	public Distrito save(Distrito distrito)  {
		return distritoRepository.save(distrito);
	}
	
	//RETRIEVE
	@Override
	public List<Distrito> findAll() {
		return distritoRepository.findAll();
	}
	
	//UPDATE
	@Override
	public Distrito findById(int id) {
		return distritoRepository.findById(id);
	}
	
	@Override
	public void update(int id, String nombre) {
		distritoRepository.update(id, nombre);
	}

	//DELETE
	@Override
	public void delete(int id) {
		distritoRepository.delete(id);
	}
	
	//TEST
	@Override
	public boolean exists(int id) {
		return distritoRepository.exists(id);
	}
	
}
