package org.example.practiceExams.exam03.game;

class Small implements MarioState{
    private MarioGame mario;

    Small(MarioGame mario) {
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
        mario.nextState(new Big(mario));
    }

    @Override
    public void takeDamage() {
        mario.nextState(new Dead());
    }
}
