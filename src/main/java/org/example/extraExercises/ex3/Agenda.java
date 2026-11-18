package org.example.extraExercises.ex3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public	class	Agenda	{
    private List<Tarefa> listaDeTarefas = new ArrayList<>();

    public	boolean	adicionar(Tarefa tarefa){
        if(listaDeTarefas.contains(tarefa)){
            return false;
        }
        return listaDeTarefas.add(tarefa);
    }

    public boolean remover(String titulo) {
        Iterator<Tarefa> it = listaDeTarefas.iterator();

        for (; it.hasNext();) {
            if (it.next().getTitulo().equals(titulo)) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    public	boolean	concluir(String	titulo)	{
        for(Tarefa t : listaDeTarefas){
            if(t.getTitulo().equals(titulo)){
                t.concluir();
                return true;
            }
        }
        return false;
    }

    public Iterator<Tarefa> iterador(){
        return listaDeTarefas.iterator();
    }

    public	List<Tarefa>	ordenadas()		{
        List<Tarefa> tarefasOrdenadas = new ArrayList<>(listaDeTarefas);
        Collections.sort(tarefasOrdenadas);
        return tarefasOrdenadas;
    }

    public	List<Tarefa>	porPrioridade()	{
        List<Tarefa> tarefasOrdenadasPorPrioridade = new ArrayList<>(listaDeTarefas);
        tarefasOrdenadasPorPrioridade.sort((a, b) -> {
            int cmp = Integer.compare(b.getPrioridade(),a.getPrioridade());
            return cmp != 0 ? cmp : a.getPrazo().compareTo(b.getPrazo());
        });
        return tarefasOrdenadasPorPrioridade;
    }

    public	List<Tarefa> atrasadas(LocalDate hoje){
        List<Tarefa>	resultado	=	new	ArrayList<>();
        for(Tarefa t : listaDeTarefas){
            if(!t.isConcluida() && t.getPrazo().isBefore(hoje)){
                resultado.add(t);
            }
        }
        return resultado;
    }

}
