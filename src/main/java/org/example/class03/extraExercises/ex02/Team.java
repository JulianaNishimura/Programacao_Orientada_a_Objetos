package org.example.class03.extraExercises.ex02;

public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player[] players = new Player[18];
    private Player captain;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player player){
        boolean alreadyExists = false;
        for (int i = 0; i < players.length && !alreadyExists; i++) {
            if (players[i] != null && players[i].getNumber() == player.getNumber()) {
                alreadyExists = true;
            }
        }

        if(!alreadyExists){
            int j = 0;
            while (j < players.length && players[j] != null) {
                j++;
            }

            if (j < players.length) {
                players[j] = player;
                player.setTeam(this);
            }
        }
    }

    public void removePlayer(Player player){
        if (player.getTeam() != null && player.getTeam() == this) {
            int found = -1;
            for (int i = 0; i < players.length && found == -1; i++) {
                if (players[i] != null && players[i].getNumber() == player.getNumber()) {
                    found = i;
                }
            }

            if (found != -1) {
                players[found].setTeam(null);
                for (int i = found; i < players.length - 1; i++) {
                    players[i] = players[i + 1];
                }
                players[players.length - 1] = null;
            }
        }
    }

    public void substitute(Player substitute, Player starter){
        int substituteListed = -1;
        int starterListed = -1;
        if(substitute != null && starter != null){
            for(int i = 0; i < players.length && (substituteListed == -1 || starterListed == -1);i++){
                if(players[i] != null){
                    if (players[i].getNumber() == substitute.getNumber()) {
                        substituteListed = i;
                    }

                    if (players[i].getNumber() == starter.getNumber()) {
                        starterListed = i;
                    }
                }
            }

            if (starterListed != -1 && substituteListed != -1 && players[starterListed].isFielded() && !players[substituteListed].isFielded()) {
                players[starterListed].setFielded(false);
                players[substituteListed].setFielded(true);
            }
        }
    }

    public void setCaptain(Player captain){
        if(captain != null){
            for(int i = 0; i < players.length;i++){
                if (players[i] != null && players[i].getName().equalsIgnoreCase(captain.getName()) && players[i].getNumber() == captain.getNumber()) {
                    this.captain = players[i];
                    break;
                }
            }
        }
    }

    public Player[] getFieldedPlayers(){
        Player[] fieldedPlayers = new Player[18];
        int j = 0;
        for(int i = 0; i < players.length; i++){
            if(players[i]!= null && players[i].isFielded()){
                fieldedPlayers[j] = players[i];
                j++;
            }
        }
        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers(){
        Player[] outfieldedPlayers = new Player[18];
        int j = 0;
        for(int i = 0; i < players.length; i++){
            if(players[i]!= null && !(players[i].isFielded())){
                outfieldedPlayers[j] = players[i];
                j++;
            }
        }
        return outfieldedPlayers;
    }

    public String getName() {
        return name;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getCoachName() {
        return coachName;
    }

    public Player getCaptain() {
        return captain;
    }
}
