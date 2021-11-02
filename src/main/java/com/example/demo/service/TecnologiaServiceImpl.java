package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tecnologia;
import com.example.demo.repository.TecnologiaRepository;

@Service
@Transactional
public class TecnologiaServiceImpl implements TecnologiaService{
	
	@Autowired
	private TecnologiaRepository repository;
	
	@Override
	public Tecnologia registrar(Tecnologia tecnologia) {
		return repository.save(tecnologia);
	}

	@Override
	public void actualizar(Tecnologia tecnologia) {
		repository.save(tecnologia);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Tecnologia buscar(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Tecnologia> listar() {
		return (List<Tecnologia>) repository.findAll();
	}
}
