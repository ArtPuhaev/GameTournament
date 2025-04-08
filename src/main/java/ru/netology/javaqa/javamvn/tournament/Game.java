package ru.netology.javaqa.javamvn.tournament;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int strengthP1 = findPlayer(playerName1).getStrength();
        int strengthP2 = findPlayer(playerName2).getStrength();
        if (strengthP1 > strengthP2) {
            return 1;
        } else if (strengthP1 < strengthP2) {
            return 2;
        }
        return 0;
    }

    private Player findPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegisteredException(playerName);
    }
}
