package org.example.extraExercises.ex2;

public class CentralNotificacoes {
    private final Notificador[] canais;

    public CentralNotificacoes(Notificador...canais){
        this.canais = canais.clone();
    }

    public int enviarParaTodos(String destinatario, String mensagem){
        int	enviados=0;
        for	(Notificador canal : canais){
            if(canal.enviar(destinatario, mensagem)){
                enviados++;
            }
        }
        return enviados;
    }

    public	Notificador	buscarCanal(String nome){
        for	(Notificador canal : canais){
            if(canal.canal().equalsIgnoreCase(nome)){
                return canal;
            }
        }
        return null;
    }
}
