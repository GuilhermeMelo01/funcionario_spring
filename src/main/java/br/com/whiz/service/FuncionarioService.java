package br.com.whiz.service;

import br.com.whiz.domain.Cidade;
import br.com.whiz.domain.Endereco;
import br.com.whiz.domain.Funcionario;
import br.com.whiz.dto.FuncionarioDTO;
import br.com.whiz.dto.FuncionarioNewDTO;
import br.com.whiz.enums.TipoFuncionario;
import br.com.whiz.repository.EnderecoRepository;
import br.com.whiz.repository.FuncionarioRepository;
import br.com.whiz.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Funcionario> listAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    @Transactional
    public Funcionario insert(Funcionario funcionario) {
        funcionario = funcionarioRepository.save(funcionario);
        enderecoRepository.saveAll(funcionario.getEnderecos());
        return funcionario;

    }

    @Transactional
    public void update(Funcionario funcionario) {
        Funcionario newFuncionario = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
        updateData(newFuncionario, funcionario);
        funcionarioRepository.save(newFuncionario);
    }


    private void updateData(Funcionario newFuncionario, Funcionario funcionario) {
        newFuncionario.setName(funcionario.getName());
        newFuncionario.setCpf(funcionario.getCpf());
    }

    public Funcionario fromDto(FuncionarioDTO funcionarioDTO) {
        return new Funcionario(funcionarioDTO.getId(), funcionarioDTO.getName(), funcionarioDTO.getCpf(), null, null);
    }

    public Funcionario fromDto(FuncionarioNewDTO objNewDTO) {
        Funcionario funcionario = new Funcionario(null, objNewDTO.getName(), objNewDTO.getCpf(),
                objNewDTO.getNascimento(), TipoFuncionario.toEnum(objNewDTO.getTipoFuncionario()));
        Cidade cidade = new Cidade(objNewDTO.getCidadeId(), null, null);
        Endereco endereco = new Endereco(null, objNewDTO.getRua(), objNewDTO.getNumero(),
                objNewDTO.getBairro(), objNewDTO.getCep(), cidade,
                funcionario);

        funcionario.getEnderecos().add(endereco);
        return funcionario;
    }
}
