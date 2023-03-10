package br.com.cwi.sample.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AlterarSenhaRequest {

    @NotBlank(message = "não deve ser nulo")
    private String token;

    @NotBlank(message = "não deve ser nulo")
    @Size(min = 8, max = 128, message = "deve ter entre 8 e 128 caracteres")
    private String novaSenha;

    @NotBlank(message = "não deve ser nulo")
    @Size(min = 8, max = 128, message = "deve ter entre 8 e 128 caracteres")
    private String confirmaNovaSenha;
}
