package org.example.exams.exam02;

import persistence.*;
import service.*;

public class Main {
    static void main() {
        DeclaracaoDao daoDeclaracao = new JdbcDeclaracaoDao();
        DespesaDao daoDespesa = new JdbcDespesaDao();

        final NovaSimulacaoService novaSimulacao = new NovaSimulacaoService(daoDeclaracao);
        final AdicionarDespesaService adicionarDespesa = new AdicionarDespesaService(daoDeclaracao, daoDespesa);
        final ExcluirSimulacaoService excluirSimulacao = new ExcluirSimulacaoService(daoDeclaracao, daoDespesa);
        final RelatorioSimulacaoService relatorioSimulacao = new RelatorioSimulacaoService(daoDeclaracao, daoDespesa);

        novaSimulacao.iniciar(200_000.0, 10_000.0);
        adicionarDespesa.adicionar(1, 1_500.0, "Unimed", "23131/0001", "REF23123", TipoDespesa.SAUDE);
        adicionarDespesa.adicionar(2, 1_500.0, "ADS", "33131/0001", "Unicep", TipoDespesa.EDUCACAO);
        adicionarDespesa.adicionar(3, 1_500.0, "Inglês", "231541/0001", "Wizard", TipoDespesa.EDUCACAO);
        System.out.println(relatorioSimulacao.criarRelatorio());
    }
}
