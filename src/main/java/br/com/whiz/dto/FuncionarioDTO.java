package br.com.whiz.dto;

import br.com.whiz.domain.Funcionario;
import br.com.whiz.enums.TipoFuncionario;

import java.io.Serializable;


public class FuncionarioDTO implements Serializable {

    private Long id;
    private String name;
    private TipoFuncionario tipoFuncionario;
    private String cpf;

    public FuncionarioDTO(){

    }

    public FuncionarioDTO(Funcionario funcionario){
        id = funcionario.getId();
        name = funcionario.getName();
        cpf = funcionario.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
