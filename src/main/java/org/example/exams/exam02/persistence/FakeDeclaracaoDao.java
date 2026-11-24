package org.example.exams.exam02.persistence;

import model.Declaracao;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FakeDeclaracaoDao implements DeclaracaoDao {
    private final Map<Integer, DeclaracaoDto> db = new LinkedHashMap<>();

    @Override
    public void salvar(DeclaracaoDto declaracao) {
        db.put(declaracao.id(), declaracao);
    }

    @Override
    public void atualizar(DeclaracaoDto declaracao) {
        db.replace(declaracao.id(), declaracao);
    }

    @Override
    public void remover(DeclaracaoDto declaracao) {
        db.remove(declaracao.id());
    }

    @Override
    public Optional<DeclaracaoDto> buscarPorId(int id) {
        return Optional.ofNullable(db.get(id));
    }
}
