/*
 * Model Post / Criação 02/08/2021
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

package com.acsses.plek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Post")
public class Post {

	/**
	 * Numero de idPost gerado automaticamente
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPost;

	@NotNull
	@Size(min = 5, max = 1000)
	private String categoriaEstabelecimento;

	@NotNull
	@Size(min = 5, max = 1000)
	private String tipoEstabelecimento;

	@NotNull
	@BatchSize(size = 1)
	private int avalicao;

	@NotNull
	@Size(min = 5, max = 1000)
	private String comentario;

	/**
	 * Realiza uma relação muitos para Um com a tabela Tema
	 * 
	 */
	@ManyToOne
	@JsonIgnoreProperties("post")
	private Tema tema;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public long getIdPost() {
		return idPost;
	}

	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}

	public String getCategoriaEstabelecimento() {
		return categoriaEstabelecimento;
	}

	public void setCategoriaEstabelecimento(String categoriaEstabelecimento) {
		this.categoriaEstabelecimento = categoriaEstabelecimento;
	}

	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public int getAvalicao() {
		return avalicao;
	}

	public void setAvalicao(int avalicao) {
		this.avalicao = avalicao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
