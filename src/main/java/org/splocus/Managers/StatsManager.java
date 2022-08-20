package org.splocus.Managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.splocus.DataHandling.StatsConfig;
import org.splocus.Models.GuardStats;
import org.splocus.Models.PlayerStats;
import org.splocus.Models.Stats;
import org.splocus.SPStatsSystem;

import java.io.File;
import java.util.*;

public class StatsManager {

    private final SPStatsSystem spStatsSystem;
    private HashMap<UUID, Stats> playerStats;

    public HashMap<UUID, Stats> getPlayerStats() {
        return playerStats;
    }


    public StatsManager(SPStatsSystem spStatsSystem) {
        this.spStatsSystem = spStatsSystem;
        try {
            playerStats = loadData();
        } catch (Exception e) {
            playerStats = new HashMap<>();
        }
    }

    public void addPlayerStats(UUID uuid, Stats stats) {
        playerStats.put(uuid, stats);
    }

    public void savePlayerStats(UUID uuid) {
        StatsConfig.saveStats(uuid, playerStats.get(uuid));
        playerStats.remove(uuid);
    }


    public void saveData() {
        for (Map.Entry<UUID, Stats> entry : playerStats.entrySet()) {
            StatsConfig.saveStats(entry.getKey(), entry.getValue());
        }
    }

    private HashMap<UUID, Stats> loadData() {
        HashMap<UUID, Stats> temp = new HashMap<>();
        Stats stats;
        File file;
        FileConfiguration configuration;

        List<Player> onlinePlayers = (List<Player>) spStatsSystem.getServer().getOnlinePlayers();
        for (Player player : onlinePlayers) {
            file = new File(spStatsSystem.getDataFolder() + "/playerData/" + player.getUniqueId() + ".yml");
            if (file.exists()) {
                configuration =  YamlConfiguration.loadConfiguration(file);
                if (player.hasPermission("vagt.stats")) {
                    stats = (GuardStats)configuration.get("GuardStats");
                } else {
                    stats = (PlayerStats)configuration.get("PlayerStats");
                }
                temp.put(player.getUniqueId(), stats);
            }
        }
        return temp;
    }

    /*public HashMap<UUID, GuardStatsOld> loadData() {
        HashMap<UUID, GuardStatsOld> temp = new HashMap<>();
        UUID uuid;
        GuardStatsOld guardStats;
        FileConfiguration configuration;
        File folder = new File(spStatsSystem.getDataFolder() + "/playerData");
        for (File file : folder.listFiles()) {
            configuration = YamlConfiguration.loadConfiguration(file);
            uuid = UUID.fromString(file.getName().replace(".yml", ""));
            guardStats = (GuardStatsOld)configuration.get("GuardStats");
            temp.put(uuid, guardStats);
        }
        return temp;
    }*/
}
