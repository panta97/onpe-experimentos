package com.onpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onpe.entity.PartidoPolitico;
import com.onpe.repository.PartidoPoliticoRepository;

@Service
public class PartidoPoliticoService implements IPartidoPoliticoService{

	@Autowired
	private PartidoPoliticoRepository partidoPoliticoRepository;

	//CREATE
	@Override
	public PartidoPolitico save(PartidoPolitico partidoPolitico) {
		return partidoPoliticoRepository.save(partidoPolitico);
	}
	
	//UPDATE
	@Override
	public void udpate(int id, String nombre) {
		partidoPoliticoRepository.update(id, nombre);
	}
	
	//RETRIEVE
	@Override
	public PartidoPolitico findById(int id) {
		return partidoPoliticoRepository.findById(id);
	}
	
	@Override
	public List<PartidoPolitico> findAll() {
		return partidoPoliticoRepository.findAll();
	}

	//DELETE
	@Override
	public void delete(int id) {
		partidoPoliticoRepository.delete(id);
	}

	//TEST
	@Override
	public boolean exists(int id) {
		return partidoPoliticoRepository.exists(id);
	}
}
