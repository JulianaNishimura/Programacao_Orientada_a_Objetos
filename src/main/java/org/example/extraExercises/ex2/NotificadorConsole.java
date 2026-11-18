package org.example.extraExercises.ex2;

public class NotificadorConsole implements Notificador{
    @Override
    public String canal() {
        return "CONSOLE";
    }

    @Override
    public boolean enviar(String destinatario, String mensagem) {
        System.out.println(String.format("[CONSOLE] %s <- %s",destinatario,mensagem));
        return true;
    }
}
