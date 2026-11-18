package org.example.extraExercises.ex2;

public class NotificadorEmail implements Notificador{
    @Override
    public String canal() {
        return "EMAIL";
    }

    @Override
    public boolean enviar(String destinatario, String mensagem) {
        System.out.println(String.format("[EMAIL] para %s: %s",destinatario,mensagem));
        return destinatario != null && destinatario.contains("@");
    }
}
