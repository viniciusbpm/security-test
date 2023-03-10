package br.com.cwi.sample.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EnviarEmailRecuperacaoRequest {
    @Email(message = "deve ser válido")
    @NotBlank(message = "não deve ser nulo")
    private String email;
}
