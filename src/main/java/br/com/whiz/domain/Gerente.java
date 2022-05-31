package br.com.whiz.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

@Entity
@JsonTypeName("gerente")
public class Gerente extends Funcionario{

    private Float salario;

    public Gerente(){

    }

    public Gerente(Float salario) {
        this.salario = salario;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }
}
