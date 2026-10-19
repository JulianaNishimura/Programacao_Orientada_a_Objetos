package org.example.practiceExams.exam03.game;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarioGame {
    private int score;
    private MarioState state;
    private final List<String> eventsLog = new ArrayList<>();
    private String event;

    public MarioGame() {
        this.state = new Small(this);
        this.score = 0;
    };

    void takeMysteryBox(){
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0 -> takeFlower();
            case 1 -> takeFeather();
            case 2 -> takeMushroom();
            case 3 -> takeDamage();
        }
    }

    void takeFlower(){
        event = "Took a flower";
        state.takeFlower();
    }

    void takeFeather(){
        event = "Took a feather";
        state.takeFeather();
    }

    void takeMushroom(){
        event = "Took a mushroom";
        state.takeMushroom();
    }

    void takeDamage(){
        event = "Took damage";
        state.takeDamage();
    }

    void nextState(MarioState next){
        registerEvent(state.getClass().getSimpleName(),next.getClass().getSimpleName());
        state = next;
    }

    private void registerEvent(String previousState, String newState) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        eventsLog.add(String.format("[%s] %s | %s => %s | Score = %d", timestamp, event, previousState, newState, score));
    }

    void incrementScore(){
        score+=1000;
        registerEvent(state.getClass().getSimpleName(),state.getClass().getSimpleName());
    }

    boolean isDone(){
        return state instanceof Dead;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String event : eventsLog) {
            sb.append(event).append("\n");
        }
        return sb.toString();
    }
}
