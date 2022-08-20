package org.splocus.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.splocus.Managers.StatsManager;

public class QuitEvent implements Listener {
    private final StatsManager statsManager;
    public QuitEvent(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("vagt.stats")) {
            statsManager.savePlayerStats(player.getUniqueId());
        }
    }
}
