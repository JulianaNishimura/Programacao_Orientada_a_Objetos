package org.example.exams.exam02;


import org.example.exams.exam02.exception.EntityAlreadyExists;
import org.example.exams.exam02.persistence.DeclaracaoRepository;
import org.example.exams.exam02.persistence.DeclaracaoRepositoryImpl;
import org.example.exams.exam02.service.*;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        DeclaracaoRepository repository = new DeclaracaoRepositoryImpl();
        NovaSimulacaoService novaSimulacaoService = new NovaSimulacaoService(repository);
        AdicionarDespesaService adicionarDespesaService = new AdicionarDespesaService(repository);
        ExcluirSimulacaoService excluirSimulacaoService = new ExcluirSimulacaoService(repository);
        RelatorioSimulacaoService relatorioSimulacaoService = new RelatorioSimulacaoService(repository);

        try {
            adicionarDespesaService.adicionar("abc", 100, "32423", "ABC", TipoDespesa.SAUDE);

            novaSimulacaoService.iniciar(35000, 3000);

            novaSimulacaoService.iniciar(10000, 0);

            adicionarDespesaService.adicionar("testeSa", 1000, "32423", "Saude", TipoDespesa.SAUDE);
            adicionarDespesaService.adicionar("testeEd", 2500, "345345", "Educacao", TipoDespesa.EDUCACAO);

            System.out.println(relatorioSimulacaoService.criarRelatorio());

            adicionarDespesaService.adicionar("invalida", -50, "32423", "Saude", TipoDespesa.SAUDE);

            excluirSimulacaoService.excluir();
            excluirSimulacaoService.excluir();

        } catch (EntityAlreadyExists e) {
            System.out.println("[Já existe] " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("[Estado inválido] " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("[Não encontrado] " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("[Argumento inválido] " + e.getMessage());
        }
    }
}
