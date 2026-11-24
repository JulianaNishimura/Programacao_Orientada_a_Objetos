package org.example.exams.exam02.service;

import persistence.DeclaracaoDao;
import persistence.DeclaracaoDto;
import persistence.DespesaDao;

import java.util.NoSuchElementException;

public class ExcluirSimulacaoService {
    private final DeclaracaoDao declaracaoDao;
    private final DespesaDao despesaDao;

    public ExcluirSimulacaoService(DeclaracaoDao declaracaoDao, DespesaDao despesaDao) {
        this.declaracaoDao = declaracaoDao;
        this.despesaDao = despesaDao;
    }

    public void excluir(){
        final DeclaracaoDto completa = declaracaoDao.buscarPorId(1)
                .orElseThrow(() -> new NoSuchElementException("Simulação não encontrada"));
        final DeclaracaoDto simplificada = declaracaoDao.buscarPorId(2)
                .orElseThrow(() -> new NoSuchElementException("Simulação não encontrada"));

        declaracaoDao.remover(completa);
        declaracaoDao.remover(simplificada);
        despesaDao.removerTodosPorDeclaracao(1);
    }
}
