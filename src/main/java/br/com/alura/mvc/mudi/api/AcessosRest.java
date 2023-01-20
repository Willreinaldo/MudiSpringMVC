package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.interceptor.InteceptadorDeAcessos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("acessos")
@RestController
public class AcessosRest {
    @GetMapping
    public List<InteceptadorDeAcessos.Acesso> getAcessos() {

        return InteceptadorDeAcessos.acessos;

    }
}