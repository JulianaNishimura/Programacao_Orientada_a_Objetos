package org.example.exams.exam02.persistence;

import model.Declaracao;

import java.util.Optional;

public interface DeclaracaoDao {
    void salvar(DeclaracaoDto declaracao);
    void atualizar(DeclaracaoDto declaracao);
    void remover(DeclaracaoDto declaracao);
    Optional<DeclaracaoDto> buscarPorId(int id);
}
