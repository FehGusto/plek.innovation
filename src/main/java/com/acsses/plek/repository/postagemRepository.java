/*
 * Repository Postagem responsavel pelo Controller Post / Criação 02/08/2021
 * Todos os direitos reservados Acsses Local
 *
 * Version Beta 1.0
 * 
 * @autor Felipe Augusto
 * @autor Gabriel Conceição
 * @autora Regina Rodrigues
 * @autora Debora Cristina
 * @Mathues Moreira
 */

package com.acsses.plek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acsses.plek.model.Post;

@Repository
public interface postagemRepository extends JpaRepository<Post, Long> {
	/**
	 * FindBy responsavel pela busca especifica
	 * 
	 * @return Palavra digitada pelo usuario é buscada no banco de dados e retorna
	 *         com o corpo completo
	 */
	public List<Post> findAllByCategoriaEstabelecimentoContainingIgnoreCase(String categoriaEstabelecimento);

}
