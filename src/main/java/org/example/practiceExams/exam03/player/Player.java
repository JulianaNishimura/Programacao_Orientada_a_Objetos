package org.example.practiceExams.exam03.player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player implements Comparable<Player>{
    private String username;
    private List<Integer> gameScores = new ArrayList<>();

    public Player(String username) {
        this.username = username;
    }

    public void addScore(int score){
        gameScores.add(score);
    }

    @Override
    public int compareTo(Player o) {
        List<Integer> player1 = gameScores.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> player2 = o.gameScores.stream().sorted(Comparator.reverseOrder()).toList();
        int sizeIterate = Math.min(player1.size(), player2.size());
        int result = 0;

        for (int i = 0; i < sizeIterate && result == 0; i++) {
            result = Integer.compare(player2.get(i), player1.get(i));
        }

        if (result == 0) {
            return username.compareTo(o.username);
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "Username = %s | Max score = %d",
                username,
                gameScores.stream().max(Integer::compareTo).orElse(0)
        );
    }
}
