package org.example.extraExercises.ex1;

public final class IngressoCamarote extends IngressoVip{
    public IngressoCamarote(String evento, double valorBase, double taxaServico) {
        super(evento, valorBase, taxaServico);
    }
    @Override
    public double valorFinal(){
        return super.valorFinal()*1.2;
    }

    @Override
    public String toString() {
        return super.toString()+"[CAMAROTE]";
    }
}
