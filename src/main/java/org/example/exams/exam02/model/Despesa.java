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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Despesa despesa)) return false;
        return id == despesa.id && Double.compare(valor, despesa.valor) == 0 && Objects.equals(descricao, despesa.descricao) && Objects.equals(cnpj, despesa.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, cnpj);
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
