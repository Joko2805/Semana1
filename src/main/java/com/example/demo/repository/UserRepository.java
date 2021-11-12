package com.example.demo.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Integer> {
	
	Optional<Usuario> findUserByEmail(String email);
}
