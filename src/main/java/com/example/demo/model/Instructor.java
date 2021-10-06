package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Contiene toda la informacacion relativa de los instructores")
public class Instructor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Indentificador unico del instructor", required = true)
	private int instructorId;
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private Date fregistro;
	
	public Instructor() {
		
	}
	
	public Instructor(int instructorId, String nombre, String apellido, String password, String email, Date fregistro) {
		super();
		this.instructorId = instructorId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fregistro = fregistro;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}
	
}
