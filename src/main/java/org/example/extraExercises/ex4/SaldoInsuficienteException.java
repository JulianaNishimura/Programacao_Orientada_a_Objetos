package org.example.extraExercises.ex4;

public class SaldoInsuficienteException extends Exception {
    private	final	double	saldoAtual;
    private	final	double	valorSolicitado;

    public SaldoInsuficienteException(double saldoAtual, double valorSolicitado) {
        super("Saldo insuficiente: saldo=" + saldoAtual	+ ", solicitado=" + valorSolicitado);
        this.saldoAtual	= saldoAtual;
        this.valorSolicitado = valorSolicitado;
    }

    public	double	getSaldoAtual()	{
        return	saldoAtual;
    }

    public	double	getValorSolicitado() {
        return	valorSolicitado;
    }
}
