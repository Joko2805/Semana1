package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Instructor;

//Actuara como repositorio de datos
@Repository
public class InstructorRepositoryImpl implements InstructorRepository{
	
	//Creando una lista estatica para guardar los datos temporalmente
	private final Collection<Instructor> LISTA = new ArrayList<>();
	
	@PostConstruct
	public void cargarDatos() {
		LISTA.add(new Instructor(1, "Alex", "Martinez", "1234", "Alex@gmail", new Date()));
		LISTA.add(new Instructor(2, "Jose", "Lopez", "1234", "Jose@gmail", new Date()));
		LISTA.add(new Instructor(3, "Raul", "Fernandez", "12345", "Raul@gmail", new Date()));
	}

	@Override
	public void registrar(Instructor instructor) {
		//agregamos nuevo instructor a la lista
		LISTA.add(instructor);
	}

	@Override
	public void actualizar(Instructor instructor) {
		//Primero buscamos al viejo instructor y luego lo borramos
		Instructor i = buscar(instructor.getInstructorId());
		LISTA.remove(i);	
		
		//Agregamos el nuevo instructor
		LISTA.add(instructor);	
	}

	@Override
	public Instructor buscar(int id) {
		//Buscamos al instructor dentro de la lista
		for(Instructor i : LISTA) {
			//Si lo encontramos retornamos el objeto y terminamos el bucle
			if(i.getInstructorId() == id) {
				return i;
			}
		}
		//Caso contrario retornamos nulo
		return null;
	}

	@Override
	public void eliminar(int id) {
		//buscamos al instructor y lo borramos de la lista
		Instructor instructor = buscar(id);
		LISTA.remove(instructor);
	}

	@Override
	public Collection<Instructor> listar() {
		//retornamos la lista
		return LISTA;
	}

}
