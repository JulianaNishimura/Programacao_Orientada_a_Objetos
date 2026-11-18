package org.example.exams.exam02.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DeclaracaoCompleta extends Declaracao{
    private List<Despesa> gastos;

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

    public List<Despesa> getGastos(){
        return Collections.unmodifiableList(gastos);
    }

    public double despesasDedutivesEducacao(){
        double valor =  gastos.stream().filter(d -> d instanceof DespesaEducacao).map(Despesa::getValor).reduce(Double::sum).orElse(0.0);
        return valor;
    }

    public double despesasDedutivesSaude(){
        double valor =  gastos.stream().filter(d -> d instanceof DespesaSaude).map(Despesa::getValor).reduce(Double::sum).orElse(0.0);
        return valor;
    }

    public double deducaoEfetivaEducacao(){
        return Math.min(despesasDedutivesEducacao(), DespesaEducacao.DEDUCAO_MAX);
    }

    public double deducaoEfetivaSaude(){
        return Math.min(despesasDedutivesSaude(), DespesaSaude.DEDUCAO_MAX);
    }

    private double totalDespesasDedutiveis(){
        return deducaoEfetivaEducacao() + deducaoEfetivaSaude();
    }

    @Override
    public double valorImposto(){
        double base = super.getGanhoTributavel() - totalDespesasDedutiveis();
        double imposto = 0;
        if(base > 55976.16){
            imposto += (base - 55976.16)*0.275;
            base = 55976.16;
        }
        if(base > 45012.72){
            imposto += (base - 45012.72)*0.225;
            base = 45012.72;
        }
        if(base > 33919.92){
            imposto += (base - 33919.92)*0.15;
            base = 33919.92;
        }
        if(base > 22847.88){
            imposto += (base - 22847.88)*0.075;
        }
        return imposto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeclaracaoCompleta that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(gastos, that.gastos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gastos);
    }

    @Override
    public String toString() {
        return "DeclaracaoCompleta{" +
                "gastos=" + gastos +
                '}';
    }
}
