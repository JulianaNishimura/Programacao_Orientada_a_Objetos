package org.example.exams.exam02.service;

import org.example.exams.exam02.model.DeclaracaoCompleta;
import org.example.exams.exam02.model.Despesa;
import org.example.exams.exam02.model.DespesaEducacao;
import org.example.exams.exam02.model.DespesaSaude;
import org.example.exams.exam02.persistence.DeclaracaoDAO;

public class AdicionarDespesaService {
    private final DeclaracaoDAO dao;

    public AdicionarDespesaService(DeclaracaoDAO dao){
        this.dao = dao;
    }

    public void adicionar(String descricao, double valor, String cnpj, String nome, TipoDespesa tipoDespesa) throws IllegalStateException{
        final DeclaracaoCompleta declaracaoCompleta = (DeclaracaoCompleta) dao.buscar(1)
                .orElseThrow(() -> new IllegalStateException("Simulação não iniciada"));

        int id = declaracaoCompleta.getGastos().size() + 1;
        Despesa despesa = (tipoDespesa == tipoDespesa.EDUCACAO)
                ? new DespesaEducacao(cnpj,id,descricao,valor,nome)
                :new DespesaSaude(cnpj,id,descricao,valor,nome);

        declaracaoCompleta.adicionarDespesa(despesa);
        dao.atualizar(declaracaoCompleta);
    }
}
