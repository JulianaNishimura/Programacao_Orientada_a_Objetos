package org.example.class04.extraExercises.ex03;

public class VerifyEmail {
    public static boolean isValidEmail(String email){
        if(email.trim().isEmpty()) return false;
        if(!email.contains("@")) return false;
    }
}
