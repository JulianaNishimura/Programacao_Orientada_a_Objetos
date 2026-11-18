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

    public int getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorJaPago() {
        return valorJaPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Declaracao that)) return false;
        return id == that.id && Double.compare(ganhoTributavel, that.ganhoTributavel) == 0 && Double.compare(valorJaPago, that.valorJaPago) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ganhoTributavel, valorJaPago);
    }

    @Override
    public String toString() {
        return "Declaracao{" +
                "id=" + id +
                ", ganhoTributavel=" + ganhoTributavel +
                ", valorJaPago=" + valorJaPago +
                '}';
    }
}
