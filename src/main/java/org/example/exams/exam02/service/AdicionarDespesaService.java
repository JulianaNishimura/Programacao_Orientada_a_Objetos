package org.example.exams.exam02.service;

import persistence.DeclaracaoDao;
import persistence.DespesaDao;
import persistence.DespesaDto;

public class AdicionarDespesaService {
    private final DeclaracaoDao declaracaoDao;
    private final DespesaDao despesaDao;

    public AdicionarDespesaService(DeclaracaoDao declaracaoDao, DespesaDao despesaDao) {
        this.declaracaoDao = declaracaoDao;
        this.despesaDao = despesaDao;
    }

    public void adicionar(int id, double valor, String nome, String cnpj, String info, TipoDespesa tipo){
        if(declaracaoDao.buscarPorId(1).isEmpty())
            throw new IllegalStateException("Simulação não iniciada");

        String tipoString = (tipo == TipoDespesa.EDUCACAO)? "educação" : "saúde";
        DespesaDto despesa = new DespesaDto(id, valor, nome, cnpj, info, tipoString, 1);

        despesaDao.salvar(despesa);
    }
}
