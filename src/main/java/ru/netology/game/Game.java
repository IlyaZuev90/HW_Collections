package ru.netology.game;

import java.util.ArrayList;
import java.util.List;
public class Game {

    List<Player> players = new ArrayList<>();

    public void register (Player player) {
        players.add(player);
    }

    public List<Player> findAll() {
        return players;
    }


    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        throw new NotRegisteredException(playerName);
    }

    public int round (String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        for (Player player : players) {
            if (player.equals(player1)) {
                player1 = player;
            }
            if (player.equals(player2)) {
                player2 = player;
            }
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
