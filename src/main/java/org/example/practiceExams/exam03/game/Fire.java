package org.example.practiceExams.exam03.game;

public class Fire implements MarioState{
    private MarioGame mario;

    Fire(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.incrementScore();
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
        mario.nextState(new Big(mario));
    }
}
