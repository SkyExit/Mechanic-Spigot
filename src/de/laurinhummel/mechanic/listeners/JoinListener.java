package de.laurinhummel.mechanic.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import me.clip.placeholderapi.PlaceholderAPI;

public class JoinListener implements Listener {
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String playerName = player.getDisplayName();
		String servername = "MAIN Clan Server";
		player.sendMessage(Names.MECHANIC2 + McColors.AQUA +"Welcome to " + McColors.GOLD + servername);
		event.setJoinMessage( Names.MECHANIC2 + McColors.GOLD + playerName + McColors.AQUA + " Joined the Server!");
	
	}
	
	
}
