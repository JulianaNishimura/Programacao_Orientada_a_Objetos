package org.example.aula03;

public class Main {

    public static void main(String[] args) {

        Team team = new Team("Brasil", "São Paulo", "Carlos");
        Player p1 = new Player("João", 10, "Atacante", true);
        Player p2 = new Player("Pedro", 7, "Meia", true);
        Player p3 = new Player("Lucas", 5, "Defensor", false);
        Player p4 = new Player("Carlos", 3, "Goleiro", false);

        team.addPlayer(p1);
        team.addPlayer(p2);
        team.addPlayer(p3);
        team.addPlayer(p4);

        Player duplicado = new Player("Outro", 10, "Meia", false);
        team.addPlayer(duplicado);

        System.out.println("jogando:");
        for (Player p : team.getFieldedPlayers()) {
            if (p != null)
                System.out.println(p.getStateAsString());
        }

        System.out.println("\nnãso jogando:");
        for (Player p : team.getOutfieldedPlayers()) {
            if (p != null)
                System.out.println(p.getStateAsString());
        }

        System.out.println("\nsubtituição:");
        team.substitute(p3, p1);

        for (Player p : team.getFieldedPlayers()) {
            if (p != null)
                System.out.println(p.getStateAsString());
        }

        team.setCaptain(p2);
        System.out.println(team.getCaptain().getStateAsString());

        team.removePlayer(p2);
        for (Player p : team.getFieldedPlayers()) {
            if (p != null)
                System.out.println(p.getStateAsString());
        }

        System.out.println("\nestourando o limite:");
        for (int i = 20; i <= 45; i++) {
            team.addPlayer(
                    new Player("Jogador" + i, i, "Posição", false)
            );
        }

        for (Player p : team.getOutfieldedPlayers()) {
            if (p != null) {
                System.out.println(p.getStateAsString());
            }
        }

        for (Player p : team.getFieldedPlayers()) {
            if (p != null) {
                System.out.println(p.getStateAsString());
            }
        }
    }
}