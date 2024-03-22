package com.gimerstudios;

import org.bukkit.plugin.java.JavaPlugin;

public final class GeyserBridgeFix extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("GeyserBridgeFix has been enabled.");
        getLogger().info("DEV BUILD 0.1");
        getServer().getPluginManager().registerEvents(new BlockPlacementListener(), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("GeyserBridgeFix has been disabled.");
        getLogger().info("DEV BUILD 0.1");
    }
}
