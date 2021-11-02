package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Taller;
import com.example.demo.repository.TallerRepository;

@Service
@Transactional
public class TallerServiceImpl implements TallerService{

	@Autowired
	private TallerRepository repository;
	
	@Override
	public Taller registrar(Taller taller) {
		return repository.save(taller);
	}

	@Override
	public void actualizar(Taller taller) {
		repository.save(taller);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Taller buscar(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Taller> listar() {
		return (List<Taller>) repository.findAll();
	}

}
