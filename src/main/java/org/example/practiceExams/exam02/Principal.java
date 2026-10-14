package org.example.practiceExams.exam02;

public class Principal {
    public static void main(String[] args) {
        Utilitario.carregarCandidatos().forEach(System.out::println);
    }
}
