package com.example.game.util;

import com.example.game.model.PlayerStats;
import jakarta.servlet.ServletContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatsManager {
    private static final String STATS_MAP_KEY = "playerStatsMap";

    public static Map<String, PlayerStats> getStatsMap(ServletContext context) {
        @SuppressWarnings("unchecked")
        Map<String, PlayerStats> statsMap = (Map<String, PlayerStats>) context.getAttribute(STATS_MAP_KEY);

        if (statsMap == null) {
            statsMap = new ConcurrentHashMap<>();
            context.setAttribute(STATS_MAP_KEY, statsMap);
        }

        return statsMap;
    }

    public static PlayerStats getPlayerStats(ServletContext context, String playerName) {
        if (playerName == null || playerName.trim().isEmpty()) {
            return null;
        }
        Map<String, PlayerStats> statsMap = getStatsMap(context);
        return statsMap.computeIfAbsent(playerName, PlayerStats::new);
    }

    public static void updatePlayerStats(ServletContext context, String playerName, boolean isWin) {
        if (playerName == null || playerName.trim().isEmpty()) {
            return;
        }

        PlayerStats stats = getPlayerStats(context, playerName);
        if (stats != null) {
            if (isWin) {
                stats.incrementWins();
            } else {
                stats.incrementLosses();
            }
        }
    }
}
