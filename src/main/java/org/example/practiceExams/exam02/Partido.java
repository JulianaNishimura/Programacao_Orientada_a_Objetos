package org.example.practiceExams.exam02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Partido {
    private final int numero;
    private final String nome;

    private Candidato presidente;
    private Map<Integer, Candidato> governador;
    private Map<Integer, Candidato> candidatosDeputadoEstadual;
    private Map<Integer, Candidato> candidatosDeputadoFederal;
    private Map<Integer, Candidato> candidatosSenador;

    public Partido(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.governador = new HashMap<>();
        this.candidatosDeputadoEstadual = new HashMap<>();
        this.candidatosDeputadoFederal = new HashMap<>();
        this.candidatosSenador = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Candidato getPresidente() {
        return presidente;
    }

    public Stream<Candidato> getGovernadores() {
        return governador.values().stream();
    }

    public Stream<Candidato> getCandidatosDeputadoEstadual() {
        return candidatosDeputadoEstadual.values().stream();
    }

    public Stream<Candidato> getCandidatosDeputadoFederal() {
        return candidatosDeputadoFederal.values().stream();
    }

    public Stream<Candidato> getCandidatosSenador() {
        return candidatosSenador.values().stream();
    }

    public void addCandidato(Candidato candidato) {
        int numero = candidato.getNumero();

        switch (candidato.getCargo()) {
            case PRESIDENTE -> presidente = candidato;
            case GOVERNADOR -> governador.put(numero, candidato);
            case SENADOR -> candidatosSenador.put(numero, candidato);
            case DEPUTADO_ESTADUAL -> candidatosDeputadoEstadual.put(numero, candidato);
            case DEPUTADO_FEDERAL -> candidatosDeputadoFederal.put(numero, candidato);
        }
    }

    public Candidato getCandidato(Cargo cargo, int numCandidato) {
        return switch (cargo) {
            case PRESIDENTE -> presidente != null && presidente.getNumero() == numCandidato ? presidente : null;
            case GOVERNADOR -> governador.get(numCandidato);
            case SENADOR -> candidatosSenador.get(numCandidato);
            case DEPUTADO_FEDERAL ->
                    candidatosDeputadoFederal.get(numCandidato);
            case DEPUTADO_ESTADUAL ->
                    candidatosDeputadoEstadual.get(numCandidato);
        };
    }

    @Override
    public String toString() {
        return  String.format("%s %s",Utilitario.textoFixo(String.valueOf(numero),10),Utilitario.textoFixo(nome,40));

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
