package ru.netology.game;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String playerName) {
        super("Игрок с имененм " + playerName + " не найден");
        System.out.println("Игрок с имененм " + playerName + " не найден");
    }
}
