package com.onpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onpe.entity.Candidato;
import com.onpe.repository.CandidatoRepository;

@Service
public class CandidatoService implements ICandidatoService{
	
	@Autowired
	private CandidatoRepository candidatoRepository;

	//CREATE
	@Override
	public Candidato save(Candidato candidato) {
		return candidatoRepository.save(candidato);
	}
	
	//UPDATE
	@Override
	public void update(int id, String nombre, String apellido) {
		candidatoRepository.update(id, nombre, apellido);		
	}
	
	//RETRIEVE
	@Override
	public Candidato findById(int id) {
		return candidatoRepository.findById(id);
	}
	
	@Override
	public List<Candidato> findAll() {
		return candidatoRepository.findAll();
	}
	
	//DELETE
	@Override
	public void delete(int id) {
		candidatoRepository.delete(id);
	}
	
	//TEST
	@Override
	public boolean exists(int id) {
		return candidatoRepository.exists(id);
	}
}
