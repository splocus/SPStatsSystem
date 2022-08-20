package org.splocus;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;
import org.splocus.Commands.StatsCommand;
import org.splocus.DataHandling.StatsConfig;
import org.splocus.Events.JoinEvent;
import org.splocus.Events.OnCommand;
import org.splocus.Events.OverworldEvents;
import org.splocus.Events.QuitEvent;
import org.splocus.Managers.StatsManager;
import org.splocus.Models.GuardStats;
import org.splocus.Models.PlayerStats;

public final class SPStatsSystem extends JavaPlugin {

    private StatsManager statsManager;
    private StatsConfig statsConfig;
    private static SPStatsSystemProvider spStatsSystemProvider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigurationSerialization.registerClass(GuardStats.class);
        ConfigurationSerialization.registerClass(PlayerStats.class);

        this.statsConfig = new StatsConfig(this);
        this.statsManager = new StatsManager(this);
        spStatsSystemProvider = new SPStatsSystemProvider(statsManager);

        getCommand("stat").setExecutor(new StatsCommand(statsManager));
        getServer().getPluginManager().registerEvents(new JoinEvent(statsManager), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(statsManager), this);
        getServer().getPluginManager().registerEvents(new OverworldEvents(statsManager), this);
        getServer().getPluginManager().registerEvents(new OnCommand(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveData();
    }

    public StatsManager getStatsManager() {
        return statsManager;
    }

    private void saveData() {
        statsManager.saveData();
    }

    //Get provider
    public static SPStatsSystemProvider getSpStatsSystemProvider() {
        return spStatsSystemProvider;
    }
}
