package br.com.pontuacao.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.pontuacao.enums.Maioridade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "familia", schema = "pontuacao", uniqueConstraints = {})
public class Familia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private List<Pessoa> membros = new ArrayList<>();

	@Column(name = "pontuacao", nullable = false, updatable = true)
	private Integer pontuacao = 0;

	public Familia(List<Pessoa> pessoas) {
		this.membros = pessoas;
	}

	public long getQuantidadeDependentes() {
		return membros.stream().filter(membro -> membro.getIdade() < Maioridade.IDADE_MAIORIDADE.getIdadeMaioridade()).count();
	}

	public double getRendaFamiliar() {
		return membros.stream().mapToDouble(Pessoa::getRenda).sum();
	}

	public void addMembro() {
		this.membros.add(new Pessoa());
	}

}
