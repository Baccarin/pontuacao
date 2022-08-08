package br.com.pontuacao.service.impl;

import br.com.pontuacao.domain.Familia;
import br.com.pontuacao.service.RegraPontuacaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegraPontuacaoServiceImpl implements RegraPontuacaoService {
	
	/*
	 * 	RENDA NIVEL 1 ATÉ R$900
	 * 	RENDA NIVEL 2 ENTRE R$901 E R$1500
	 * 	NUMERO DEPENDENTES NIVEL 1: 3 OU MAIS
	 * 	NUMERO DEPENDENTES NIVEL 2: 2 OU 1
	 */
	
	private final int PONTUACAO_RENDA_MENOR_NIVEL1 = 5;
	private final int PONTUACAO_RENDA_ENTRE_NIVEL1_E_NIVEL2 = 3;
	private final int RENDA_MINIMA_NIVEL1 = 900;
	private final int RENDA_MINIMA_NIVEL2 = 1500;
	
	
	private final int DEPENDENTES_MINIMO_NIVEL1 = 3;
	private final int DEPENDENTES_MAXIMO_NIVEL2 = 2;
	private final int DEPENDENTES_MINMO_NIVEL2 = 1;
	private final int PONTUACAO_DEPENDENTES_NIVEL1 = 3;
	private final int PONTUACAO_DEPENDENTES_NIVEL2 = 2;

	
	
	@Override
	public int pontuacaoPorRenda(Familia familia) {
		if (familia.getRendaFamiliar() <= RENDA_MINIMA_NIVEL1) {
			return PONTUACAO_RENDA_MENOR_NIVEL1;
		} else if (RENDA_MINIMA_NIVEL2 >= familia.getRendaFamiliar() && familia.getRendaFamiliar() < RENDA_MINIMA_NIVEL1) {
			return PONTUACAO_RENDA_ENTRE_NIVEL1_E_NIVEL2;
		}
		return 0;
	}

	@Override
	public int pontuacaoPorDependentes(Familia familia) {
		if (familia.getQuantidadeDependentes() >= DEPENDENTES_MINIMO_NIVEL1) {
			return PONTUACAO_DEPENDENTES_NIVEL1;
		} else if (familia.getQuantidadeDependentes() >= DEPENDENTES_MINMO_NIVEL2 && familia.getQuantidadeDependentes() <= DEPENDENTES_MAXIMO_NIVEL2) {
			return PONTUACAO_DEPENDENTES_NIVEL2;
		}
		return 0;
	}

	@Override
	public void atualizaPontuacaoGeral(Familia familia) {
		familia.setPontuacao(pontuacaoPorDependentes(familia) + pontuacaoPorRenda(familia));
	}

}
