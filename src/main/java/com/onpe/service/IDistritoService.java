package com.onpe.service;

import java.util.List;

import com.onpe.entity.Distrito;

public interface IDistritoService {
	
	public Distrito save(Distrito distrito);
	
	public Distrito findById(int id);

	public List<Distrito> findAll();
				
	public void update(int id, String nombre);
	
	public void delete(int id);
}
