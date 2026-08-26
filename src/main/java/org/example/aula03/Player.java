package org.example.aula03;

public class Player {
    private String name;
    private int number;
    private String position;
    private boolean isFielded;
    private Team team;

    public Player(String name, int number, String position, boolean isFielded) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getStateAsString(){
        StringBuilder builder = new StringBuilder();

        String fieldedState = isFielded ? "Em campo" : "Fora de campo";

        builder.append(name)
                .append(" ")
                .append(number)
                .append(" ")
                .append(position)
                .append(" ")
                .append(fieldedState);

        return builder.toString();
    }
}