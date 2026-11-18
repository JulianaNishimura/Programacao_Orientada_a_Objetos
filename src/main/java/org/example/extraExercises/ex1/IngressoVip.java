package org.example.extraExercises.ex1;

public class IngressoVip extends Ingresso{
    private double taxaServico;

    public IngressoVip(String evento, double valorBase,double taxaServico) {
        super(evento, valorBase);
        this.taxaServico = taxaServico;
    }
    @Override
    public double valorFinal(){
        return super.valorFinal()+taxaServico;
    }

    @Override
    public String toString() {
        return	super.toString()+"[VIP, taxa="+taxaServico+"]";
    }
}
