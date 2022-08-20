package org.splocus.Events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.splocus.Managers.StatsManager;

public class PlaceholderListener implements Listener {

    private final StatsManager statsManager;

    public PlaceholderListener(StatsManager statsManager) {
        this.statsManager = statsManager;
    }


    private void registerPlaceholder() {
        PlaceholderAPI.registerPlaceholderHook("spstats", new PlaceholderHook() {
            @Override
            public String onRequest(OfflinePlayer p, String params) {
                return super.onRequest(p, params);
            }

            @Override
            public String onPlaceholderRequest(Player p, String params) {
                return super.onPlaceholderRequest(p, params);
            }
        });
    }


}
