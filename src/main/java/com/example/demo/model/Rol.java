package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Roles")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private Integer id;
	
	@Column(name = "rol_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (user_id)"
															+ "references usuarios(user_id)"))
	@JsonBackReference
	private Usuario usuario;
	
	public Rol() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
