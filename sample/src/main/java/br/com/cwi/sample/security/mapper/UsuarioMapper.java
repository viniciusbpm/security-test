package br.com.cwi.sample.security.mapper;

import br.com.cwi.sample.security.controller.request.UsuarioRequest;
import br.com.cwi.sample.security.controller.response.UsuarioResponse;
import br.com.cwi.sample.security.domain.Usuario;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setTelefone(request.getTelefone());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setFoto(request.getFoto());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setTelefone(entity.getTelefone());
        response.setAtivo(entity.isAtivo());
        response.setCriadoEm(entity.getCriadoEm());
        response.setAtualizadoEm(entity.getAtualizadoEm());
        response.setEmail(entity.getEmail());
        response.setFoto(entity.getFoto());

        return response;
    }
}
