package org.example.exams.exam02.service;

import org.example.exams.exam02.model.DeclaracaoCompleta;
import org.example.exams.exam02.model.Despesa;
import org.example.exams.exam02.model.DespesaEducacao;
import org.example.exams.exam02.model.DespesaSaude;
import org.example.exams.exam02.persistence.DeclaracaoRepository;

public class AdicionarDespesaService {
    private DeclaracaoRepository repository;

    public AdicionarDespesaService(DeclaracaoRepository repository){
        this.repository = repository;
    }

    public void adicionar(String descricao, double valor, String cnpj, String nome, TipoDespesa tipoDespesa) throws IllegalStateException{
        DeclaracaoCompleta declaracaoCompleta = (DeclaracaoCompleta) repository.buscar(1).orElseThrow(() -> new IllegalStateException("Simulação não iniciada"));


        int id = declaracaoCompleta.getGastos().size() + 1;
        Despesa despesa;

        if(tipoDespesa == TipoDespesa.SAUDE){
            despesa = new DespesaSaude(cnpj,id,descricao,valor,nome);
        } else if(tipoDespesa == TipoDespesa.EDUCACAO){
            despesa = new DespesaEducacao(cnpj,id,descricao,valor,nome);
        } else {
            throw new IllegalArgumentException("Tipo de despesa inválido");
        }

        declaracaoCompleta.adicionarDespesa(despesa);
        repository.atualizar(1, declaracaoCompleta);
    }
}
