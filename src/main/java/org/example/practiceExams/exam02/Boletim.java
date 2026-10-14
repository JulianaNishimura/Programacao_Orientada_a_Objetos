package org.example.practiceExams.exam02;

import java.util.List;

public final class Boletim {
    private Boletim() {};

    public static String emitir(String nomeCargo, List<Candidato> candidatos, int brancos, int nulos) {
        StringBuilder sb = new StringBuilder();

        sb.append("BOLETIM DE URNA\n");
        sb.append("Cargo: ").append(nomeCargo).append('\n');
        sb.append("--------------------------------\n");

        for (Candidato candidato : candidatos) {
            sb.append(candidato.getNumero())
                    .append(" - ")
                    .append(candidato.getNomeUrna())
                    .append(": ")
                    .append(candidato.getVotos())
                    .append(" votos\n");
        }

        sb.append("Brancos: ").append(brancos).append('\n');
        sb.append("Nulos: ").append(nulos).append('\n');

        return sb.toString();
    }
}
