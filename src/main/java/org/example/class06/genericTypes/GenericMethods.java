package org.example.class06.genericTypes;
// Classe NÃO genérica com métodos genéricos
public class GenericMethods {

    private GenericMethods() {
    }

    // <T> antes do tipo de retorno declara o tipo genérico do método
    public static <T> void printAll(T[] items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    // Dois tipos genéricos: T e R
    public static <T, R> R printFirstReturnSecond(T first, R second) {
        System.out.println("Primeiro: " + first);
        return second;
    }
}
