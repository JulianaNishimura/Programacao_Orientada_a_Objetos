package org.example.exams.exam02.model;

import java.util.Objects;

public abstract sealed class Despesa permits DespesaSaude, DespesaEducacao{
    private final int id;
    private final double valor;
    private final String nome;
    private final String cnpj;

    public Despesa(int id, double valor, String nome, String cnpj) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return id == despesa.id;
    }

    @Override
    public String toString() {
        return String.format("id = %d, nome = %s, cnpj = %s, valor = %.2f", id, nome, cnpj, valor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }
}
