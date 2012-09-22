package com.gtdclan.allflint;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public Logger log;
	
	@EventHandler
	public void ItemSpawnEvent(ItemSpawnEvent event) {
		ItemStack item = event.getEntity().getItemStack();
		
		if (item.getType() == Material.GRAVEL) {
			item.setType(Material.FLINT);
		}
	}
	
	@Override
	public void onDisable() {
		
		this.log.log(Level.INFO, this.getDescription().getName() + " has been disabled.");
	}
	
	@Override
	public void onEnable() {
		this.log = this.getLogger();
		// Register events.
		
		PluginManager PluginManager = this.getServer().getPluginManager();
		PluginManager.registerEvents(this, this);
		
		this.log.log(Level.INFO, this.getDescription().getName() + " has been enabled.");
	}
}
