package com.acsses.plek.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acsses.plek.model.Usuario;
import com.acsses.plek.repository.usuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private usuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> user = userRepository.findByEmailUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. "));

		return user.map(UserDetailsImpl::new).get();
	}
}
