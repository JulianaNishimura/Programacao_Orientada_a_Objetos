package org.example.exams.exam02.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DeclaracaoCompleta extends Declaracao{
    private ArrayList<Despesa> gastos;

    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
        this.gastos = new ArrayList<>();
    }

    public void adicionarDespesa(Despesa despesa){
        if(despesa == null) throw new IllegalArgumentException("Despesa não pode ser nula");
        gastos.add(despesa);
    }

    public void removerDespesa(Despesa despesa){
        gastos.remove(despesa);
    }

    private double despesasDedutivesEducacao(){
        return gastos.stream()
                .filter(d -> d instanceof DespesaEducacao)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    private double despesasDedutivesSaude(){
        return gastos.stream()
                .filter(d -> d instanceof DespesaSaude)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    private double totalDespesasDedutiveis(){
        return Math.min(despesasDedutivesEducacao(),DespesaEducacao.DEDUCAO_MAX) + Math.min(despesasDedutivesSaude(),DespesaSaude.DEDUCAO_MAX);
    }

    @Override
    public double valorImposto(){
        double ganhos = getGanhoTributavel() - totalDespesasDedutiveis();
        double imposto = 0;

        if(ganhos > 55976.16){
            imposto += (ganhos - 55976.16)*0.275;
            ganhos = 55976.16;
        }

        if(ganhos > 45012.72){
            imposto += (ganhos - 45012.72)*0.225;
            ganhos = 45012.72;
        }

        if(ganhos > 33919.92){
            imposto += (ganhos - 33919.92)*0.15;
            ganhos = 33919.92;
        }

        if(ganhos > 22847.88){
            imposto += (ganhos - 22847.88)*0.075;
        }

        return imposto;
    }

    @Override
    public String toString() {
        //fazer o tostring
        return super.toString() + "Declaracao Completa\n" + "Despesas Totais: " + totalDespesasDedutiveis() +;
    }

    public List<Despesa> getGastos(){
        return gastos.stream().toList();
    }
}
