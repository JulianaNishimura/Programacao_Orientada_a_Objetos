package org.example.class07.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {

        // Mesmos dados inseridos em três mapas diferentes (chave = id, valor = nome)

        // HashMap: SEM garantia de ordem das chaves. Mais rápido em geral.
        Map<String, String> hashMap = new HashMap<>();

        // LinkedHashMap: mantém a ORDEM DE INSERÇÃO das chaves.
        Map<String, String> linkedHashMap = new LinkedHashMap<>();

        // TreeMap: mantém as chaves ORDENADAS (ordem natural das chaves).
        Map<String, String> treeMap = new TreeMap<>();

        fill(hashMap);
        fill(linkedHashMap);
        fill(treeMap);

        print("HashMap", hashMap);
        print("LinkedHashMap", linkedHashMap);
        print("TreeMap", treeMap);

        // TreeMap com ordem inversa das chaves
        Map<String, String> reverseTreeMap = new TreeMap<>(Comparator.reverseOrder());
        fill(reverseTreeMap);
        print("TreeMap (ordem inversa)", reverseTreeMap);

        // ---------- Principais métodos ----------
        System.out.println("\nget(\"03\") = " + hashMap.get("03"));
        System.out.println("get(\"99\") = " + hashMap.get("99"));                          // null
        System.out.println("getOrDefault(\"99\", \"Desconhecido\") = " + hashMap.getOrDefault("99", "Desconhecido"));
        System.out.println("containsKey(\"01\") = " + hashMap.containsKey("01"));
        System.out.println("containsValue(\"Turing\") = " + hashMap.containsValue("Turing"));

        hashMap.put("03", "John von Neumann");   // chave já existe: SUBSTITUI o valor
        hashMap.putIfAbsent("04", "Shannon");    // só insere se a chave não existir
        hashMap.replace("99", "Ninguém");        // chave não existe: ignora
        hashMap.remove("01");
        System.out.println("size() = " + hashMap.size());
        System.out.println("keySet() = " + hashMap.keySet());
        System.out.println("values() = " + hashMap.values());

        // ---------- Métodos exclusivos do TreeMap ----------
        TreeMap<String, String> sorted = new TreeMap<>(treeMap);
        System.out.println("\nfirstKey() = " + sorted.firstKey());
        System.out.println("lastKey()  = " + sorted.lastKey());

        // ---------- Exemplo prático: frequência de palavras ----------
        String[] words = {"java", "map", "java", "set", "map", "java"};
        Map<String, Integer> frequency = new TreeMap<>();     // TreeMap: saída em ordem alfabética

        for (String word : words) {
            // se a chave não existe, coloca 1; se existe, soma 1 ao valor atual
            frequency.merge(word, 1, Integer::sum);
        }
        System.out.println("\nFrequência: " + frequency);
    }

    private static void fill(Map<String, String> map) {
        map.put("03", "Edsger Dijkstra");
        map.put("01", "Ada Lovelace");
        map.put("02", "David Huffman");
    }

    private static void print(String title, Map<String, String> map) {
        System.out.println("\n" + title + ":");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
    }
}
