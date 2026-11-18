package org.example.class05.abstractClasses;

public abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public abstract void emitirSom();

    public void apresentar() {
        System.out.println("Meu nome é " + nome);
    }
}
