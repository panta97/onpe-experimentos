package com.onpe.bean;

import javax.persistence.Entity;

public class DistritoBean  {
	
	
	private String nombre;
	//private String estado;
	
	public DistritoBean(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	/*
	public DistritoBean(String nombre, String estado) {
		super();
		this.nombre = nombre;
		this.estado = estado;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	*/ 
	public String toString() {
		return "Nombre: " + this.nombre;
	}
	

}
