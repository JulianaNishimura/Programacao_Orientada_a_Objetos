package org.example.exams.exam02.service;

import org.example.exams.exam02.persistence.DeclaracaoRepository;

import java.util.NoSuchElementException;

public class ExcluirSimulacaoService {
    private DeclaracaoRepository repository;

    public ExcluirSimulacaoService(DeclaracaoRepository repository){
        this.repository = repository;
    }

    public void excluir() throws NoSuchElementException {
        if(repository.buscar(1).isEmpty() || repository.buscar(2).isEmpty()) throw new NoSuchElementException("Simulação não iniciada");

        repository.remover(1);
        repository.remover(2);
    }
}
