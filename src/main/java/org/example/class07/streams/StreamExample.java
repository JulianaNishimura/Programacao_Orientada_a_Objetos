package org.example.class07.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    // Record: classe simples só com dados (Java 16+), evita escrever getters/construtor
    record Worker(String id, String name, String jobTitle, double salary,
                  int yearsOfService, Set<String> skills) {
    }

    public static void main(String[] args) {

        List<Worker> workers = List.of(
                new Worker("01", "Ada Lovelace", "Computer Programmer", 10_000.0, 0, Set.of("Math", "Algorithms")),
                new Worker("02", "David Huffman", "Computer Scientist", 10_700.0, 1, Set.of("Java", "Algorithms")),
                new Worker("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, 2, Set.of("Java", "Graphs")),
                new Worker("04", "John von Neumann", "Polymath", 35_400.0, 7, Set.of("Math", "Physics")));

        // ---------- Imperativo x Declarativo ----------
        // Imperativo: você diz COMO fazer, passo a passo
        List<Worker> imperative = new ArrayList<>();
        for (Worker w : workers) {
            if (w.jobTitle().equals("Computer Scientist")) {
                imperative.add(w);
            }
        }

        // Declarativo (stream): você diz O QUE quer
        List<Worker> declarative = workers.stream()
                .filter(w -> w.jobTitle().equals("Computer Scientist"))   // operação intermediária
                .toList();                                                // operação terminal

        System.out.println("Imperativo  : " + imperative.size() + " cientistas");
        System.out.println("Declarativo : " + declarative.size() + " cientistas");

        // ---------- map: transforma cada elemento ----------
        List<String> names = workers.stream()
                .map(Worker::name)                    // referência a método (igual a w -> w.name())
                .toList();
        System.out.println("\nNomes: " + names);

        // ---------- filter + forEach ----------
        System.out.println("\nContratados há mais de 1 ano:");
        workers.stream()
                .filter(w -> w.yearsOfService() > 1)
                .forEach(w -> System.out.println("  " + w.name()));

        // ---------- mapToDouble + average / sum ----------
        double average = workers.stream()
                .mapToDouble(Worker::salary)
                .average()
                .orElse(0);                           // valor padrão se a lista estiver vazia
        double total = workers.stream().mapToDouble(Worker::salary).sum();
        System.out.println("\nSalário médio = " + average);
        System.out.println("Soma dos salários = " + total);

        // ---------- flatMap: junta vários streams em um só ----------
        List<String> allSkills = workers.stream()
                .flatMap(w -> w.skills().stream())    // cada Worker gera um stream de skills
                .distinct()                           // remove repetidos
                .sorted()                             // ordem alfabética
                .toList();
        System.out.println("\nSkills da empresa: " + allSkills);

        // ---------- sorted com Comparator, max ----------
        List<String> bySalaryDesc = workers.stream()
                .sorted(Comparator.comparingDouble(Worker::salary).reversed())
                .map(Worker::name)
                .toList();
        System.out.println("\nPor salário (maior primeiro): " + bySalaryDesc);

        Optional<Worker> highest = workers.stream().max(Comparator.comparingDouble(Worker::salary));
        System.out.println("Maior salário: " + highest.map(Worker::name).orElse("ninguém"));

        // ---------- anyMatch, findFirst, count ----------
        boolean someoneRich = workers.stream().anyMatch(w -> w.salary() > 30_000);
        Optional<Worker> firstJavaDev = workers.stream()
                .filter(w -> w.skills().contains("Java"))
                .findFirst();
        long scientists = workers.stream().filter(w -> w.jobTitle().equals("Computer Scientist")).count();

        System.out.println("\nAlguém ganha mais de 30 mil? " + someoneRich);
        System.out.println("Primeiro que sabe Java: " + firstJavaDev.map(Worker::name).orElse("ninguém"));
        System.out.println("Quantidade de cientistas: " + scientists);

        // ---------- collect: reduz o stream a uma coleção/mapa ----------
        Map<String, List<String>> namesByJob = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::jobTitle,                                 // chave do mapa
                        TreeMap::new,                                     // mapa ordenado pelas chaves
                        Collectors.mapping(Worker::name, Collectors.toList())));
        System.out.println("\nNomes por cargo: " + namesByJob);

        // ---------- Os 4 tipos de referência a método ----------
        System.out.println();
        Stream.of("java", "object-orientation", "streams")
                .map(String::toUpperCase)             // método de instância de tipo arbitrário
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);        // método de instância de objeto específico
    }
}
