package org.example.numbattlers.internal.entity;

import java.util.List;

public class Game {
    private List<Player> players;
    private List<Ask> asks;
    private String difficulty;
    private int time;
    private int score;

    public Game(List<Player> players, List<Ask> asks, String difficulty, int time, int score) {
        this.players = players;
        this.asks = asks;
        this.difficulty = difficulty;
        this.time = time;
        this.score = score;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Ask> getAsks() {
        return asks;
    }

}
