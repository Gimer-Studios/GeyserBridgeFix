package com.gimerstudios;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.Vector;

public class BlockPlacementListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        for (MetadataValue meta : player.getMetadata("ClientVersion")) {
            if (meta.asString().contains("Java")) {
                // Get the block's location
                Location blockLocation = event.getBlockPlaced().getLocation();

                // Get the player's location and direction
                Location playerLocation = player.getLocation();
                Vector playerDirection = playerLocation.getDirection();

                // Create a vector from the player to the block
                Vector toBlock = blockLocation.subtract(playerLocation).toVector();

                // Check if the block is being placed in front of the player
                if (playerDirection.dot(toBlock) > 0) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
