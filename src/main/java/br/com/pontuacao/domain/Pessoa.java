package br.com.pontuacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pessoa", schema = "pontuacao", uniqueConstraints = {})
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "renda", nullable = false, updatable = true)
	private double renda;

	@Column(name = "idade", nullable = false, updatable = true)
	private int idade = (int) ((Math.random() * (100 - 1)) + 1);

	public Pessoa(Double renda) {
		this.renda = renda;
	}

	public Pessoa() {
		this.renda = Math.round(Math.random() * ((500 - 0) + 1));
	}

}
