package org.splocus.DataHandling;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.splocus.Models.GuardStats;
import org.splocus.Models.PlayerStats;
import org.splocus.Models.Stats;
import org.splocus.SPStatsSystem;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class StatsConfig {

    private static SPStatsSystem spStatsSystem;

    public StatsConfig(SPStatsSystem spStatsSystem) {
        this.spStatsSystem = spStatsSystem;
    }

    public static void saveStats(UUID uuid, Stats stats) {
        File uuidFile = getUUIDFile(uuid);
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(uuidFile);
        if (stats instanceof GuardStats)  {
            configuration.set("GuardStats", (GuardStats)stats);
        } else if (stats instanceof PlayerStats)  {
            configuration.set("PlayerStats", (PlayerStats)stats);
        }
        saveConfiguration(configuration, uuidFile);
    }

    public static Object getStats(UUID uuid, String path) {
        File uuidFile = getUUIDFile(uuid);
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(uuidFile);
        return configuration.get(path);
    }


    private static File getUUIDFile(UUID uuid) {
        File file = new File(spStatsSystem.getDataFolder() + "/playerData", uuid + ".yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
                setDefaultValues(file);
            } catch (IOException e) {
                //Error
            }
        }
        return file;
    }

    private static void saveConfiguration(FileConfiguration configuration, File file) {
        try {
            configuration.save(file);
        } catch (IOException e) {
            //Error
        }
    }

    private static void setDefaultValues(File file) {
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        configuration.set("PlayerStats", new PlayerStats());
        configuration.set("GuardStats", new GuardStats());
        saveConfiguration(configuration, file);
    }
}
