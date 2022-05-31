package br.com.whiz.service;

import br.com.whiz.domain.Endereco;
import br.com.whiz.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listAll(){
        return enderecoRepository.findAll();
    }




}
