package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Instructor;

public interface InstructorService {
	void registrar(Instructor instructor);
	void actualizar(Instructor instructor);
	Instructor buscar(int id);
	void eliminar(int id);
	Collection<Instructor> listar();
}
