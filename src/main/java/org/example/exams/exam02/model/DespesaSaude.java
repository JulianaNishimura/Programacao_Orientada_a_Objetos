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
    public String toString() {
        return super.toString() + "registro Conselho: " + registroConselho;
    }
}
