package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Instructor;
import com.example.demo.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorRestController {

	@Autowired
	private InstructorService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		//Obteniendo la lista de objetos
		Collection<Instructor> lista = service.listar();
		//Creamos un objeto ResponseEntity pasandole la lista y el estado Https
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorNombre")
	public ResponseEntity<?> buscarPorId(@RequestParam(name = "nombre") String nombre){
		//Obteniendo la lista de objetos
		List<Instructor> lista = service.buscarPorNombre(nombre);
		//Creamos un objeto ResponseEntity pasandole la lista y el estado Https
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable(name = "id")int id){
		Instructor instructor = service.buscar(id);
		//Ver si el objeto es nulo
		if(instructor == null) {
			//Si el objeto es nulo lanza una excepcion y termina el metodo
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El instructor no se encuentra");
		}else{
			//Si el objeto no es nulo retorna el instrutor buscado
			return new ResponseEntity<>(instructor,HttpStatus.OK);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Instructor instructor){
		service.registrar(instructor);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Instructor instructor){
		//Buscamos al instructor
		Instructor i = service.buscar(instructor.getInstructorId());
		//Si es nulo lanzamos una excepcion, caso contrario actualizamos
		if(i == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Instructor no encontrado");
		}else {
			service.actualizar(instructor);
			return new ResponseEntity<>(HttpStatus.OK);
		}	
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") int id){
		//Buscamos al instructor
		Instructor instructor = service.buscar(id);
		//Si el instructor no es nulo lo eliminamos
		if(instructor == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}else {
			service.eliminar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/listar_public")
	public ResponseEntity<?> listarPUBLIC() 	{
		Collection<Instructor> itemsInstructor=service.listar();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/listar_admin")
	public ResponseEntity<?> listarADMIN() {
		Collection<Instructor> itemsInstructor=service.listar();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/listar_user")
	public ResponseEntity<?> listarUSER() {
		Collection<Instructor> itemsInstructor=service.listar();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}

}
