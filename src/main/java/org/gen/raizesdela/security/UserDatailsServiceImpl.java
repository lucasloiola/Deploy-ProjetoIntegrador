package org.gen.raizesdela.security;

import java.util.Optional;

import org.gen.raizesdela.model.Usuario;
import org.gen.raizesdela.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDatailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioRepository userRepository;
	@Override
	public UserDetails loadUserByUsername (String userEmail) throws UsernameNotFoundException{
		Optional<Usuario> user = userRepository.findAllByEmailContainingIgnoreCase(userEmail);
		user.orElseThrow(() -> new UsernameNotFoundException(userEmail + " not found."));
		return user.map(UserDatailsImpl::new).get();
	}
}
