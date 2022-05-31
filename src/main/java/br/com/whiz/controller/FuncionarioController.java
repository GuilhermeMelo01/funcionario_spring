package br.com.whiz.controller;

import br.com.whiz.domain.Funcionario;
import br.com.whiz.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping(value = "all")
    public List<Funcionario> listAll(){
        return funcionarioService.listAll();
    }


}
