package org.example.practiceExams.exam03.game;

public class Big implements MarioState{
    private MarioGame mario;

    Big(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(new Fire(mario));
    }

    @Override
    public void takeFeather() {
        mario.nextState(new Cape(mario));
    }

    @Override
    public void takeMushroom() {
        mario.incrementScore();
    }

    @Override
    public void takeDamage() {
        mario.nextState(new Small(mario));
    }
}
