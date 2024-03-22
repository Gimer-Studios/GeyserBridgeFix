package com.gimerstudios;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class BlockPlacementListener implements Listener {

    private final GeyserBridgeFix plugin;

    public BlockPlacementListener(GeyserBridgeFix plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        // Get the block's location
        Location blockLocation = event.getBlockPlaced().getLocation();

        // Get the player's location
        Location playerLocation = player.getLocation();

        // Check if the block is being placed more than 5 blocks away from the player
        if (blockLocation.distance(playerLocation) > 5) {
            event.setCancelled(true);
        }

        // Check if the block is being placed in the air
        if (blockLocation.getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
            event.setCancelled(true);
            // Teleport the player back to their previous location
            player.teleport(playerLocation);
            // Send the player a message
            player.sendMessage("You cannot build using this method due to an unfair advantage.");

            // If warning is enabled in the config, freeze the player for 5 seconds
            if (plugin.getConfig().getBoolean("warning")) {
                freezePlayer(player, 5);
            }
        }
    }

    private void freezePlayer(Player player, int seconds) {
        // Prevent the player from moving
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, seconds * 20, 255));

        // Schedule a task to remove the effect after the specified number of seconds
        Bukkit.getScheduler().runTaskLater(plugin, () -> player.removePotionEffect(PotionEffectType.SLOW), seconds * 20);
    }
}





