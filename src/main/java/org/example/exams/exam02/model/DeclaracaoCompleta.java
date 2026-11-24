package org.example.exams.exam02.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class DeclaracaoCompleta extends Declaracao {
    private final List<Despesa> despesas;

    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
        this.despesas = new ArrayList<>();
    }

    @Override
    protected double valorImposto() {
        double ganhosEfetivos = getGanhoTributavel() - totalDespesasDedutiveis();
        double imposto = 0.0;

        if(ganhosEfetivos > 55_976.16) {
            imposto += (ganhosEfetivos - 55_976.16) * 0.275;
            ganhosEfetivos = 55_976.16;
        }
        if(ganhosEfetivos > 45_012.73) {
            imposto += (ganhosEfetivos - 45_012.73) * 0.225;
            ganhosEfetivos = 45_012.73;
        }
        if(ganhosEfetivos > 33_919.93) {
            imposto += (ganhosEfetivos - 33_919.93) * 0.15;
            ganhosEfetivos = 33_919.93;
        }
        if(ganhosEfetivos > 22_847.88) {
            imposto += (ganhosEfetivos - 22_847.88) * 0.075;
        }
        return imposto;
    }

    private double totalDespesasDedutiveis(){
        return Math.min(despesasSaude(), DespesaSaude.MAX_GASTO)
               + Math.min(despesasEducacao(), DespesaEducacao.MAX_GASTO);
    }

    private double despesasEducacao(){
        return despesas.stream()
                .filter(d -> d instanceof DespesaEducacao)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    private double despesasSaude(){
        return despesas.stream()
                .filter(d -> d instanceof DespesaSaude)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    public void addDespesa(Despesa despesa){
        despesas.add(despesa);
    }

    public void removeDespesa(Despesa despesa){
        despesas.remove(despesa);
    }

    @Override
    public String toString() {
        final String despesasString = despesas.stream().map(Despesa::toString).collect(Collectors.joining("\n"));
        return "Declaracao Completa: " + super.toString() + "\nDespesas dedutíveis: \n"
               + despesasString + "\nTotal Saúde: " + despesasSaude() + "\nTotal Educação: " + despesasEducacao()
               + "\nTotal dedutível: " + totalDespesasDedutiveis();
    }
}
