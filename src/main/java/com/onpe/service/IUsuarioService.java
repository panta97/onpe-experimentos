package com.onpe.service;

import java.util.List;

import com.onpe.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(int id);
	
	public Usuario findByNombre(String nombre);
	
	public List<Usuario> findAll();
	
	public void update(int id, String nombre, String apellido);
	
	public void delete(int id);
	
	public boolean exists(int id);
}
