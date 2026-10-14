package org.example.practiceExams.exam02;

import java.util.Objects;

public class Candidato {
    private final String nomeUrna;
    private final String nomeCompleto;
    private final int numero;
    private long votos;
    private final Cargo cargo;

    public Candidato(String nomeUrna, String nomeCompleto, int numero, Cargo cargo) {
        this.nomeUrna = nomeUrna;
        this.nomeCompleto = nomeCompleto;
        this.numero = numero;
        this.cargo = cargo;
        this.votos = 0;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getNomeUrna() {
        return nomeUrna;
    }

    public long getVotos() {
        return votos;
    }

    public void receberVoto(){
        votos++;
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Candidato outro)) return false;

        return numero == outro.numero && cargo == outro.cargo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, cargo);
    }
}
