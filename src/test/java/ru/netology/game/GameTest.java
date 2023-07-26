package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GameTest {

    @Test
    void shouldRegister() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        Player[] expected =  {player1, player2, player3, player4, player5, player6};
        List<Player> actual = players.findAll();

        Assertions.assertArrayEquals(expected, actual.toArray());

        System.out.println("Поиск всех игроков");
        actual.stream().forEach(s -> System.out.println(s));
        System.out.println();

    }

    @Test
    void shouldFindByName() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        String playerName = "Smok Belyu";


        Player[] expected =  {player5};
        Player actual = players.findByName(playerName);

        Assertions.assertArrayEquals(expected, new Player[]{actual});

        System.out.println("Игрок найден:");
        System.out.println(actual);
        System.out.println();
    }

    @Test
    void shouldFindByNameNothing() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        String playerName = "Din Vinchester";

        Assertions.assertThrows(NotRegisteredException.class,
                () -> players.findByName(playerName)
        );

    }

    @Test
    void shouldTestRoundWhenBothPlayersNotRegistred() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        String playerName1 = "Din Vinchester";
        String playerName2 = "Mad Max";

        Assertions.assertThrows(NotRegisteredException.class,
                () -> players.round(playerName1, playerName2)
        );
    }

    @Test
    void shouldTestRoundWhenFirstPlayerNotRegistred() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        String playerName1 = "Din Vinchester";
        String playerName2 = "Jason dinAlt";

        Assertions.assertThrows(NotRegisteredException.class,
                () -> players.round(playerName1, playerName2)
        );
    }

    @Test
    void shouldTestRoundWhenSecondPlayerNotRegistred() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        String playerName1 = "Jason dinAlt";
        String playerName2 = "Din Vinchester";

        Assertions.assertThrows(NotRegisteredException.class,
                () -> players.round(playerName1, playerName2)
        );
    }

    @Test
    void shouldTestRoundWhenFirstPlayerWins() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        int expected = 1;
        int actual = players.round("Korvin Amber", "Jhon  Snow");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTestRoundWhenSecondPlayerWins() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        int expected = 2;
        int actual = players.round("Smok Belyu", "Jason dinAlt");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTestRoundWhenEqualResult() {
        Game players = new Game();
        Player player1 = new Player(1, "Jhon  Snow", 10);
        Player player2 = new Player(2, "Max  Payne", 10);
        Player player3 = new Player(3, "Korvin Amber", 25);
        Player player4 = new Player(4, "Ker Laeda", 20);
        Player player5 = new Player(5, "Smok Belyu", 5);
        Player player6 = new Player(6, "Jason dinAlt", 9);

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);

        int expected = 0;
        int actual = players.round("Max  Payne", "Jhon  Snow");

        Assertions.assertEquals(expected, actual);
    }
}