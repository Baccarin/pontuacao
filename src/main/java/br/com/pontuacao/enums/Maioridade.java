package br.com.pontuacao.enums;

public enum Maioridade {
	IDADE_MAIORIDADE (18);
	
	private int idadeMaioridade;
	
	Maioridade(int idade) {
		this.idadeMaioridade = idade;
	}
	
	public int getIdadeMaioridade() {
		return this.idadeMaioridade;
	}
}
