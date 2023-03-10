package br.com.cwi.sample.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AlterarUsuarioRequest {
    private String nome;

    @Size(min = 11, max = 11, message = "deve ter 11 caracteres")
    private String telefone;

    @Email(message = "deve ser válido")
    private String email;

    @Size(min = 8, max = 128, message = "deve ter entre 8 e 128 caracteres")
    private String senha;

    private String foto;
}
