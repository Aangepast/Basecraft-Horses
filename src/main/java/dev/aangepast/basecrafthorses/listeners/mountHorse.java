package dev.aangepast.basecrafthorses.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class mountHorse implements Listener {

    @EventHandler
    public void mountHorse(EntityMountEvent e) {

        if (!(e.getMount() instanceof Horse)) return;
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        Horse horse = (Horse) e.getMount();

        String[] name = horse.getName().split(" - ");
        if (!name[1].equals(ChatColor.RED + player.getName())) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "This is not your horse!");

        }

    }
}

