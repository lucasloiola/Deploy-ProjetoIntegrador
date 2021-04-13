package org.gen.raizesdela.repository;

import java.util.Optional;

import org.gen.raizesdela.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	public Optional<Usuario> findAllByEmailContainingIgnoreCase (String email);
}
