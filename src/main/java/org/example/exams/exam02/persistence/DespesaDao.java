package org.example.exams.exam02.persistence;

import model.Despesa;

import java.util.List;

public interface DespesaDao {
    void salvar(DespesaDto despesa);
    List<DespesaDto> buscarTodosPorDeclaracao(int id);
    void removerTodosPorDeclaracao(int id);
}
