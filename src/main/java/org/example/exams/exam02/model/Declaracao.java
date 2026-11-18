package org.example.exams.exam02.model;

import java.util.Objects;

public abstract class Declaracao {
    private int id;
    private double ganhoTributavel;
    private double valorJaPago;

    protected Declaracao(int id, double ganhoTributavel, double valorJaPago) {
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
        if (this == o) return true;
        if (!(o instanceof Declaracao that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ganhoTributavel, valorJaPago);
    }

    @Override
    public String toString() {
        return String.format("id: %d, Ganho Tributavel = %.2f, valor Ja Pago: %.2f", id,ganhoTributavel,valorJaPago);
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
