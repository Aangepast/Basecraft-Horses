package dev.aangepast.basecrafthorses.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class onKill implements Listener {

    @EventHandler
    public void onKill(EntityDeathEvent e){

        if(e.getEntity().equals(EntityType.HORSE)){

            e.setDroppedExp(0);
            e.getDrops().clear();

        }

    }

}
