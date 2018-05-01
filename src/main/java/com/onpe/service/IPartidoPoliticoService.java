package com.onpe.service;

import java.util.List;

import com.onpe.entity.PartidoPolitico;

public interface IPartidoPoliticoService {
	
	public PartidoPolitico save(PartidoPolitico partidoPolitico);
	
	public void udpate(int id, String nombre);
	
	public PartidoPolitico findById(int id);

	public List<PartidoPolitico> findAll();
			
	public void delete(int id);
	
	public boolean exists(int id);
	
}
