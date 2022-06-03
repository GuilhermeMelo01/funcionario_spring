package br.com.whiz.service;

import br.com.whiz.domain.Funcionario;
import br.com.whiz.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(long id){
        return funcionarioRepository.findById(id).orElseThrow();

    }




}
