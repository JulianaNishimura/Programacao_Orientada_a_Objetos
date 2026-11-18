package org.example.exams.exam02.persistence;

import org.example.exams.exam02.model.Declaracao;

import java.util.Optional;

public interface DeclaracaoDAO {
    void salvar(Declaracao d);
    void atualizar(Declaracao d);
    void remover(Declaracao d);
    Optional<Declaracao> buscar(int id);
}
