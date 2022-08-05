package regrapontuacao.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Familia {

	
	private List<Pessoa> membros = new ArrayList<Pessoa>();
	private Integer pontuacao = 0;

	public long getQuantidadeDependentes() {
		return membros.stream().filter(membro -> membro.getIdade() < 18).count();
	}

	public double getRendaFamiliar() {
		return membros.stream().mapToDouble(membro -> membro.getRenda()).sum();
	}
}
