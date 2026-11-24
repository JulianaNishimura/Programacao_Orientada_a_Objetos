package org.example.exams.exam02.service;


import org.example.exams.exam02.model.*;
import org.example.exams.exam02.persistence.DeclaracaoDao;
import org.example.exams.exam02.persistence.DeclaracaoDto;
import org.example.exams.exam02.persistence.DespesaDao;
import org.example.exams.exam02.persistence.DespesaDto;

import java.util.NoSuchElementException;

public class RelatorioSimulacaoService {
    private final DeclaracaoDao declaracaoDao;
    private final DespesaDao despesaDao;

    public RelatorioSimulacaoService(DeclaracaoDao declaracaoDao, DespesaDao despesaDao) {
        this.declaracaoDao = declaracaoDao;
        this.despesaDao = despesaDao;
    }

    public String criarRelatorio(){
        final DeclaracaoDto completa = declaracaoDao.buscarPorId(1)
                .orElseThrow(() -> new NoSuchElementException("Simulação não encontrada"));
        final DeclaracaoDto simplificada = declaracaoDao.buscarPorId(2)
                .orElseThrow(() -> new NoSuchElementException("Simulação não encontrada"));

        DeclaracaoCompleta completaEntity = (DeclaracaoCompleta) toDeclaracaoEntity(completa);

        despesaDao.buscarTodosPorDeclaracao(1).stream()
                .map(this::toDespesaEntity)
                .forEach(completaEntity::addDespesa);

        return toDeclaracaoEntity(simplificada) + "\n\n" + completaEntity;
    }

    public Declaracao toDeclaracaoEntity(DeclaracaoDto dto){
        return (dto.tipo().equals("completa"))
                ? new DeclaracaoCompleta(dto.id(), dto.ganhoTributavel(), dto.valorPago())
                : new DeclaracaoSimplificada(dto.id(), dto.ganhoTributavel(), dto.valorPago());
    }

    public Despesa toDespesaEntity(DespesaDto dto){
        return (dto.tipo().equals("saúde"))
                ? new DespesaSaude(dto.id(), dto.valor(), dto.nome(), dto.cnpj(), dto.info())
                : new DespesaEducacao(dto.id(), dto.valor(), dto.nome(), dto.cnpj(), dto.info());
    }
}
