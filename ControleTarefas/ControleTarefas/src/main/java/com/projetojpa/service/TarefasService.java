package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Tarefas;
import com.projetojpa.repository.TarefasRepository;

@Service
public class TarefasService {
private final TarefasRepository tarefasRepository;

	@Autowired
	public TarefasService (TarefasRepository tarefasRepository) {
		this.tarefasRepository = tarefasRepository;
	}
	
	public List<Tarefas> getAllTarefas () {
		return tarefasRepository.findAll();
	}
	public Tarefas getTarefasById (Long id) {
		Optional<Tarefas> Tarefas = tarefasRepository.findById(id);
		return Tarefas.orElse(null);
	}
	
	public Tarefas saveTarefas(Tarefas tarefas) {
		return tarefasRepository.save(tarefas);
	}
	
	public Tarefas putTarefas(Long id, Tarefas alterarT) {
		Optional <Tarefas> existeTarefas = tarefasRepository.findById(id);
		if (existeTarefas.isPresent()) {
			alterarT.setId(id);
		return tarefasRepository.save(alterarT);
	}
		return null;
	}
	
	public boolean deleteTarefas(Long id) {
		Optional <Tarefas> existeTarefas = tarefasRepository.findById(id);
		if (existeTarefas.isPresent()) {
			tarefasRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
