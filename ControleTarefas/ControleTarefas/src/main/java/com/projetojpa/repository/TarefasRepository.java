package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long>{

}
