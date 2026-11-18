package org.example.exams.exam02.model;

import java.util.Objects;

public class DespesaEducacao extends Despesa{
    public static final double DEDUCAO_MAX = 2000.0;
    private String nomeInstituicao;

    public DespesaEducacao(String cnpj, int id, String descricao, double valor, String nomeInstituicao) {
        super(cnpj, id, descricao, valor);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DespesaEducacao that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(nomeInstituicao, that.nomeInstituicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nomeInstituicao);
    }

    @Override
    public String toString() {
        return "DespesaEducacao{" +
                "nomeInstituicao='" + nomeInstituicao + '\'' +
                '}';
    }
}
