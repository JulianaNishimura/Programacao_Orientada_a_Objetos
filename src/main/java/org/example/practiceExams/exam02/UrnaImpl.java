package org.example.practiceExams.exam02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UrnaImpl implements Urna{
    private int[] nulos;
    private int[] brancos;
    private Map<Integer,Partido> partidos;
    private Boletim boletim;

    public UrnaImpl() {
        carregar();
    }

    @Override
    public void carregar() {
        List<String> candidatosString = Utilitario.carregarCandidatos();

        for (String linha : candidatosString) {
            String[] dados = linha.split(";");

            int numero = Integer.parseInt(dados[3].trim());
            int numPartido = Integer.parseInt(dados[3].substring(0, 2).trim());

            Partido partido = partidos.get(numPartido);
            if (partido == null) {
                partido = new Partido(numPartido, dados[4].trim());
                partidos.put(numPartido, partido);
            }

            partido.addCandidato(new Candidato(dados[1].trim(), dados[0].trim(), numero, Cargo.valueOf(dados[2].trim().toUpperCase())));
        }

    }

    @Override
    public void votar() {

    }

    @Override
    public void imprimir() {

    }
}
