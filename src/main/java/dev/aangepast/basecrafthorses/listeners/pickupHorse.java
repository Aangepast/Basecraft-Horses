package dev.aangepast.basecrafthorses.listeners;

import dev.aangepast.basecrafthorses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class pickupHorse implements Listener {

    private Main plugin;

    public pickupHorse(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void pickupHorse(PlayerInteractAtEntityEvent e){

        if(e.getRightClicked() instanceof Horse){

            if(e.getPlayer().isSneaking()){

                e.setCancelled(true);

                String[] name = e.getRightClicked().getName().split(" - ");
                Player player = e.getPlayer();

                if(name[1].equals(ChatColor.RED + player.getName())){

                    e.getRightClicked().remove();

                    Inventory inv = e.getPlayer().getInventory();


                    ItemStack horse = new ItemStack(Material.SADDLE);
                    ItemMeta horseMeta = horse.getItemMeta();
                    horseMeta.setDisplayName(name[0].replaceAll(ChatColor.DARK_GRAY.toString(), ""));
                    horse.setItemMeta(horseMeta);

                    if(inv.firstEmpty() != -1){

                        inv.addItem(horse);

                        player.sendMessage(ChatColor.GREEN + "You picked up your horse!");

                    } else {
                        e.getPlayer().getLocation().getWorld().dropItem(e.getRightClicked().getLocation(), horse);
                        player.sendMessage(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "! " + ChatColor.RED + "Your horse has been dropped because you have no inventory space.");
                    }



                } else {
                    player.sendMessage(ChatColor.RED + "This is not your horse!");
                    Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                        public void run() {
                            player.closeInventory();
                        }
                    }, 1);
                }

            }


        }


    }

}
