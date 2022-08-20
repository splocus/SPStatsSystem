package org.splocus;

import org.splocus.DataHandling.StatsConfig;
import org.splocus.Managers.StatsManager;

public class SPStatsSystemProvider {

    private final StatsManager statsManager;

    public SPStatsSystemProvider(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    public StatsManager getStatsManager() {
        return statsManager;
    }
}
