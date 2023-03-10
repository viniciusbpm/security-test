package br.com.cwi.sample.security.service;

import br.com.cwi.sample.security.controller.request.UsuarioRequest;
import br.com.cwi.sample.security.controller.response.UsuarioResponse;
import br.com.cwi.sample.security.domain.Permissao;
import br.com.cwi.sample.security.domain.Usuario;
import br.com.cwi.sample.security.repository.UsuarioRepository;
import br.com.cwi.sample.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.cwi.sample.security.domain.Funcao.USUARIO;
import static br.com.cwi.sample.security.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.sample.security.mapper.UsuarioMapper.toResponse;

@Service
public class CadastrarUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValidaEmailJaExisteService validaEmailJaExisteService;

    @Autowired
    private NowService nowService;

    public UsuarioResponse cadastrar(UsuarioRequest request) {

        Usuario usuario = toEntity(request);

        validaEmailJaExisteService.validar(usuario);

        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
        usuario.setAtivo(true);
        usuario.adicionarPermissao(getPermissaoPadrao());
        usuario.setCriadoEm(nowService.getDateTime());

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

    private Permissao getPermissaoPadrao() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }
}
