package org.example.practiceExams.exam02;

public sealed interface Urna permits UrnaImpl{
    void carregar();
    void votar(String string,Cargo cargo);
    void imprimir();
}
