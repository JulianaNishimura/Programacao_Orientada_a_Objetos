package org.example.class07.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {

        // Elementos repetidos ("Java" e "C") propositalmente
        List<String> skills = List.of("Postgres", "Java", "Bash", "Java", "C", "C");

        // HashSet: sem repetição, SEM garantia de ordem. Mais rápido em geral.
        Set<String> hashSet = new HashSet<>(skills);

        // LinkedHashSet: sem repetição, mantém a ORDEM DE INSERÇÃO.
        Set<String> linkedHashSet = new LinkedHashSet<>(skills);

        // TreeSet: sem repetição, mantém os elementos ORDENADOS (ordem natural).
        Set<String> treeSet = new TreeSet<>(skills);

        System.out.println("Original      = " + skills);
        System.out.println("HashSet       = " + hashSet);
        System.out.println("LinkedHashSet = " + linkedHashSet);
        System.out.println("TreeSet       = " + treeSet);

        // TreeSet com critério de ordenação próprio (ordem inversa)
        Set<String> reverseTreeSet = new TreeSet<>(Comparator.reverseOrder());
        reverseTreeSet.addAll(skills);
        System.out.println("TreeSet inv.  = " + reverseTreeSet);

        // add retorna false se o elemento já existe
        System.out.println("\nadd(\"Java\") = " + hashSet.add("Java"));   // false
        System.out.println("add(\"Go\")   = " + hashSet.add("Go"));       // true

        System.out.println("contains(\"Bash\") = " + hashSet.contains("Bash"));
        hashSet.remove("Bash");
        System.out.println("Após remover Bash: contains = " + hashSet.contains("Bash"));
        System.out.println("size() = " + hashSet.size());

        // Métodos exclusivos do TreeSet (por ser ordenado)
        TreeSet<String> sorted = new TreeSet<>(skills);
        System.out.println("\nfirst() = " + sorted.first());
        System.out.println("last()  = " + sorted.last());

        // Observação:
        // - HashSet e LinkedHashSet aceitam um elemento null.
        // - TreeSet não aceita null (lança NullPointerException).
        // - Para objetos próprios, implemente equals e hashCode (HashSet)
        //   ou Comparable/Comparator (TreeSet).
    }
}
