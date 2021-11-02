package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Conyuge;
import com.example.demo.repository.ConyugeRepository;

@Service
@Transactional
public class ConyugeServiceImpl implements ConyugeService{

	@Autowired
	private ConyugeRepository repository;
	
	@Override
	public void registrar(Conyuge conyuge) {
		repository.save(conyuge);
	}

	@Override
	public void actualizar(Conyuge conyuge) {
		repository.save(conyuge);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Conyuge buscar(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Conyuge> listar() {
		return (List<Conyuge>) repository.findAll();
	}

}
