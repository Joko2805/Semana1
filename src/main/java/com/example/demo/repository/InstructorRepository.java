package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
	
	//JPQL
	@Query("SELECT i FROM Instructor i WHERE i.nombre LIKE CONCAT(?1,'%')")
	List<Instructor> buscarPorNombre(String nombre);
}
