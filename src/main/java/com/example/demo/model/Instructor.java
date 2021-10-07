package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "instructores")
public class Instructor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Temporal(TemporalType.DATE)
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
	
	@PrePersist
	public void prePersist() {
		fregistro = new Date();
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
