package org.example.extraExercises.ex1;

import java.util.Locale;

public class Ingresso {
    private final String evento;
    private final double valorBase;

    public Ingresso(String evento, double valorBase){
        this.evento = evento;
        this.valorBase = valorBase;
    }

    public String getEvento() {
        return evento;
    }

    public double valorFinal(){
        return valorBase;
    }

    @Override
    public String toString() {
        return	String.format(Locale.US,"Ingresso[evento=%s,	valorBase=%.2f]",evento,valorBase);
    }
}
