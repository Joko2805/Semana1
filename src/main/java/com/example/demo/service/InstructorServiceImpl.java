package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Instructor;
import com.example.demo.repository.InstructorRepository;

//Actuara como un service
@Service
public class InstructorServiceImpl implements InstructorService{
	
	//Esta anotacion se usa pasa usar los metodos de InstructorService sin crear objetos
	@Autowired
	private InstructorRepository repository;

	@Override
	public void registrar(Instructor instructor) {
		repository.registrar(instructor);
	}

	@Override
	public void actualizar(Instructor instructor) {
		repository.actualizar(instructor);
	}

	@Override
	public Instructor buscar(int id) {
		return repository.buscar(id);
	}

	@Override
	public void eliminar(int id) {
		repository.eliminar(id);
	}

	@Override
	public Collection<Instructor> listar() {
		return repository.listar();
	}

}
