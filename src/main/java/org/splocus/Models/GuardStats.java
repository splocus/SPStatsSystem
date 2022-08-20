package org.splocus.Models;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class GuardStats extends Stats implements ConfigurationSerializable {

    private int jailedPlayerAmount;
    private int fixedJail;

    public GuardStats() {
        super();
        jailedPlayerAmount = 0;
        fixedJail = 0;
    }

    public GuardStats(int kills, int deaths, int jailedPlayers, int blocksMined, int fixedJail) {
        super(kills, deaths, blocksMined);
        this.jailedPlayerAmount = jailedPlayers;
        this.fixedJail = fixedJail;
    }

    public int getJailedPlayerAmount() {
        return jailedPlayerAmount;
    }

    public int getFixedJail() {
        return fixedJail;
    }

    public void setJailedPlayerAmount(int jailedPlayerAmount) {
        this.jailedPlayerAmount = jailedPlayerAmount;
    }

    public void setFixedJail(int fixedJail) {
        this.fixedJail = fixedJail;
    }

    public void addJailedPlayerAmount(int amount) {
        this.jailedPlayerAmount += amount;
    }

    public void addFixedJail(int amount) {
        this.fixedJail += amount;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();
        result.put("kills", kills);
        result.put("deaths", deaths);
        result.put("jailedPlayerAmount", jailedPlayerAmount);
        result.put("blocksMined", blocksMined);
        result.put("fixedJail", fixedJail);
        return result;
    }

    public GuardStats(Map<String, Object> serializedJailedInfo) {
        super((int)serializedJailedInfo.get("kills"),
            (int)serializedJailedInfo.get("deaths"),
            (int)serializedJailedInfo.get("blocksMined"));
        this.jailedPlayerAmount = (int)serializedJailedInfo.get("jailedPlayerAmount");
        this.fixedJail = (int)serializedJailedInfo.get("fixedJail");
    }

    public static GuardStats deserialize(Map<String, Object> args) {
        return new GuardStats((int)args.get("kills"),
                (int)args.get("deaths"),
                (int)args.get("jailedPlayerAmount"),
                (int)args.get("blocksMined"),
                (int)args.get("fixedJail"));
    }

    @Override
    public String toString() {
        return "§7Kills: §b" + kills + "\n" +
                "§7Deaths: §b" + deaths + "\n" +
                "§7Jailet spillere: §b" + jailedPlayerAmount + "\n" +
                "§7Mined blocks: §b" + blocksMined + "\n" +
                "§7Fixet fængslet: §b" + fixedJail;
    }
}
