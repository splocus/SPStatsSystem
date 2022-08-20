package org.splocus.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.splocus.Managers.StatsManager;
import org.splocus.Models.GuardStats;
import org.splocus.Models.PlayerStats;
import org.splocus.Models.Stats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StatsCommand implements CommandExecutor {
    private final StatsManager statsManager;

    public StatsCommand(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player)sender;
        player.sendMessage("\n§3§lDINE STATS:\n");
        Stats stats = statsManager.getPlayerStats().get(player.getUniqueId());
        player.sendMessage(stats.toString());

        player.sendMessage("\n");
        return true;
    }
}
