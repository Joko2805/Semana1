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

import com.example.demo.model.Taller;
import com.example.demo.service.TallerService;

@RestController
@RequestMapping("/taller")
public class TallerRestController {

	@Autowired
	private TallerService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Taller> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Taller taller){
		Taller t = service.registrar(taller);
		return new ResponseEntity<>("Se registro nuevo taller con id: "+t.getTallerId().toString(),HttpStatus.CREATED);
	}
}
