package org.example.exams.exam02.persistence;

import org.example.exams.exam02.model.Declaracao;

import java.util.Optional;

public interface DeclaracaoRepository {
    boolean salvar(Declaracao d);
    boolean atualizar(int id,Declaracao d);
    boolean remover(int id);
    Optional<Declaracao> buscar(int id);
}
