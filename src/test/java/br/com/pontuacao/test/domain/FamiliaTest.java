package br.com.pontuacao.test.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.pontuacao.domain.Familia;
import br.com.pontuacao.service.RegraPontuacaoService;

public class FamiliaTest {

	@Autowired
	private RegraPontuacaoService service;
	private final double RENDA_MAXIMA = 500.0;

	@Test
	public void deveRetornarDoisDependetesComSucesso() {
		Familia f = new Familia();
		f.addMembro();
		f.addMembro();
		
		f.getMembros().forEach(membro -> membro.setIdade(10));
		
		assertEquals(f.getQuantidadeDependentes(), 2);
	}
	
	@Test
	public void deveRetornarDoisMembrosComSucesso() {
		Familia f = new Familia();
		f.addMembro();
		f.addMembro();
		
		assertEquals(f.getMembros().size(), 2);
	}
	
	@Test
	public void deteRetornarQuantidadeErradaDependentes() {
		Familia f = new Familia();
		f.addMembro();
		f.addMembro();
		
		f.getMembros().forEach(membro -> membro.setIdade(5));
		assertEquals(f.getQuantidadeDependentes(), 0l);
	}
	
	@Test
	public void rendaMaximaPorPessoaNaoUltrapassada() {
		Familia f = new Familia();
		f.addMembro();
		
		assertTrue(f.getRendaFamiliar() <= RENDA_MAXIMA);
	}
	
	@Test
	public void deveRetornarFamiliaPontuacaoCincoPorRenda() {
		Familia f = new Familia();
		
		f.addMembro();
		f.addMembro();
		f.getMembros().forEach(membro -> membro.setRenda(250.0));
		f.getMembros().forEach(membro -> membro.setIdade(50));

		service.atualizaPontuacaoGeral(f);
		
		assertEquals(f.getPontuacao(), 5);
	}
	
	@Test
	public void deveRetornarFamiliaPontuacaoTresPorDependentes() {
		Familia f = new Familia();
		
		f.addMembro();
		f.addMembro();
		f.addMembro();
		
		f.getMembros().forEach(membro -> membro.setRenda(2500.0));
		f.getMembros().forEach(membro -> membro.setIdade(2));

		service.atualizaPontuacaoGeral(f);
		
		assertEquals(f.getPontuacao(), 3);
	}
	
}
