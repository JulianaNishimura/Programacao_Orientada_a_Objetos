package org.example.exams.exam02.service;

import org.example.exams.exam02.exception.EntityAlreadyExists;
import org.example.exams.exam02.model.Declaracao;
import org.example.exams.exam02.model.DeclaracaoCompleta;
import org.example.exams.exam02.model.DeclaracaoSimplificada;
import org.example.exams.exam02.persistence.DeclaracaoRepository;

public class NovaSimulacaoService {
    private DeclaracaoRepository repository;

    public NovaSimulacaoService(DeclaracaoRepository repository){
        this.repository = repository;
    }

    public void iniciar(double ganhoTributavel, double valorPagoAnterior) throws EntityAlreadyExists {
        Declaracao declaracaoComp = new DeclaracaoCompleta(1,ganhoTributavel,valorPagoAnterior);
        Declaracao declaracaoSimp = new DeclaracaoSimplificada(2,ganhoTributavel,valorPagoAnterior);

        if(repository.buscar(1).isPresent() || repository.buscar(2).isPresent()) throw new EntityAlreadyExists("Há uma simulação vigente");

        repository.salvar(declaracaoComp);
        repository.salvar(declaracaoSimp);
    }
}
