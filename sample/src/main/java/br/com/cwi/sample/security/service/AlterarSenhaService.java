package br.com.cwi.sample.security.service;

import br.com.cwi.sample.security.controller.request.AlterarSenhaRequest;
import br.com.cwi.sample.security.domain.Usuario;
import br.com.cwi.sample.security.repository.UsuarioRepository;
import br.com.cwi.sample.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AlterarSenhaService {

    public static String MENSAGEM_SENHAS_NAO_COINCIDEM = "As senhas não coincidem";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void alterar(AlterarSenhaRequest request){
        Usuario usuario = buscarUsuarioService.porToken(request.getToken());

        if(request.getNovaSenha().equals(request.getConfirmaNovaSenha())){
            usuario.setSenha(passwordEncoder.encode(request.getNovaSenha()));
            usuario.setTokenRecuperacaoSenha(null);
            usuarioRepository.save(usuario);
        } else throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_SENHAS_NAO_COINCIDEM);
    }
}
