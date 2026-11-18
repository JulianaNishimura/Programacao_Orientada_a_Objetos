package org.example.exams.exam02.service;

import org.example.exams.exam02.model.*;
import org.example.exams.exam02.persistence.DeclaracaoRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class RelatorioSimulacaoService {
    private DeclaracaoRepository repository;

    public RelatorioSimulacaoService(DeclaracaoRepository repository){
        this.repository = repository;
    }

    public String criarRelatorio() throws NoSuchElementException {
        DeclaracaoCompleta declaracaoCompleta = (DeclaracaoCompleta) repository.buscar(1).orElseThrow(() -> new NoSuchElementException("Simulação não iniciada"));

        DeclaracaoSimplificada declaracaoSimplificada = (DeclaracaoSimplificada) repository.buscar(2).orElseThrow(() -> new NoSuchElementException("Simulação não iniciada"));

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("DADOS DA DECLARAÇÃO:\n Ganho tributável: R$ %.2f | Valor já pago: R$ %.2f",
                declaracaoCompleta.getGanhoTributavel(), declaracaoCompleta.getValorJaPago()));

        sb.append("\n").append(String.format("Imposto a pagar na Declaração Completa: R$ %.2f\nImposto a pagar " +
                "na Declaração Simplificada: R$ %.2f", declaracaoCompleta.valorAPagar(), declaracaoSimplificada.valorAPagar()));

        List<Despesa> saude = declaracaoCompleta.getGastos().stream().filter(d -> d instanceof DespesaSaude).toList();
        List<Despesa> educacao = declaracaoCompleta.getGastos().stream().filter(d -> d instanceof DespesaEducacao).toList();

        adicionarTipo(sb, "Saúde", saude, declaracaoCompleta.despesasDedutivesSaude(), declaracaoCompleta.deducaoEfetivaSaude(), DespesaSaude.DEDUCAO_MAX);
        adicionarTipo(sb, "Educação", educacao, declaracaoCompleta.despesasDedutivesEducacao(), declaracaoCompleta.deducaoEfetivaEducacao(), DespesaEducacao.DEDUCAO_MAX);

        sb.append("\n(valor negativo = imposto a restituir)");
        return sb.toString();
    }

    private void adicionarTipo(StringBuilder sb, String tipo, List<Despesa> despesas, double gasto, double deduzido, double limite){
        sb.append(String.format("\nDeclaração Completa - despesas de %s (total gasto R$ %.2f | efetivamente deduzido R$ %.2f | limite R$ %.2f):",
                tipo, gasto, deduzido, limite));
        if(despesas.isEmpty()){
            sb.append("\n   (nenhuma)");
        }
        despesas.forEach(d -> sb.append(String.format("\n   - %s: R$ %.2f", d.getDescricao(), d.getValor())));
    }
}
