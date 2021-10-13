package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Instructor;
import com.example.demo.repository.InstructorRepository;

//Actuara como un service
@Service
@Transactional
public class InstructorServiceImpl implements InstructorService{
	
	//Esta anotacion se usa pasa usar los metodos de InstructorService sin crear objetos
	@Autowired
	private InstructorRepository repository;

	@Override
	
	public void registrar(Instructor instructor) {
		repository.save(instructor);
	}

	@Override
	public void actualizar(Instructor instructor) {
		repository.save(instructor);	
	}

	@Override
	public Instructor buscar(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Collection<Instructor> listar() {
		return (Collection<Instructor>) repository.findAll();
	}
	
	@Override
	public List<Instructor> buscarPorNombre(String nombre){
		return repository.buscarPorNombre(nombre);
	}
}
