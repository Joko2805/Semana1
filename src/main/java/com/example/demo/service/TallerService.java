package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Taller;

public interface TallerService {
	Taller registrar(Taller taller);
	void actualizar(Taller taller);
	void eliminar(Integer id);
	Taller buscar(Integer id);
	List<Taller> listar();
}
