package de.laurinhummel.mechanic.listeners;

import java.util.UUID;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;

public class PlayerDeathListener implements Listener {
		@EventHandler
	    public void onPlayerDeath(PlayerDeathEvent event) {
	     
	    	FileConfiguration playerDeathPos = Main.getPlugin().getConfig();
	        Player player = event.getEntity().getPlayer();
	        UUID UUID = player.getUniqueId();
	        
	        int x = (int) player.getLocation().getX();
	        int y = (int) player.getLocation().getY();
	        int z = (int) player.getLocation().getZ();
	        String world = player.getLocation().getWorld().getName();
	        String playerName = player.getDisplayName();
	        
	        playerDeathPos.set("DeathLoc." + UUID + ".x", x);
	        playerDeathPos.set("DeathLoc." + UUID + ".y", y);
	        playerDeathPos.set("DeathLoc." + UUID + ".z", z);
	        playerDeathPos.set("DeathLoc." + UUID + ".world", world);
	        
		
		event.setDeathMessage(Names.MECHANIC2 +McColors.GOLD  + playerName + McColors.AQUA + " died at coordinates " + McColors.AQUA + "X: " + McColors.GOLD + x + McColors.AQUA + " Y: " + McColors.GOLD + y + McColors.AQUA + " Z: " + McColors.GOLD + z + McColors.AQUA + " in World: " + McColors.GOLD + world);
		String msg = "test";
		}
}
