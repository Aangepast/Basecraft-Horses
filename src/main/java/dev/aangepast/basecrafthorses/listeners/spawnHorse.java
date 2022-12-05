package dev.aangepast.basecrafthorses.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class spawnHorse implements Listener {

    @EventHandler
    public void spawnHorse(PlayerInteractEvent e){

        Player player = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            if(player.getInventory().getItemInMainHand().getType() == Material.SADDLE){

                ItemStack item = player.getInventory().getItemInMainHand();
                String name = item.getItemMeta().getDisplayName().replaceAll(ChatColor.GOLD + "", "");

                switch(name){
                    case "Brown Horse":
                        player.sendMessage(ChatColor.GREEN + "Spawning " + ChatColor.YELLOW + name + ChatColor.GREEN + "...");
                        spawnhorse(player,0.2,0.75, name);
                        player.getInventory().setItemInMainHand(null);
                        player.playSound(player.getLocation(), "entity.horse.armor",1,1);
                        break;
                    case "Stride Horse":
                        player.sendMessage(ChatColor.GREEN + "Spawning " + ChatColor.YELLOW + name + ChatColor.GREEN + "...");
                        spawnhorse(player,0.25,1.0, name);
                        player.getInventory().setItemInMainHand(null);
                        player.playSound(player.getLocation(), "entity.horse.armor",1,1);
                        break;
                    case "Mustang Horse":
                        player.sendMessage(ChatColor.GREEN + "Spawning " + ChatColor.YELLOW + name + ChatColor.GREEN + "...");
                        spawnhorse(player,0.3,1.1, name);
                        player.getInventory().setItemInMainHand(null);
                        player.playSound(player.getLocation(), "entity.horse.armor",1,1);
                        break;
                    case "American Horse":
                        player.sendMessage(ChatColor.GREEN + "Spawning " + ChatColor.YELLOW + name + ChatColor.GREEN + "...");
                        spawnhorse(player,0.35,1.15, name);
                        player.getInventory().setItemInMainHand(null);
                        player.playSound(player.getLocation(), "entity.horse.armor",1,1);
                        break;
                    case "Arabain Horse":
                        player.sendMessage(ChatColor.GREEN + "Spawning " + ChatColor.YELLOW + name + ChatColor.GREEN + "...");
                        spawnhorse(player,0.40,1.2, name);
                        player.getInventory().setItemInMainHand(null);
                        player.playSound(player.getLocation(), "entity.horse.armor",1,1);
                        break;
                    case "Quarter Horse":
                        player.sendMessage(ChatColor.GREEN + "Spawning " + ChatColor.YELLOW + name + ChatColor.GREEN + "...");
                        spawnhorse(player,0.45,1.25, name);
                        player.getInventory().setItemInMainHand(null);
                        player.playSound(player.getLocation(), "entity.horse.armor",1,1);
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Something went wrong while spawning your horse, please contact a staff member!");
                        break;

                }

            }

        }

    }

    private void spawnhorse(Player p, double speed, double jump, String name) {
        Horse h = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
        h.setTamed(true);
        h.setOwner(p);
        h.setAdult();
        h.setJumpStrength(jump);
        h.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
        h.setCustomName(ChatColor.GOLD + name + ChatColor.DARK_GRAY + " - " + ChatColor.RED + p.getName());
        h.getInventory().setSaddle(new ItemStack(Material.SADDLE));
    }

}
