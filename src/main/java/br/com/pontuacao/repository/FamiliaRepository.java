package br.com.pontuacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontuacao.domain.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Long>{

}
