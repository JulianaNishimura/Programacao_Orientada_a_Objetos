package org.example.exams.exam02.model;

public final class DespesaEducacao extends Despesa {
    public static final double MAX_GASTO = 2_000.00;
    private final String nomeInstituicao;

    public DespesaEducacao(int id, double valor, String nome, String cnpj, String nomeInstituicao) {
        super(id, valor, nome, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return "Despesa educação: " + super.toString() + ", nome instituição = " + nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
}
