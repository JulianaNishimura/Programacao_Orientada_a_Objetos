package org.example.practiceExams.exam02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public final class UrnaImpl implements Urna{
    private int[] nulos;
    private int[] brancos;
    private Map<Integer,Partido> partidos;

    public UrnaImpl() {
        partidos = new HashMap<>();
        nulos = new int[5];
        brancos = new int[5];
        carregar();
    }

    @Override
    public void carregar() {
        List<String> candidatosString = Utilitario.carregarCandidatos();

        List<String[]> candidatosRaw = candidatosString.stream().skip(1).map(e -> e.split(";")).toList();

        for(String[] candidatoRaw : candidatosRaw){
            Candidato candidato = toCandidato(candidatoRaw[1],candidatoRaw[0],candidatoRaw[3],candidatoRaw[2]);
            final int numPartido = getNumPartido(candidato.getNumero());

            if (!partidos.containsKey(numPartido)) {
                Partido partido = toPartido(numPartido,candidatoRaw[4]);
                partidos.put(numPartido, partido);
            }

            partidos.get(numPartido).addCandidato(candidato);
        }
        imprimirPartidos();
        imprimirCandidatos();
    }

    private void imprimirCandidatos() {
        imprimirCandidatos(partidos.values().stream().map(Partido::getPresidente).filter(Objects::nonNull).toList(), "PRESIDENTE");
        imprimirCandidatos(partidos.values().stream().flatMap(Partido::getGovernadores).filter(Objects::nonNull).toList(), "GOVERNADOR");
        imprimirCandidatos(partidos.values().stream().flatMap(Partido::getCandidatosSenador).filter(Objects::nonNull).toList(), "SENADOR");
        imprimirCandidatos(partidos.values().stream().flatMap(Partido::getCandidatosDeputadoEstadual).toList(), "DEPUTADO ESTADUAL");
        imprimirCandidatos(partidos.values().stream().flatMap(Partido::getCandidatosDeputadoFederal).toList(), "DEPUTADO FEDERAL");
    }

    private void imprimirCandidatos(List<Candidato> candidatos, String nomeCargo) {
        StringBuilder builder = new StringBuilder("------------------- CANDIDATOS A " + nomeCargo + " ------------------\n");
        builder.append(String.format("%s %s %s %s\n",
                Utilitario.textoFixo("Nome", 40),
                Utilitario.textoFixo("Cargo", 25),
                Utilitario.textoFixo("Número", 10),
                Utilitario.textoFixo("Partido", 25)
        ));
        candidatos.forEach(e -> builder.append(buildCandidatoInfo(e)).append("\n"));
        System.out.println(builder);
    }

    private String buildCandidatoInfo(Candidato candidato) {
        final int numPartido = getNumPartido(candidato.getNumero());

        return String.format("%s %s %s %s",
                Utilitario.textoFixo(candidato.getNomeUrna(), 40),
                Utilitario.textoFixo(candidato.getCargo().toString(), 25),
                Utilitario.textoFixo(String.valueOf(candidato.getNumero()), 10),
                Utilitario.textoFixo(partidos.get(numPartido).getNome(), 25));
    }

    private void imprimirPartidos() {
        StringBuilder builder = new StringBuilder("--------------------------PARTIDOS--------------------------\n");
        builder.append(String.format("%s %s\n", Utilitario.textoFixo("Número", 10), Utilitario.textoFixo("Nome", 40)));
        partidos.values().forEach(e -> builder.append(e).append("\n"));
        System.out.println(builder);
    }

    @Override
    public void votar(String candidato, Cargo cargo) {
        if ("BRANCO".equals(candidato)) {
            switch (cargo) {
                case PRESIDENTE -> brancos[0]++;
                case GOVERNADOR -> brancos[1]++;
                case SENADOR -> brancos[2]++;
                case DEPUTADO_ESTADUAL -> brancos[3]++;
                case DEPUTADO_FEDERAL -> brancos[4]++;
            }
            return;
        }

        int numCandidato = Integer.parseInt(candidato);
        final int numPartido = getNumPartido(numCandidato);
        final Partido partido = partidos.get(numPartido);

        if(partido == null) {
            switch (cargo) {
                case PRESIDENTE -> nulos[0]++;
                case GOVERNADOR -> nulos[1]++;
                case SENADOR -> nulos[2]++;
                case DEPUTADO_ESTADUAL -> nulos[3]++;
                case DEPUTADO_FEDERAL -> nulos[4]++;
            }
            return;
        }

        switch (cargo) {
            case PRESIDENTE -> {
                if (partido.getPresidente() != null) {
                    partido.getPresidente().receberVoto();
                } else {
                    nulos[0]++;
                }
            }
            case GOVERNADOR -> votarGovernador(partido, numCandidato);
            case SENADOR -> votarSenador(partido, numCandidato);
            case DEPUTADO_ESTADUAL -> votarEstadual(partido, numCandidato);
            case DEPUTADO_FEDERAL -> votarFederal(partido, numCandidato);
        }

    }

    @Override
    public void imprimir() {
        System.out.println(Boletim.emitir("PRESIDENTE", partidos.values().stream().map(Partido::getPresidente).filter(Objects::nonNull).toList(), brancos[0], nulos[0]));
        System.out.println(Boletim.emitir("GOVERNADOR", partidos.values().stream().flatMap(Partido::getGovernadores).toList(), brancos[1], nulos[1]));
        System.out.println(Boletim.emitir("SENADOR", partidos.values().stream().flatMap(Partido::getCandidatosSenador).toList(), brancos[2], nulos[2]));
        System.out.println(Boletim.emitir("DEPUTADO ESTADUAL", partidos.values().stream().flatMap(Partido::getCandidatosDeputadoEstadual).toList(), brancos[3], nulos[3]));
        System.out.println(Boletim.emitir("DEPUTADO FEDERAL", partidos.values().stream().flatMap(Partido::getCandidatosDeputadoFederal).toList(), brancos[4], nulos[4]));
    }

    private void votarCandidato(Stream<Candidato> candidatos, int numero, int indice) {
        Candidato candidato = candidatos
                .filter(c -> c.getNumero() == numero)
                .findFirst()
                .orElse(null);

        if (candidato == null) {
            nulos[indice]++;
            return;
        }

        candidato.receberVoto();
    }

    private void votarGovernador(Partido partido, int numero) {
        votarCandidato(partido.getGovernadores(), numero, 1);
    }

    private void votarSenador(Partido partido, int numero) {
        votarCandidato(partido.getCandidatosSenador(), numero, 2);
    }

    private void votarEstadual(Partido partido, int numero) {
        votarCandidato(partido.getCandidatosDeputadoEstadual(), numero, 3);
    }

    private void votarFederal(Partido partido, int numero) {
        votarCandidato(partido.getCandidatosDeputadoFederal(), numero, 4);
    }

    private Candidato toCandidato(String nomeUrna, String nomeCompleto, String numero, String cargo){
        return new Candidato(
                nomeUrna,
                nomeCompleto,
                Integer.parseInt(numero),
                Cargo.valueOf(cargo.toUpperCase().replace(" ", "_"))
        );
    }

    private Partido toPartido(int numPartido, String nome){
        return new Partido(numPartido, nome);
    }

    private static int getNumPartido(int numCandidato) {
        return Integer.parseInt(String.valueOf(numCandidato).substring(0, 2));
    }
}
