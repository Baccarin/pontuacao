package regrapontuacao.service.impl;

import regrapontuacao.domain.Familia;
import regrapontuacao.service.RegraPontuacaoService;

public class RegraPontuacaoServiceImpl implements RegraPontuacaoService {
	private int PONTUACAO_RENDA_MENOR_900 = 5;
	private int PONTUACAO_RENDA_ENTRE_900_E_1500 = 3;
	private int PONTUACAO_DEPENDENTES_MAIOR_IGUAL_TRES = 3;
	private int PONTUACAO_DEPENDENTES_ENTRE_UM_E_DOIS = 2;

	@Override
	public int pontuacaoPorRenda(Familia familia) {
		if (familia.getRendaFamiliar() < 900) {
			return PONTUACAO_RENDA_MENOR_900;
		} else if (1500 >= familia.getRendaFamiliar() && familia.getRendaFamiliar() <= 901) {
			return PONTUACAO_RENDA_ENTRE_900_E_1500;
		}
		return 0;
	}

	@Override
	public int pontuacaoPorDependentes(Familia familia) {
		if (familia.getQuantidadeDependentes() >= 3) {
			return PONTUACAO_DEPENDENTES_MAIOR_IGUAL_TRES;
		} else if (1 >= familia.getQuantidadeDependentes() && familia.getQuantidadeDependentes() <= 2) {
			return PONTUACAO_DEPENDENTES_ENTRE_UM_E_DOIS;
		}
		return 0;
	}
}
