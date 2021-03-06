package br.com.whiz.domain;

import br.com.whiz.enums.TipoFuncionario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Funcionario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date nascimento;
    private Integer tipoFuncionario;
    private String cpf;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.REMOVE)
    private List<Endereco> enderecos = new ArrayList<>();

    public Funcionario(){
    }

    public Funcionario(Long id, String name,String cpf, Date nascimento, TipoFuncionario tipoFuncionario){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.tipoFuncionario = (tipoFuncionario == null) ? null : tipoFuncionario.getCod();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public TipoFuncionario getTipoFuncionario() {
        return TipoFuncionario.toEnum(tipoFuncionario);
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
