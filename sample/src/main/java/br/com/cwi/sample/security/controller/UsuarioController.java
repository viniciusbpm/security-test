package br.com.cwi.sample.security.controller;

import br.com.cwi.sample.security.controller.request.AlterarUsuarioRequest;
import br.com.cwi.sample.security.controller.request.UsuarioRequest;
import br.com.cwi.sample.security.controller.response.UsuarioResponse;
import br.com.cwi.sample.security.service.AlterarUsuarioService;
import br.com.cwi.sample.security.service.CadastrarUsuarioService;
import br.com.cwi.sample.security.service.DeletarUsuarioService;
import br.com.cwi.sample.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private AlterarUsuarioService alterarUsuarioService;

    @Autowired
    private DeletarUsuarioService deletarUsuarioService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @PostMapping
    public UsuarioResponse cadastrar(@RequestBody @Valid UsuarioRequest request){
        return cadastrarUsuarioService.cadastrar(request);
    }

    @GetMapping("/detalhar")
    public UsuarioResponse detalhar(){
        return usuarioAutenticadoService.getResponse();
    }

    @PutMapping("/alterar")
    public UsuarioResponse alterar(@RequestBody @Valid AlterarUsuarioRequest request){
        return alterarUsuarioService.alterar(request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        deletarUsuarioService.deletar(id);
    }
}
