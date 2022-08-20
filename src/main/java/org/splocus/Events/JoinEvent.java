package org.splocus.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.splocus.DataHandling.StatsConfig;
import org.splocus.Managers.StatsManager;
import org.splocus.Models.GuardStats;
import org.splocus.Models.PlayerStats;

public class JoinEvent implements Listener {
    private final StatsManager statsManager;

    public JoinEvent(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("vagt.stats")) {
            statsManager.addPlayerStats(player.getUniqueId(), (GuardStats)StatsConfig.getStats(player.getUniqueId(), "GuardStats"));
        } else {
            statsManager.addPlayerStats(player.getUniqueId(), (PlayerStats)StatsConfig.getStats(player.getUniqueId(), "PlayerStats"));
        }
    }
}
