package org.example.exams.exam02;

import exception.EntityAlreadyExists;
import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;
import service.*;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        DeclaracaoRepository repository = new DeclaracaoRepositoryImpl();
        NovaSimulacaoService novaSimulacaoService = new NovaSimulacaoService(repository);
        AdicionarDespesaService adicionarDespesaService= new AdicionarDespesaService(repository);
        ExcluirSimulacaoService excluirSimulacaoService = new ExcluirSimulacaoService(repository);
        RelatorioSimulacaoService relatorioSimulacaoService = new RelatorioSimulacaoService(repository);

        // CORREÇÃO (item 13): cada passo é tratado separadamente (antes um único try/catch encerrava tudo
        // no primeiro erro) e agora os erros possíveis da aplicação também são exercitados.

        // Erros esperados antes de existir uma simulação
        executar("Adicionar despesa sem simulação (erro esperado)", () ->
                adicionarDespesaService.adicionar("abc",100,"32423","ABC", TipoDespesa.SAUDE));
        executar("Excluir sem simulação (erro esperado)", excluirSimulacaoService::excluir);
        executar("Relatório sem simulação (erro esperado)", () -> System.out.println(relatorioSimulacaoService.criarRelatorio()));

        // Cenário 1: despesas acima dos tetos de saúde e educação
        executar("Iniciar simulação (ganho 35.000, já pago 3.000)", () -> novaSimulacaoService.iniciar(35000.00,3000));
        executar("Iniciar outra simulação (erro esperado)", () -> novaSimulacaoService.iniciar(10000.00,0));
        executar("Adicionar despesa de saúde (3.000)", () ->
                adicionarDespesaService.adicionar("testeSa",3000,"32423","Saude", TipoDespesa.SAUDE));
        executar("Relatório", () -> System.out.println(relatorioSimulacaoService.criarRelatorio()));
        executar("Adicionar despesa de educação (2.500)", () ->
                adicionarDespesaService.adicionar("testeEd",2500,"345345","Educacao", TipoDespesa.EDUCACAO));
        executar("Relatório", () -> System.out.println(relatorioSimulacaoService.criarRelatorio()));
        executar("Adicionar despesa com valor negativo (erro esperado)", () ->
                adicionarDespesaService.adicionar("invalida",-50,"32423","Saude", TipoDespesa.SAUDE));
        executar("Excluir simulação", excluirSimulacaoService::excluir);
        executar("Excluir novamente (erro esperado)", excluirSimulacaoService::excluir);

        // Cenário 2
        executar("Iniciar simulação (ganho 45.000, já pago 2.000)", () -> novaSimulacaoService.iniciar(45000.00,2000));
        executar("Adicionar despesa de saúde (3.000)", () ->
                adicionarDespesaService.adicionar("abc",3000,"32423","ABC", TipoDespesa.SAUDE));
        executar("Relatório", () -> System.out.println(relatorioSimulacaoService.criarRelatorio()));
        executar("Excluir simulação", excluirSimulacaoService::excluir);

        // Cenário 3
        executar("Iniciar simulação (ganho 25.000, já pago 1.000)", () -> novaSimulacaoService.iniciar(25000.00,1000));
        executar("Adicionar despesa de educação (3.000)", () ->
                adicionarDespesaService.adicionar("abc",3000,"32423","ABC", TipoDespesa.EDUCACAO));
        executar("Relatório", () -> System.out.println(relatorioSimulacaoService.criarRelatorio()));
        executar("Excluir simulação", excluirSimulacaoService::excluir);

        // Cenário 4: sem despesas e com renda baixa
        executar("Iniciar simulação (ganho 20.000, já pago 5.000)", () -> novaSimulacaoService.iniciar(20000,5000));
        executar("Relatório", () -> System.out.println(relatorioSimulacaoService.criarRelatorio()));
        executar("Excluir simulação", excluirSimulacaoService::excluir);

        // Cenário 5: renda alta e sem despesas (a Simplificada tende a ser mais vantajosa)
        executar("Iniciar simulação (ganho 80.000, já pago 8.000)", () -> novaSimulacaoService.iniciar(80000,8000));
        executar("Relatório", () -> System.out.println(relatorioSimulacaoService.criarRelatorio()));
        executar("Excluir simulação", excluirSimulacaoService::excluir);
    }

    // Executa um passo e trata cada tipo de exceção da aplicação separadamente
    private static void executar(String titulo, Runnable acao){
        System.out.println("\n>>> " + titulo);
        try {
            acao.run();
        } catch (EntityAlreadyExists e) {
            System.out.println("    [Já existe] " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("    [Estado inválido] " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("    [Não encontrado] " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("    [Argumento inválido] " + e.getMessage());
        }
    }
}
