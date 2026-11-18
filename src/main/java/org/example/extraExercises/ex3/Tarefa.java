package org.example.extraExercises.ex3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

public	class	Tarefa	implements	Comparable<Tarefa>	{
    private int prioridade;
    private String titulo;
    private LocalDate prazo;
    private boolean concluida;

    public Tarefa(String titulo, int prioridade, LocalDate prazo) {
        this.titulo = titulo;
        this.prazo = prazo;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        concluida = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(titulo, tarefa.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prioridade, titulo, prazo);
    }

    @Override
    public String toString() {
        return String.format("%s (%d, %s",titulo,prioridade,prazo) + (concluida	? ", ok)" : ")");
    }

    @Override
    public int compareTo(Tarefa o) {
        int compare = prazo.compareTo(o.prazo);
        if(compare!=0) return compare;
        compare = Integer.compare(o.prioridade,prioridade);
        if	(compare !=	0)	return	compare;
        return	titulo.compareTo(o.titulo);
    }


}
