package org.example.practiceExams.exam03.game;

class Cape implements MarioState{
    private MarioGame mario;

    Cape(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(new Fire(mario));
    }

    @Override
    public void takeFeather() {
        mario.incrementScore();
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
