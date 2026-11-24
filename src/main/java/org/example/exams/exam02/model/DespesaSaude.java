package org.example.exams.exam02.model;

public final class DespesaSaude extends Despesa {
    public static final double MAX_GASTO = 1_500.00;
    private final String registroConselho;

    public DespesaSaude(int id, double valor, String nome, String cnpj, String registroConselho) {
        super(id, valor, nome, cnpj);
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return "Despesa saúde: " + super.toString() + ", registro no conselho = " + registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }
}
