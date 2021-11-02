package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Conyuge;
import com.example.demo.service.ConyugeService;

@RestController
@RequestMapping("/conyuge")
public class ConyugeController {

	@Autowired
	private ConyugeService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Conyuge> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Conyuge conyuge){
		service.registrar(conyuge);
		return new ResponseEntity<>("Coyugue creado!!",HttpStatus.CREATED);
	}
	
	

}
