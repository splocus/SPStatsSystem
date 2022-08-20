package org.splocus.Models;

public abstract class Stats {

    protected int kills;
    protected int deaths;
    protected int blocksMined;

    public Stats() {
        kills = 0;
        deaths = 0;
        blocksMined = 0;
    }

    public Stats(int kills, int deaths, int blocksMined) {
        this.kills = kills;
        this.deaths = deaths;
        this.blocksMined = blocksMined;
    }


    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getBlocksMined() {
        return blocksMined;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setBlocksMined(int blocksMined) {
        this.blocksMined = blocksMined;
    }

    public void addKills(int amount) {
        this.kills += amount;
    }

    public void addDeaths(int amount) {
        this.deaths += amount;
    }

    public void addBlocksMined(int amount) {
        this.blocksMined += amount;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "kills=" + kills +
                ", deaths=" + deaths +
                ", blocksMined=" + blocksMined +
                '}';
    }
}
