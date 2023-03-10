package br.com.cwi.sample.security.repository;

import br.com.cwi.sample.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByTokenRecuperacaoSenha(String token);

    boolean existsByEmail(String email);
    Optional<Usuario> findById(Long id);
}
