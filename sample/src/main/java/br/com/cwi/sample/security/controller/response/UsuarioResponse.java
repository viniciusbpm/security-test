package br.com.cwi.sample.security.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioResponse {
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    private boolean ativo;
    private String foto;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;
}