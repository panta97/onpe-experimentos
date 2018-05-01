package com.onpe.service;

import java.util.List;

import com.onpe.entity.Candidato;

public interface ICandidatoService {
	
	public Candidato save(Candidato candidato);
	
	public void update(int id, String nombre, String apellido);
	
	public Candidato findById(int id);

	public List<Candidato> findAll();
	
	public void delete(int id);
	
	public boolean exists(int id);
}
