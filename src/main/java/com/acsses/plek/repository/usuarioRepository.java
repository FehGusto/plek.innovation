/*
 * Repository Usuario responsavel pelo Controller Usuario / Criação 02/08/2021
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

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acsses.plek.model.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByEmailUsuario(String emailUsuario);

}
