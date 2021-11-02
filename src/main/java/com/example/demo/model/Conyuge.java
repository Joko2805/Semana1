package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "conyuges")
public class Conyuge implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long conyugeDni;
	
	@Column(length = 100)
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "instructor_id", nullable = false, unique = true,
						foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (instructor_id)"
																		+ "references instructores(instructor_id)"))
	@JsonBackReference
	private Instructor instructor;

	public Long getConyugeDni() {
		return conyugeDni;
	}

	public void setConyugeDni(Long conyugeDni) {
		this.conyugeDni = conyugeDni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Conyuge() {
		// TODO Auto-generated constructor stub
	}
}
