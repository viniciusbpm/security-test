package br.com.cwi.sample.security.service;


import br.com.cwi.sample.security.domain.Usuario;
import br.com.cwi.sample.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Service
public class ValidaEmailJaExisteService {

    public static String MENSAGEM_EMAIL_JA_CADASTRADO = "O email informado já foi cadastrado";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(Usuario usuario){
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_EMAIL_JA_CADASTRADO);
        }
    }
}
