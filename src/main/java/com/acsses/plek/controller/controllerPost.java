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

import com.acsses.plek.model.Post;
import com.acsses.plek.repository.postagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class controllerPost {

	@Autowired
	private postagemRepository repository;

	@GetMapping
	public ResponseEntity<Object> buscarTudo() {
		List<Post> listPost = repository.findAll();

		if (listPost.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listPost);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/post/{categoriaEstabelecimento}")
	public ResponseEntity<List<Post>> GetByEstabelecimento(@PathVariable String categoriaEstabelecimento) {
		return ResponseEntity
				.ok(repository.findAllByCategoriaEstabelecimentoContainingIgnoreCase(categoriaEstabelecimento));
	}

	@PostMapping
	public ResponseEntity<Post> post(@RequestBody Post Post) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Post));

	}

	@PutMapping("/put")
	public ResponseEntity<Post> put(@RequestBody Post post) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(post));

	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
