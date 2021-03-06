package com.onpe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="distrito")
public class Distrito {

	@Id
	@Column(name="id_distrito")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="nombre_distrito")
	private String nombre;
	
	@Column(name="estado_distrito")
	private String estado;
	
	@OneToMany(mappedBy="distrito", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Candidato> candidato;

	public Distrito() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<Candidato> getCandidato() {
		return candidato;
	}

	public void setCandidato(List<Candidato> candidato) {
		this.candidato = candidato;
	}
	
}
