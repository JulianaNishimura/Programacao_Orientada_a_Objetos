package org.example.class05.SealedAndFinalClasses;

public sealed class Employee permits Manager, Developer {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}