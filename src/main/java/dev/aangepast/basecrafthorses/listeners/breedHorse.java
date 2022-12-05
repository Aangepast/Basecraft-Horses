package dev.aangepast.basecrafthorses.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class breedHorse implements Listener {

    @EventHandler
    public void breedHorse(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if(e.getClick() == ClickType.DOUBLE_CLICK){

            Inventory inv = e.getClickedInventory();
            ItemStack clicked = inv.getItem(e.getSlot());

            ItemStack brownHorse = new ItemStack(Material.SADDLE);
            ItemMeta brownHorseMeta = brownHorse.getItemMeta();
            brownHorseMeta.setDisplayName(ChatColor.GOLD + "Stride Horse");
            brownHorse.setItemMeta(brownHorseMeta);

            ItemStack strideHorse = new ItemStack(Material.SADDLE);
            ItemMeta strideHorseMeta = strideHorse.getItemMeta();
            strideHorseMeta.setDisplayName(ChatColor.GOLD + "Stride Horse");
            strideHorse.setItemMeta(strideHorseMeta);

            ItemStack mustangHorse = new ItemStack(Material.SADDLE);
            ItemMeta mustangHorseMeta = mustangHorse.getItemMeta();
            mustangHorseMeta.setDisplayName(ChatColor.GOLD + "Mustang Horse");
            mustangHorse.setItemMeta(mustangHorseMeta);

            ItemStack americanHorse = new ItemStack(Material.SADDLE);
            ItemMeta americanHorseMeta = americanHorse.getItemMeta();
            americanHorseMeta.setDisplayName(ChatColor.GOLD + "American Horse");
            americanHorse.setItemMeta(americanHorseMeta);

            ItemStack arabainHorse = new ItemStack(Material.SADDLE);
            ItemMeta arabainHorseMeta = arabainHorse.getItemMeta();
            arabainHorseMeta.setDisplayName(ChatColor.GOLD + "Arabain Horse");
            arabainHorse.setItemMeta(arabainHorseMeta);

            ItemStack quarterHorse = new ItemStack(Material.SADDLE);
            ItemMeta quarterHorseMeta = quarterHorse.getItemMeta();
            quarterHorseMeta.setDisplayName(ChatColor.GOLD + "Quarter Horse");
            quarterHorse.setItemMeta(quarterHorseMeta);

            if(clicked != null){

                if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Brown Horse") || clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Stride Horse") || clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "American Horse") || clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Arabain Horse") || clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Mustang Horse")){

                    if(e.getView().getCursor().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Brown Horse")){

                        breedHorses(player, strideHorse, e, 0.8);

                    } else if(e.getView().getCursor().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Stride Horse")){

                        breedHorses(player, mustangHorse, e, 0.7);

                    } else if(e.getView().getCursor().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Mustang Horse")){

                        breedHorses(player, americanHorse, e, 0.6);

                    }else if(e.getView().getCursor().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "American Horse")){

                        breedHorses(player, arabainHorse, e, 0.5);

                    } else if(e.getView().getCursor().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Arabain Horse")){

                        breedHorses(player, quarterHorse, e, 0.5);

                    }

                }

            }

        }


    }

    private void breedHorses(Player player, ItemStack horse, InventoryClickEvent e, double chance){

        double random = Math.random();

        if(random <= chance){

            e.setCurrentItem(horse);
            e.getView().setCursor(null);
            player.sendMessage(ChatColor.GREEN + "You've succesfully breeded your horses!");
            player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1, 1);

        } else {
            player.sendMessage(ChatColor.RED + "Unfortunately your horses did not breed succesfully.");
            e.getView().setCursor(null);
        }


    }


}
