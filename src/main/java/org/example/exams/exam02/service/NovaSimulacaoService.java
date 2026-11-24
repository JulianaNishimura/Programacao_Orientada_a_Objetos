package org.example.exams.exam02.service;


import org.example.exams.exam02.exception.EntityAlreadyExists;
import org.example.exams.exam02.persistence.DeclaracaoDao;
import org.example.exams.exam02.persistence.DeclaracaoDto;

public class NovaSimulacaoService {
    private final DeclaracaoDao dao;

    public NovaSimulacaoService(DeclaracaoDao dao) {
        this.dao = dao;
    }

    public void iniciar(double ganhoTributavel, double valorJaPago){
        if(dao.buscarPorId(1).isPresent())
            throw new EntityAlreadyExists("Simulação já iniciada");

        final DeclaracaoDto completa = new DeclaracaoDto(1, "completa", ganhoTributavel, valorJaPago);
        final DeclaracaoDto simplicada = new DeclaracaoDto(2, "simplificada", ganhoTributavel, valorJaPago);

        dao.salvar(completa);
        dao.salvar(simplicada);
    }
}
