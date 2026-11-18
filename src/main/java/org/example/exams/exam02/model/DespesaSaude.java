package org.example.exams.exam02.model;

import java.util.Objects;

public class DespesaSaude extends Despesa{
    public static final double DEDUCAO_MAX = 1500.0;
    private String registroConselho;

    public DespesaSaude(String cnpj, int id, String descricao, double valor,String registroConselho) {
        super(cnpj, id, descricao, valor);
        this.registroConselho = registroConselho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DespesaSaude that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(registroConselho, that.registroConselho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), registroConselho);
    }

    @Override
    public String toString() {
        return "DespesaSaude{" +
                "registroConselho='" + registroConselho + '\'' +
                '}';
    }
}
