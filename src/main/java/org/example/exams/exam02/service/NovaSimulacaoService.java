package org.example.exams.exam02.service;

import org.example.exams.exam02.exception.EntityAlreadyExists;
import org.example.exams.exam02.model.Declaracao;
import org.example.exams.exam02.model.DeclaracaoCompleta;
import org.example.exams.exam02.model.DeclaracaoSimplificada;
import org.example.exams.exam02.persistence.DeclaracaoDAO;

public class NovaSimulacaoService {
    private final DeclaracaoDAO dao;

    public NovaSimulacaoService(DeclaracaoDAO dao){
        this.dao = dao;
    }

    public void iniciar(double ganhoTributavel, double valorJaPago) throws EntityAlreadyExists {

        final Declaracao declaracaoComp = new DeclaracaoCompleta(1,ganhoTributavel,valorJaPago);
        final Declaracao declaracaoSimp = new DeclaracaoSimplificada(2,ganhoTributavel,valorJaPago);

        if(dao.buscar(1).isPresent() || dao.buscar(2).isPresent()) throw new EntityAlreadyExists("Há uma simulação vigente");

        dao.salvar(declaracaoComp);
        dao.salvar(declaracaoSimp);
    }
}
