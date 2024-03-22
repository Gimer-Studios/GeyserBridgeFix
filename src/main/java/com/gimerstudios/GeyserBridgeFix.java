package com.gimerstudios;

import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

public final class GeyserBridgeFix extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("GeyserBridgeFix has been enabled.");
        getLogger().info("Beta Build 1.0");
        getServer().getPluginManager().registerEvents(new BlockPlacementListener(this), this);
        int pluginId = 21397;
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        getLogger().info("GeyserBridgeFix has been disabled.");
        getLogger().info("Beta Build 1.0");
    }
}

