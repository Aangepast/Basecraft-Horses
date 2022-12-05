package dev.aangepast.basecrafthorses;

import dev.aangepast.basecrafthorses.commands.getHorse;
import dev.aangepast.basecrafthorses.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("gethorse").setExecutor(new getHorse());
        Bukkit.getPluginManager().registerEvents(new breedHorse(), this);
        Bukkit.getPluginManager().registerEvents(new horseInv(), this);
        Bukkit.getPluginManager().registerEvents(new spawnHorse(), this);
        Bukkit.getPluginManager().registerEvents(new pickupHorse(this), this);
        Bukkit.getPluginManager().registerEvents(new mountHorse(), this);
        Bukkit.getPluginManager().registerEvents(new onKill(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
