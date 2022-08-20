package org.splocus;

import org.splocus.DataHandling.StatsConfig;
import org.splocus.Managers.StatsManager;

public class SPStatsSystemProvider {

    private final StatsManager statsManager;

    public SPStatsSystemProvider(StatsManager statsManager) {
        this.statsManager = statsManager;
    }


    private static SPStatsSystemProvider spStatsSystemProvider;
    private static SPStatsSystemProvider getProvider() {
        return spStatsSystemProvider;
    }

    public StatsManager getStatsManager() {
        return statsManager;
    }
}
