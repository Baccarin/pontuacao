package br.com.pontuacao.resource;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pontuacao.domain.Familia;
import br.com.pontuacao.repository.FamiliaRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("familia")
@RequiredArgsConstructor
public class FamiliaResource {

	private final FamiliaRepository repository;
	
	@GetMapping("/listaTodas")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Familia>> consultaFamilias() throws Exception {
		List<Familia> familias = repository.findAll();
		if (familias.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Familia>>(familias, HttpStatus.OK);
	}
	
	
	
	
}
