package com.example.demo.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "instructores")
public class Instructor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "instructor_id")
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
	
	@OneToOne(mappedBy = "instructor") 
	private Conyuge conyuge;
	
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.REMOVE)
	private Collection<Taller> itemsTaller = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "instructores_tecnologias",
				joinColumns = @JoinColumn(name = "instructor_id", nullable = false,
										foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (instructor_id)"
																		+ "references instructores(instructor_id)")),
				inverseJoinColumns = @JoinColumn(name = "tecnologia_id", nullable = false,
										foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (tecnologia_id)"
																		+ "references tecnologias(tecnologia_id)")))
	private Set<Tecnologia> itemsTecnologia = new HashSet<>();
	
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
		this.fregistro = new Date();
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

	public Conyuge getConyuge() {
		return conyuge;
	}

	public void setConyuge(Conyuge conyuge) {
		this.conyuge = conyuge;
	}

	public Collection<Taller> getItemsTaller() {
		return itemsTaller;
	}

	public void setItemsTaller(Collection<Taller> itemsTaller) {
		this.itemsTaller = itemsTaller;
	}
	
}
