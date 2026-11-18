package org.example.exams.exam02.model;

public class DeclaracaoSimplificada extends Declaracao{
    public DeclaracaoSimplificada(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    public double valorImposto(){
        if(super.getGanhoTributavel()>= 22847.88){
            return (super.getGanhoTributavel() - 22847.88)*0.2;
        }
        return 0;
    }

    @Override
    public java.lang.String toString() {
        return super.toString() + "Declaração Simplificada";
    }
}
