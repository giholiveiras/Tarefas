package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Tarefas;
import com.projetojpa.service.TarefasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/tarefas")
public class TarefasController {
private final TarefasService tarefasService;
	
	@Autowired
	public TarefasController (TarefasService tarefasService) {
		this.tarefasService = tarefasService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Tarefas> getTarefasControlId (@PathVariable Long id) {
		Tarefas tarefas = tarefasService.getTarefasById(id);
		if (tarefas != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<Tarefas>> getAllTarefasControl () {
		List<Tarefas> Tarefas = tarefasService.getAllTarefas();
		return ResponseEntity.ok(Tarefas);
}
	
	
	@PostMapping
	public ResponseEntity <Tarefas> saveTarefasControl(@RequestBody @Valid Tarefas tarefas) {
		Tarefas saveTarefas = tarefasService.saveTarefas(tarefas);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTarefas);
}
	@PutMapping ("/{id}")
	public ResponseEntity <Tarefas> putTarefasControl(@PathVariable Long id, @RequestBody @Valid Tarefas tarefas){
		Tarefas putTarefas = tarefasService.putTarefas(id, tarefas);
		if (putTarefas != null) {
			return ResponseEntity.ok(tarefas);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Tarefas> deleteTarefasControl (@PathVariable Long id) {
		boolean delete = tarefasService.deleteTarefas(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}