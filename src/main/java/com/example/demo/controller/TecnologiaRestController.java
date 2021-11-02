package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tecnologia;
import com.example.demo.service.TecnologiaService;

@RestController
@RequestMapping("/tecnologia")
public class TecnologiaRestController {

	@Autowired
	private TecnologiaService service;

	@GetMapping("listar")
	public ResponseEntity<?> listar(){
		List<Tecnologia> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("registrar")
	public ResponseEntity<?> registrar(@RequestBody Tecnologia tecnologia){
		Tecnologia t = service.registrar(tecnologia);
		return new ResponseEntity<>("Se registro un tecnologia con Id: "+t.getTecnologiaId().toString(),HttpStatus.CREATED);
	}
}
