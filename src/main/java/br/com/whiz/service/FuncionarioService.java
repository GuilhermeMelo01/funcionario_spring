package br.com.whiz.service;

import br.com.whiz.domain.Endereco;
import br.com.whiz.domain.Funcionario;
import br.com.whiz.repository.EnderecoRepository;
import br.com.whiz.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listAll(){
        return funcionarioRepository.findAll();
    }




}
