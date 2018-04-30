package com.onpe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="nombre_usuario")
	@NotBlank(message = "debes completar este campo")
	private String nombre;
	
	@Column(name="apellido_usuario")
	@NotBlank(message = "debes completar este campo")
	private String apellido;
	
	@Column(name="codigo_usuario")
	@NotBlank(message = "debes completar este campo")
	private String codigo;
	
	@Column(name="password_usuario")
	@NotBlank(message = "debes completar este campo")
	private String password;
	
	@Column(name="rol_usuario")
	@NotBlank(message = "debes completar este campo")
	private String rol;
	
	@Column(name="estado_usuario")
	@NotBlank(message = "debes completar este campo")
	private String estado;
	
	public Usuario() {
		
	}

	public Usuario(String nombre, String apellido, String codigo, String password, String rol, String estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
		this.password = password;
		this.rol = rol;
		this.estado = estado;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
