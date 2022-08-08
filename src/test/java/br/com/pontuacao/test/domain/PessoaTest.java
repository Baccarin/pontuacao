package br.com.pontuacao.test.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pontuacao.domain.Pessoa;
import br.com.pontuacao.main.MainApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class)
public class PessoaTest {

	private final double RENDA_MAXIMA = 500.0;
	private final Integer IDADE_MAXIMA = 100;
	
	@Test
	public void deveRetornarRendaMaiorQueZeroComSucesso() {
		Pessoa p = new Pessoa();
		assertTrue(p.getRenda() > 0);
	}
	
	@Test
	public void deveRetornarRendaMenorQueMaximaComSucesso() {
		Pessoa p = new Pessoa();
		assertTrue(p.getRenda() <= RENDA_MAXIMA);
	}
	
	@Test
	public void deveRetornarIdadeMenorQueMaximaComSucesso() {
		Pessoa p = new Pessoa();
		assertTrue(p.getIdade() <= IDADE_MAXIMA);
	}
	
	
}
