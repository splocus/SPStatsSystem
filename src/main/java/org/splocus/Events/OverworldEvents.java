package org.splocus.Events;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.splocus.Managers.StatsManager;
import org.splocus.Models.GuardStats;
import org.splocus.Models.PlayerStats;
import org.splocus.Models.Stats;

public class OverworldEvents implements Listener {
    private final org.splocus.Managers.StatsManager statsManager;

    public OverworldEvents(StatsManager statsManager) {
        this.statsManager = statsManager;
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (WorldGuardPlugin.inst().canBuild(player, event.getBlock())) {
            Stats stats = statsManager.getPlayerStats().get(player.getUniqueId());
            stats.addBlocksMined(1);
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {

        Player victim = ((Player) event.getEntity()).getPlayer();
        Player killer = event.getEntity().getKiller();
        if ((victim instanceof Player)) {
            Stats victimStats = statsManager.getPlayerStats().get(victim.getUniqueId());
            victimStats.addDeaths(1);
        }
        if ((killer instanceof Player)) {
            Stats killerStats = statsManager.getPlayerStats().get(killer.getUniqueId());
            killerStats.addKills(1);
        }
    }
}
