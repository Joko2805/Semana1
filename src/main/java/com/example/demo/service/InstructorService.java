package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import com.example.demo.model.Instructor;

public interface InstructorService {
	void registrar(Instructor instructor);
	void actualizar(Instructor instructor);
	Instructor buscar(Integer id);
	void eliminar(Integer id);
	Collection<Instructor> listar();
	List<Instructor> buscarPorNombre(String nombre);
}
