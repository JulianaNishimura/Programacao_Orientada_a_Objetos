package org.example.exams.exam02.persistence;

import org.example.exams.exam02.model.Declaracao;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DeclaracaoRepositoryImpl implements DeclaracaoRepository {
    private static final Map<Integer,Declaracao> declaracoes = new HashMap<>();

    public DeclaracaoRepositoryImpl() {
    }

    @Override
    public boolean salvar(Declaracao d) {
        if(d == null) return false;
        declaracoes.put(d.getId(),d);
        return true;
    }

    @Override
    public boolean atualizar(int id, Declaracao d) {
        if(d == null) return false;
        return declaracoes.replace(id,d) != null;
    }

    @Override
    public boolean remover(int id) {
        return declaracoes.remove(id) != null;
    }

    @Override
    public Optional<Declaracao> buscar(int id) {
        return Optional.ofNullable(declaracoes.get(id));
    }
}
