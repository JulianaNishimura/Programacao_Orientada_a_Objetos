package org.example.practiceExams.exam02;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.example.practiceExams.exam02.Utilitario.textoFixo;

public final class Boletim {
    private Boletim() {};

    public static String emitir(String nomeCargo, List<Candidato> candidatos, int brancos, int nulos) {
        String dadosCandidatos = candidatos.stream().filter(Objects::nonNull).map(Boletim::toCandidatoData).collect(Collectors.joining("\n"));

        long nominais = candidatos.stream().mapToLong(Candidato::getVotos).sum();
        long total = nominais + brancos + nulos;

        return String.format("""
                ================ JUSTIÇA ELEITORAL ==============
                 Boletim de Urna
                ------------------------------%s------------------------------
                Nome Número Votos
                %s
                ----------------------------------------------------------------------------
                Total de votos Nominais: %d
                Brancos: %d
                Nulos: %d
                Total apurado: %d
                ---------------------------------------------------------------------------
                """, nomeCargo, dadosCandidatos, nominais, brancos, nulos, total);
    }

    private static String toCandidatoData(Candidato candidato){
        return String.format("%s %s %s",
                textoFixo(candidato.getNomeUrna().toUpperCase(), 40),
                textoFixo(String.valueOf(candidato.getNumero()), 10),
                textoFixo(String.valueOf(candidato.getVotos()), 10));
    }
}
