package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Instructor;
import com.example.demo.repository.InstructorRepository;

//Actuara como un service
@Service
public class InstructorServiceImpl implements InstructorService{
	
	//Esta anotacion se usa pasa usar los metodos de InstructorService sin crear objetos
	@Autowired
	private InstructorRepository repository;

	@Override
	@Transactional
	public void registrar(Instructor instructor) {
		repository.save(instructor);
	}

	@Transactional
	@Override
	public void actualizar(Instructor instructor) {
		repository.save(instructor);	
	}

	@Transactional
	@Override
	public Instructor buscar(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Transactional
	@Override
	public Collection<Instructor> listar() {
		return (Collection<Instructor>) repository.findAll();
	}



}
