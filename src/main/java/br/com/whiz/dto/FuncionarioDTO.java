package br.com.whiz.dto;

import br.com.whiz.domain.Funcionario;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class FuncionarioDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String name;
    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String cpf;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario funcionario) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
