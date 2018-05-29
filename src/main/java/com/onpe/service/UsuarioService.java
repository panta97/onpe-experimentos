package com.onpe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onpe.entity.Usuario;
import com.onpe.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService, IUsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findById(int id) {
		return usuarioRepository.findById(id);
	}
	
	@Override
	public Usuario findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public void update(int id, String nombre, String apellido) {
		usuarioRepository.update(id, nombre, apellido);	
	}
	
	@Override
	public void delete(int id) {
		usuarioRepository.delete(id);
	}

	@Override
	public boolean exists(int id) {
		return usuarioRepository.exists(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("BELOWWWWW");
		System.out.println(username.toString());
				
		Usuario usuario = usuarioRepository.findByNombre(username);
		
		if (usuario == null) {
			
			System.out.println("-----------NULLLLLLL-------");
			
			throw new UsernameNotFoundException("No user found with:" + username);
			
		}
		
		return buildUser(usuario);
		
	}
	
	private User buildUser(Usuario usuario) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(usuario.getNombre(), usuario.getPassword(), true, true, true, true, authorities);
	}


}
