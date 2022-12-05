package dev.aangepast.basecrafthorses.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class getHorse implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;
            ItemStack brownHorse = new ItemStack(Material.SADDLE);
            ItemMeta brownHorseMeta = brownHorse.getItemMeta();
            brownHorseMeta.setDisplayName(ChatColor.GOLD + "Brown Horse");
            brownHorse.setItemMeta(brownHorseMeta);

            player.getInventory().addItem(brownHorse);

        }


        return true;
    }
}
