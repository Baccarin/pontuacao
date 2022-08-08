package br.com.pontuacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontuacao.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
