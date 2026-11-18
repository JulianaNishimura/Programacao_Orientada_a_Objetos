package org.example.class05.abstractClasses;

public class Main {
    public static void main(String[] args) {

        Animal[] animais = { new Cachorro("Rex"), new Gato("Mimi") };

        for (Animal animal : animais) {
            animal.apresentar();
            animal.emitirSom();
        }
    }
}
