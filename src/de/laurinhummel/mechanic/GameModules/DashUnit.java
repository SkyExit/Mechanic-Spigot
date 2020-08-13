package de.laurinhummel.mechanic.GameModules;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import de.laurinhummel.mechanic.shortcuts.McColors;

public class DashUnit implements Listener {
	@EventHandler
	@SuppressWarnings({ "deprecation" })
	public static void onPlayerJump(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		
		ItemStack dashUnit = new ItemStack(Material.CARROT_ON_A_STICK);
		ItemMeta dashUnitMeta = dashUnit.getItemMeta();
		dashUnitMeta.setDisplayName(McColors.AQUA + "Dash Unit");
		dashUnitMeta.setUnbreakable(true);
		dashUnit.setItemMeta(dashUnitMeta);
		
	        if(player.getItemInHand().equals(dashUnit)) {
	        	Location loc = player.getLocation();
	        	Vector dir = loc.getDirection();
	        	dir.normalize();
	        	dir.multiply(5);
	        	loc.add(dir);
	        	player.teleport(loc);
	        	
	        }
	}
}
