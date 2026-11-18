package org.example.extraExercises.ex2;

public class NotificadorSms implements Notificador{
    @Override
    public String canal() {
        return "SMS";
    }

    @Override
    public boolean enviar(String destinatario, String mensagem) {
        if(destinatario!= null && destinatario.length()==11){
            for(int i = 0; i < 11; i++){
                if(!Character.isDigit(destinatario.charAt(i))){
                    return false;
                }
            }
            System.out.println(String.format("[SMS] para %s: %s",destinatario,mensagem));
            return true;
        }
        return false;
    }
}
