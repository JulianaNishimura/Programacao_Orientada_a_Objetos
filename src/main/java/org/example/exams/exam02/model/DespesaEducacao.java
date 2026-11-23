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
    public String toString() {
        return super.toString() + "nome instituicao: " + nomeInstituicao;
    }
}
