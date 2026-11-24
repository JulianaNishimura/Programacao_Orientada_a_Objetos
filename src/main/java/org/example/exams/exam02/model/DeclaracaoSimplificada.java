package org.example.exams.exam02.model;

public final class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    protected double valorImposto() {
        final double ganhos = getGanhoTributavel();
        if(ganhos <= 22_847.88) return 0.0;
        return (ganhos - 22_847.88) * 0.2;
    }

    @Override
    public String toString() {
        return "Declaracao Simplificada: " + super.toString();
    }
}
