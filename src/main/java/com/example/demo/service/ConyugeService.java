package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Conyuge;


public interface ConyugeService {
	void registrar(Conyuge conyuge);
	void actualizar(Conyuge conyuge);
	void eliminar(Integer id);
	Conyuge buscar(Integer id);
	List<Conyuge> listar();
}
