package com.acsses.plek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acsses.plek.model.Tema;
import com.acsses.plek.repository.temaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class controllerTema {

	@Autowired
	private temaRepository repository;

	@GetMapping
	public ResponseEntity<Object> buscarTudo() {
		List<Tema> listTema = repository.findAll();

		if (listTema.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listTema);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/especifico/{tipoUsuario}")
	public ResponseEntity<List<Tema>> GetByTitulo(@PathVariable String tipoUsuario) {
		return ResponseEntity.ok(repository.findAllByTipoUsuarioContainingIgnoreCase(tipoUsuario));

	}

	@PostMapping
	public ResponseEntity<Tema> post(@RequestBody Tema Tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Tema));

	}

	@PutMapping("/put")
	public ResponseEntity<Tema> put(@RequestBody Tema Tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Tema));

	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
