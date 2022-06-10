package br.com.whiz.controller;

import br.com.whiz.domain.Funcionario;
import br.com.whiz.dto.FuncionarioDTO;
import br.com.whiz.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FuncionarioDTO>> listAll(){
        List<Funcionario> funcionarios = funcionarioService.listAll();
        List<FuncionarioDTO> funcionarioDTO = funcionarios.stream().map(FuncionarioDTO::new).toList();
        return ResponseEntity.ok().body(funcionarioDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Funcionario> findById(@PathVariable long id){
        Funcionario funcionarioId = funcionarioService.findById(id);
        return ResponseEntity.ok().body(funcionarioId);
    }


}
