package br.com.cwi.sample.security.service;

import br.com.cwi.sample.security.domain.Usuario;
import br.com.cwi.sample.security.repository.UsuarioRepository;
import br.com.cwi.sample.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;


    public void deletar(Long id) {
        Usuario usuario = buscarUsuarioService.porId(id);

        usuarioRepository.deleteById(id);
    }
}
