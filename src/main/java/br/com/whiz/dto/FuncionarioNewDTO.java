package br.com.whiz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class FuncionarioNewDTO implements Serializable {


    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date nascimento;
    private Integer tipoFuncionario;
    private String cpf;

    private String rua;
    private Integer numero;
    private String bairro;
    private String cep;

    private Long cidadeId;

    public FuncionarioNewDTO(){

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

    public Integer getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(Integer tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
