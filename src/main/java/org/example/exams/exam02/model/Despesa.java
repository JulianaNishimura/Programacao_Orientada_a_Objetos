package org.example.exams.exam02.model;

import java.util.Objects;

public abstract class Despesa {
    private int id;
    private String descricao;
    private double valor;
    private String cnpj;

    protected Despesa(String cnpj, int id, String descricao, double valor) {
        this.cnpj = cnpj;
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Despesa despesa)) return false;
        return id == despesa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, cnpj);
    }

    @Override
    public String toString() {
        return String.format("id: %d, descricao: %s, cnpj: %s, valor: %.2f",id,descricao,cnpj,valor);
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCnpj() {
        return cnpj;
    }

}
