package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
	
}
