package com.onpe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.onpe.entity.PartidoPolitico;
import com.onpe.entity.Distrito;

@Entity
@Table(name="candidato")
public class Candidato {
	
	@Id
	@Column(name="id_candidato")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_partidopolitico")
	public PartidoPolitico partidopolitico;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_distrito")
	private Distrito distrito;
	
	@Column(name="nombre_candidato")
	private String nombre;
	
	@Column(name="apellido_candidato")
	private String apellido;
	
	@Column(name="estado_candidato")
	private String estado;
	
	public Candidato() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PartidoPolitico getPartidoPolitico() {
		return partidopolitico;
	}

	public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
		this.partidopolitico = partidoPolitico;
	}
	
	public PartidoPolitico getPartidopolitico() {
		return partidopolitico;
	}

	public void setPartidopolitico(PartidoPolitico partidoPolitico) {
		this.partidopolitico = partidoPolitico;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
