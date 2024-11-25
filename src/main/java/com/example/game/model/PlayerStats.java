package com.example.game.model;

public class PlayerStats {
    private String playerName;
    private int gamesPlayed;
    private int wins;
    private int losses;

    public PlayerStats(String playerName) {
        this.playerName = playerName;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public int getGamesPlayed() { return gamesPlayed; }
    public void setGamesPlayed(int gamesPlayed) { this.gamesPlayed = gamesPlayed; }
    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }
    public int getLosses() { return losses; }
    public void setLosses(int losses) { this.losses = losses; }

    public void incrementWins() {
        wins++;
        gamesPlayed++;
    }

    public void incrementLosses() {
        losses++;
        gamesPlayed++;
    }
}
