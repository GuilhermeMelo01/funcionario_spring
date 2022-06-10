package br.com.whiz.dto;

import br.com.whiz.domain.Endereco;
import br.com.whiz.domain.Funcionario;
import br.com.whiz.enums.TipoFuncionario;
import com.sun.istack.NotNull;
import org.apache.catalina.LifecycleState;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FuncionarioDTO implements Serializable {

    private Long id;
    private String name;
    private Date nascimento;
    private TipoFuncionario tipoFuncionario;
    private String cpf;
    private List<Endereco> endereco;

    public FuncionarioDTO(Funcionario funcionario){
        id = funcionario.getId();
        name = funcionario.getName();
        cpf = funcionario.getCpf();
        tipoFuncionario = funcionario.getTipoFuncionario();
        nascimento = funcionario.getNascimento();
        endereco = funcionario.getEnderecos();
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
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

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
