package dev.aangepast.basecrafthorses.listeners;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class horseInv implements Listener {

    @EventHandler
    public void horseInventory(InventoryOpenEvent e){

        Player player = (Player) e.getPlayer();

        if(player.getVehicle() instanceof Horse){

            e.setCancelled(true);

        }

    }

}
