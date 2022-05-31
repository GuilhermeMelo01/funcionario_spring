package br.com.whiz.domain;


import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

@Entity
@JsonTypeName("vendedor")
public class Vendedor extends Funcionario{

    private float salario;

    public Vendedor() {
    }

    public Vendedor(float salario) {
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
