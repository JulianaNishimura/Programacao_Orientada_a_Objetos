package org.example.extraExercises.ex1;

public class IngressoMeia extends Ingresso{
    private String documento;

    public IngressoMeia(String evento, double valorBase,String documento) {
        super(evento, valorBase);
        this.documento = documento;
    }

    @Override
    public double valorFinal(){
        return super.valorFinal()/2;
    }

    @Override
    public String toString() {
        return super.toString()+"[MEIA, doc="+documento+"]";
    }
}
