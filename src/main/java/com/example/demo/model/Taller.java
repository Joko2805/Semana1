package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "talleres")
public class Taller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tallerId;
	
	@Column
	private String nombre;
	
	@Column
	private Double costo;
	
	@ManyToOne
	//nombre de la constraing
	@JoinColumn(name = "instructor_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (instructor_id)"
																+ "references instructores(instructor_id)"))
	private Instructor instructor;

	public Taller() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTallerId() {
		return tallerId;
	}

	public void setTallerId(Integer tallerId) {
		this.tallerId = tallerId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
