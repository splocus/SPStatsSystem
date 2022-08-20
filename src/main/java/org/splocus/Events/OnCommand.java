package org.splocus.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class OnCommand implements Listener {
    @EventHandler
    public void onCMD(PlayerCommandPreprocessEvent e) {
        String command = e.getMessage().substring(1);
        if (command.equals("stats")) {
            e.getPlayer().performCommand("stat");
            e.setCancelled(true);
        }
    }
}
