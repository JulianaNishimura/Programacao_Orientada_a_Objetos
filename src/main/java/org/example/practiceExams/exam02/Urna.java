package org.example.practiceExams.exam02;

public sealed interface Urna permits UrnaImpl{
    public void carregar();
    public void votar(String string,Cargo cargo);
    public void imprimir();
}
