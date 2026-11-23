package org.example.exams.exam02.service;

import org.example.exams.exam02.model.*;
import org.example.exams.exam02.persistence.DeclaracaoDAO;

import java.util.List;
import java.util.NoSuchElementException;

public class RelatorioSimulacaoService {
    private final DeclaracaoDAO dao;

    public RelatorioSimulacaoService(DeclaracaoDAO dao){
        this.dao = dao;
    }

    public String criarRelatorio() throws NoSuchElementException {
        final Declaracao declaracaoCompleta = dao.buscar(1)
                .orElseThrow(() -> new NoSuchElementException("Simulação não iniciada"));

        final Declaracao declaracaoSimplificada = dao.buscar(2)
                .orElseThrow(() -> new NoSuchElementException("Simulação não iniciada"));

        return declaracaoSimplificada + "\n\n" + declaracaoCompleta;
    }
}
