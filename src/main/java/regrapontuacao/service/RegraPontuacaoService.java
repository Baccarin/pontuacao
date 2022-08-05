package regrapontuacao.service;

import regrapontuacao.domain.Familia;

public interface RegraPontuacaoService {

	int pontuacaoPorRenda(Familia familia);

	int pontuacaoPorDependentes(Familia familia);

}
