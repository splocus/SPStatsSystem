package org.splocus.Models;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class PlayerStats extends Stats implements ConfigurationSerializable {

    private double convertedMoney;
    private int jailAmount;

    public PlayerStats() {
        super();
        convertedMoney = 0;
        jailAmount = 0;
    }

    public PlayerStats(int kills, int deaths, int blocksMined, double convertedMoney, int jailAmount) {
        super(kills, deaths, blocksMined);
        this.convertedMoney = convertedMoney;
        this.jailAmount = jailAmount;
    }


    public double getConvertedMoney() {
        return convertedMoney;
    }

    public int getJailAmount() {
        return jailAmount;
    }

    public void setConvertedMoney(double convertedMoney) {
        this.convertedMoney = convertedMoney;
    }

    public void setJailAmount(int jailAmount) {
        this.jailAmount = jailAmount;
    }


    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();
        result.put("kills", kills);
        result.put("deaths", deaths);
        result.put("blocksMined", blocksMined);
        result.put("convertedMoney", convertedMoney);
        result.put("jailAmount", jailAmount);
        return result;
    }

    public PlayerStats(Map<String, Object> serializedJailedInfo) {
        super((int)serializedJailedInfo.get("kills"),
                (int)serializedJailedInfo.get("deaths"),
                (int)serializedJailedInfo.get("blocksMined"));
        this.convertedMoney = (double)serializedJailedInfo.get("convertedMoney");
        this.jailAmount = (int)serializedJailedInfo.get("jailAmount");
    }

    public static PlayerStats deserialize(Map<String, Object> args) {
        return new PlayerStats((int)args.get("kills"),
                (int)args.get("deaths"),
                (int)args.get("blocksMined"),
                (double)args.get("convertedMoney"),
                (int)args.get("jailAmount"));
    }

    @Override
    public String toString() {
        return "§7Kills: §b" + kills + "\n" +
                "§7Deaths: §b" + deaths + "\n" +
                "§7Konverteret penge: §b" + convertedMoney + "\n" +
                "§7Jailet gange: §b" + jailAmount + "\n" +
                "§7Mined blocks: §b" + blocksMined;
    }
}
