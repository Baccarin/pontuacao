package br.com.pontuacao.main;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pontuacao.domain.Familia;
import br.com.pontuacao.service.RegraPontuacaoService;

@SpringBootApplication
public class MainApp {


	public static void main(String[] args) {

		
		Familia familia = new Familia();
		
		familia.addMembro();
		familia.addMembro();
		familia.addMembro();
		
		System.out.println(familia.getRendaFamiliar());
		familia.getMembros().forEach(membro -> System.out.println(membro.getIdade()));
		System.out.println(familia.getQuantidadeDependentes());
		
	
		
		System.out.println(familia.getPontuacao());

	}

}
