package org.example.practiceExams.exam02;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        final Urna urna = new UrnaImpl();

        final Random random = new Random();
        for (int i = 0; i < 1_000; i++) {
            urna.votar(String.valueOf(random.nextInt(90) + 10), Cargo.PRESIDENTE);
            urna.votar(String.valueOf(random.nextInt(90) + 10), Cargo.GOVERNADOR);
            urna.votar(String.valueOf(random.nextInt(90) + 10), Cargo.SENADOR);
            urna.votar(String.valueOf(random.nextInt(90) + 10), Cargo.DEPUTADO_ESTADUAL);
            urna.votar(String.valueOf(random.nextInt(90) + 10), Cargo.DEPUTADO_FEDERAL);
        }

        urna.imprimir();
    }
}
