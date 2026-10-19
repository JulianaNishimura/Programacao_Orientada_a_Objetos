package org.example.practiceExams.exam03.main;

import org.example.practiceExams.exam03.game.GameRuleViolationException;
import org.example.practiceExams.exam03.game.MarioGame;
import org.example.practiceExams.exam03.player.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        String[] usernames = { "Maria", "Joao", "Ana", "Pedro", "Lucas" };
        List<Player> players = new ArrayList<>();
        for (String name : usernames) {
            players.add(new Player(name));
        }

        try {
            for (Player player : players) {
                for (int i = 0; i < 10; i++) {
                    MarioGame game = new MarioGame();
                    while (!game.isDone()) {
                        game.takeMysteryBox();
                    }
                    player.addScore(game.getScore());
                }
            }
        } catch (GameRuleViolationException e) {
            System.err.println(e.getMessage());
        }

        players.sort(Comparator.naturalOrder());
        System.out.println("=== Hall of Fame ===");
        int position = 1;
        for (Player player : players) {
            System.out.printf("%d. %s%n",position,player.toString());
            position++;
        }
    }
}
