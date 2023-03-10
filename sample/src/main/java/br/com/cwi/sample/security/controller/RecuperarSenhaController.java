package br.com.cwi.sample.security.controller;

import br.com.cwi.sample.security.controller.request.EnviarEmailRecuperacaoRequest;
import br.com.cwi.sample.security.controller.request.AlterarSenhaRequest;
import br.com.cwi.sample.security.service.AlterarSenhaService;
import br.com.cwi.sample.security.service.EnviarEmailRecuperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/recuperar")
public class RecuperarSenhaController {

    @Autowired
    private EnviarEmailRecuperacaoService enviarEmailRecuperacaoService;

    @Autowired
    private AlterarSenhaService alterarSenhaService;

    @PostMapping("/enviaremail")
    public void enviarEmail(@RequestBody @Valid EnviarEmailRecuperacaoRequest request){
        enviarEmailRecuperacaoService.enviar(request);
    }

    @PutMapping("/alterar")
    public void alterarSenha(@RequestBody @Valid AlterarSenhaRequest request){
        alterarSenhaService.alterar(request);
    }
}
