package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Tecnologia;

public interface TecnologiaService {
	Tecnologia registrar(Tecnologia tecnologia);
	void actualizar(Tecnologia tecnologia);
	void eliminar(Integer id);
	Tecnologia buscar(Integer id);
	List<Tecnologia> listar();
}
