package org.example.practiceExams.exam02;

import java.util.Map;
import java.util.Objects;

public class Partido {
    private final int numero;
    private final String nome;

    private Map<Integer, Candidato> presidente;
    private Map<Integer, Candidato> governador;
    private Map<Integer, Candidato> candidatosDeputadoEstadual;
    private Map<Integer, Candidato> candidatosDeputadoFederal;
    private Map<Integer, Candidato> candidatosSenador;

    public Partido(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void addCandidato(Candidato candidato) {
        int numero = candidato.getNumero();

        switch (candidato.getCargo()) {
            case PRESIDENTE -> {
                if (presidente.containsKey(numero)) {
                    throw new IllegalArgumentException(
                            "Já existe um presidente com esse número."
                    );
                }
                presidente.put(numero, candidato);
            }
            case GOVERNADOR -> {
                if (governador.containsKey(numero)) {
                    throw new IllegalArgumentException(
                            "Já existe um governador com esse número."
                    );
                }
                governador.put(numero, candidato);
            }
            case SENADOR -> {
                if (candidatosSenador.containsKey(numero)) {
                    throw new IllegalArgumentException(
                            "Já existe um senador com esse número."
                    );
                }
                candidatosSenador.put(numero, candidato);
            }
            case DEPUTADO_ESTADUAL -> {
                if (candidatosDeputadoEstadual.containsKey(numero)) {
                    throw new IllegalArgumentException(
                            "Já existe um deputado estadual com esse número."
                    );
                }
                candidatosDeputadoEstadual.put(numero, candidato);
            }
            case DEPUTADO_FEDERAL -> {
                if (candidatosDeputadoFederal.containsKey(numero)) {
                    throw new IllegalArgumentException(
                            "Já existe um deputado federal com esse número."
                    );
                }
                candidatosDeputadoFederal.put(numero, candidato);
            }
        }
    }

    public Candidato getCandidato(Cargo cargo, int numCandidato) {
        return switch (cargo) {
            case PRESIDENTE -> presidente.get(numCandidato);
            case GOVERNADOR -> governador.get(numCandidato);
            case SENADOR -> candidatosSenador.get(numCandidato);
            case DEPUTADO_FEDERAL ->
                    candidatosDeputadoFederal.get(numCandidato);
            case DEPUTADO_ESTADUAL ->
                    candidatosDeputadoEstadual.get(numCandidato);
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Partido outro)) return false;

        return numero == outro.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
