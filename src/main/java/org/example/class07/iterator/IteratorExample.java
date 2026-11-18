package org.example.class07.iterator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IteratorExample {

    record Paycheck(LocalDate payday, double salary) {
    }

    // Classe que ENCAPSULA a sua coleção: não existe getPaychecks()
    static class Worker {
        private final String name;
        private final double salary;
        private final List<Paycheck> paychecks = new ArrayList<>();

        Worker(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        // A própria classe controla como os objetos entram na coleção
        public void createPaycheck(LocalDate payday) {
            paychecks.add(new Paycheck(payday, salary));
        }

        public void removePaycheck(Paycheck paycheck) {
            paychecks.remove(paycheck);
        }

        public int countPaychecks() {
            return paychecks.size();
        }

        // Devolve um iterador, não a lista. A versão "unmodifiable" ainda impede
        // que quem recebe o iterador remova elementos com iterator.remove().
        public Iterator<Paycheck> iteratorPaychecks() {
            return Collections.unmodifiableList(paychecks).iterator();
        }
    }

    public static void main(String[] args) {

        // ---------- 1. Acesso à coleção encapsulada via iterador ----------
        Worker ada = new Worker("Ada Lovelace", 10_000.0);
        ada.createPaycheck(LocalDate.now().plusMonths(1));
        ada.createPaycheck(LocalDate.now());
        // ada.getPaychecks();   // não existe: a lista interna não é exposta

        Iterator<Paycheck> iterator = ada.iteratorPaychecks();
        while (iterator.hasNext()) {                  // existe próximo elemento?
            Paycheck paycheck = iterator.next();      // pega o elemento e avança
            System.out.println(paycheck);
        }

        // O iterador devolvido não permite remover
        try {
            Iterator<Paycheck> other = ada.iteratorPaychecks();
            other.next();
            other.remove();
        } catch (UnsupportedOperationException e) {
            System.out.println("iterator.remove() bloqueado: UnsupportedOperationException");
        }

        ada.removePaycheck(new Paycheck(LocalDate.now(), 10_000.0));   // records têm equals pronto
        System.out.println("Contracheques restantes: " + ada.countPaychecks());

        // ---------- 2. Remover elementos durante a iteração ----------
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        // Errado: remover pela lista dentro do for-each lança exceção
        try {
            for (Integer n : numbers) {
                if (n == 1) {
                    numbers.remove(n);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("\nfor-each + list.remove(): ConcurrentModificationException");
        }

        // Certo: remover pelo próprio iterador
        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove();                          // remove o último elemento retornado por next()
            }
        }
        System.out.println("Sem os pares (via iterator.remove()): " + numbers);

        // ---------- 3. Iterator funciona em qualquer Collection ----------
        Set<String> skills = new TreeSet<>(Set.of("Java", "Bash", "Postgres"));
        Iterator<String> skillIterator = skills.iterator();
        System.out.print("\nSkills: ");
        while (skillIterator.hasNext()) {
            System.out.print(skillIterator.next() + " ");
        }
        System.out.println();
    }
}
