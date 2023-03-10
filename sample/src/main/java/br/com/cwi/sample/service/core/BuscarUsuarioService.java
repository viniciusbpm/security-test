package br.com.cwi.sample.service.core;

import br.com.cwi.sample.security.domain.Usuario;
import br.com.cwi.sample.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarUsuarioService {

    public static String MENSAGEM_USUARIO_INEXISTENTE = "Usuário inexistente";

    public static String MENSAGEM_TOKEN_INCORRETO = "Token incorreto";

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario porId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIO_INEXISTENTE));
    }

    public Usuario porEmail(String email){
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIO_INEXISTENTE));
    }

    public Usuario porToken(String token){
        return usuarioRepository.findByTokenRecuperacaoSenha(token)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, MENSAGEM_TOKEN_INCORRETO));
    }


}
