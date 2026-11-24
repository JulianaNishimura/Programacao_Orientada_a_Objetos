package org.example.exams.exam02.model;

import java.util.Objects;

public abstract sealed class Declaracao permits DeclaracaoCompleta, DeclaracaoSimplificada{
    private final int id;
    private final double ganhoTributavel;
    private final double valorJaPago;

    public Declaracao(int id, double ganhoTributavel, double valorJaPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorJaPago = valorJaPago;
    }

    public final double valorAPagar(){
        return valorImposto() - valorJaPago;
    }

    protected abstract double valorImposto();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("id = %d, ganho tributável = %.2f, valor já pago = %.2f, valor a pagar = %.2f",
                id, ganhoTributavel, valorJaPago, valorAPagar());
    }

    public int getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorJaPago() {
        return valorJaPago;
    }
}
