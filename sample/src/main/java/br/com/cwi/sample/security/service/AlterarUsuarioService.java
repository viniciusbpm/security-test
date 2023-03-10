package br.com.cwi.sample.security.service;

import br.com.cwi.sample.security.controller.request.AlterarUsuarioRequest;
import br.com.cwi.sample.security.controller.response.UsuarioResponse;
import br.com.cwi.sample.security.domain.Usuario;
import br.com.cwi.sample.security.repository.UsuarioRepository;
import br.com.cwi.sample.service.core.BuscarUsuarioService;
import br.com.cwi.sample.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.sample.security.mapper.UsuarioMapper.toResponse;
import static java.util.Objects.nonNull;

@Service
public class AlterarUsuarioService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NowService nowService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public UsuarioResponse alterar(AlterarUsuarioRequest request){
        Usuario usuario = usuarioAutenticadoService.get();

        if(nonNull(request.getNome())){
            usuario.setNome(request.getNome());
        }

        if(nonNull(request.getTelefone())){
            usuario.setTelefone(request.getTelefone());
        }

        if(nonNull(request.getEmail())){
            usuario.setEmail(request.getEmail());
        }

        if(nonNull(request.getFoto())){
            usuario.setFoto(request.getFoto());
        }

        if(nonNull(request.getSenha())){
            usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        }

        usuario.setAtualizadoEm(nowService.getDateTime());

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
