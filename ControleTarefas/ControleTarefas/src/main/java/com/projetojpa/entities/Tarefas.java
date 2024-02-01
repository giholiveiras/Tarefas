package com.projetojpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@Table(name="/tarefas")
	@Data
	@NoArgsConstructor
	public class Tarefas {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@NotBlank
		private String nome;
		
		
		@NotNull
		@NotBlank
		private String dataFinalExecucao;
		
		
		@NotNull
		@NotBlank
		private String descricaoTarefa;
		
		@NotNull
		@NotBlank
		private String statusTarefa;
	}
