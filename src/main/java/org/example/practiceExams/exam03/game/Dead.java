package org.example.practiceExams.exam03.game;

class Dead implements MarioState{
    Dead() {}

    @Override
    public void takeFlower() {
        throw new GameRuleViolationException("Mario is dead and cannot take a flower.");
    }

    @Override
    public void takeFeather() {
        throw new GameRuleViolationException("Mario is dead and cannot take a feather.");
    }

    @Override
    public void takeMushroom() {
        throw new GameRuleViolationException("Mario is dead and cannot take a mushroom.");
    }

    @Override
    public void takeDamage() {
        throw new GameRuleViolationException("Mario is dead and cannot take damage.");
    }
}
