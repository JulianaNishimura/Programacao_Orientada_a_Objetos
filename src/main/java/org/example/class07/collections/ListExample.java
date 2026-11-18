package org.example.class07.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        // ---------- ArrayList ----------
        // Usa um arranjo por baixo. Acesso por índice (get) é rápido.
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("Java");        // listas permitem elementos repetidos
        arrayList.add(1, "C");        // insere na posição 1

        System.out.println("ArrayList: " + arrayList);
        System.out.println("get(0) = " + arrayList.get(0));
        System.out.println("indexOf(\"Java\") = " + arrayList.indexOf("Java"));
        System.out.println("contains(\"Python\") = " + arrayList.contains("Python"));
        System.out.println("size() = " + arrayList.size());

        arrayList.remove("Java");     // remove a primeira ocorrência do elemento
        arrayList.remove(0);          // remove pela posição
        System.out.println("Após remover: " + arrayList);

        // ---------- LinkedList ----------
        // Lista duplamente encadeada. Inserir/remover no início ou fim é rápido,
        // mas acessar por índice (get) precisa percorrer a lista.
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("B");
        linkedList.add("C");
        linkedList.addFirst("A");     // métodos extras da LinkedList
        linkedList.addLast("D");
        System.out.println("\nLinkedList: " + linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("Após removeFirst e removeLast: " + linkedList);

        // ---------- Ordenação ----------
        List<String> names = new ArrayList<>(List.of("Hopper", "Ada", "von Neumann", "Turing"));

        Collections.sort(names);                                  // ordem natural (alfabética)
        System.out.println("\nOrdem alfabética: " + names);

        names.sort(Comparator.comparingInt(String::length));      // por tamanho do texto
        System.out.println("Por tamanho: " + names);

        names.sort(Comparator.reverseOrder());                    // ordem inversa
        System.out.println("Ordem inversa: " + names);

        // ---------- Listas imutáveis e de tamanho fixo ----------
        List<String> immutable = List.of("A", "B");               // não permite add/set/remove
        List<String> fixedSize = Arrays.asList("A", "B");         // permite set, mas não add/remove

        fixedSize.set(0, "Z");
        System.out.println("\nfixedSize após set: " + fixedSize);

        try {
            immutable.add("C");
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of() é imutável: UnsupportedOperationException");
        }

        try {
            fixedSize.add("C");
        } catch (UnsupportedOperationException e) {
            System.out.println("Arrays.asList() tem tamanho fixo: UnsupportedOperationException");
        }
    }
}
