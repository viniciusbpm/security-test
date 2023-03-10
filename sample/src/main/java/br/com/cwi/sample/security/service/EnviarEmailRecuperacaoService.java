package br.com.cwi.sample.security.service;

import br.com.cwi.sample.security.controller.request.EnviarEmailRecuperacaoRequest;
import br.com.cwi.sample.security.domain.Usuario;
import br.com.cwi.sample.security.repository.UsuarioRepository;
import br.com.cwi.sample.service.core.BuscarUsuarioService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailRecuperacaoService {
    public static String ASSUNTO_EMAIL_RECUPERACAO = "Recuperação de senha";

    public static String CORPO_EMAIL_RECUPERACAO = "Token de recuperação de senha: ";

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public void enviar(EnviarEmailRecuperacaoRequest request){

        Usuario usuario = buscarUsuarioService.porEmail(request.getEmail());

        String tokenRecuperacao = RandomString.make(5);

        emailService.enviarEmail(request.getEmail(), ASSUNTO_EMAIL_RECUPERACAO, (CORPO_EMAIL_RECUPERACAO + tokenRecuperacao));

        usuario.setTokenRecuperacaoSenha(tokenRecuperacao);

        usuarioRepository.save(usuario);
    }
}
