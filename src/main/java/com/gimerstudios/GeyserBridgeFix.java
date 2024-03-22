package com.gimerstudios;

import org.bukkit.plugin.java.JavaPlugin;

public final class GeyserBridgeFix extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig(); // Saves a config.yml file in the plugin's data folder if it doesn't exist
        getLogger().info("GeyserBridgeFix has been enabled.");
        getLogger().info("Beta Build 1.0");
        getServer().getPluginManager().registerEvents(new BlockPlacementListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("GeyserBridgeFix has been disabled.");
        getLogger().info("Beta Build 1.0");
    }
}

