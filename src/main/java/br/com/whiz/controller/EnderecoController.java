package br.com.whiz.controller;

import br.com.whiz.domain.Endereco;
import br.com.whiz.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @RequestMapping(value = "all")
    public List<Endereco> listAll(){
        return enderecoService.listAll();
    }


}
