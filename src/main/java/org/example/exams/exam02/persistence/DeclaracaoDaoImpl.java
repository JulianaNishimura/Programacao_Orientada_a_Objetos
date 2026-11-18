package org.example.exams.exam02.persistence;

import org.example.exams.exam02.model.Declaracao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class DeclaracaoDaoImpl implements DeclaracaoDAO{
    private final Map<Integer, Declaracao> dados = new LinkedHashMap<>();

    @Override
    public void salvar(Declaracao d) {
        dados.put(d.getId(),d);
    }

    @Override
    public void atualizar(Declaracao d) {
        dados.replace(d.getId(),d);
    }

    @Override
    public void remover(Declaracao d) {
        dados.remove(d.getId());
    }

    @Override
    public Optional<Declaracao> buscar(int id) {
        return Optional.ofNullable(dados.get(id));
    }

}
