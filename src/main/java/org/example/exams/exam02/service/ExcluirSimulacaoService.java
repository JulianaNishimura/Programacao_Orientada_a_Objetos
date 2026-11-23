package org.example.exams.exam02.service;

import org.example.exams.exam02.model.Declaracao;
import org.example.exams.exam02.persistence.DeclaracaoDAO;

import java.util.NoSuchElementException;

public class ExcluirSimulacaoService {
    private final DeclaracaoDAO dao;

    public ExcluirSimulacaoService(DeclaracaoDAO dao){
        this.dao = dao;
    }

    public void excluir() throws NoSuchElementException {
        final Declaracao declaracaoCompleta = dao.buscar(1)
                .orElseThrow(() -> new NoSuchElementException("Simulação não iniciada"));

        final Declaracao declaracaoSimplificada = dao.buscar(2)
                .orElseThrow(() -> new NoSuchElementException("Simulação não iniciada"));

        dao.remover(declaracaoSimplificada);
        dao.remover(declaracaoCompleta);
    }
}
