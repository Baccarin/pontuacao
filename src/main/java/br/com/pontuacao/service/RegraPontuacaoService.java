package br.com.pontuacao.service;

import org.springframework.stereotype.Service;

import br.com.pontuacao.domain.Familia;

@Service
public interface RegraPontuacaoService {

	int pontuacaoPorRenda(Familia familia);
	
	int pontuacaoPorDependentes(Familia familia);
	
	void atualizaPontuacaoGeral(Familia familia);
	
}
