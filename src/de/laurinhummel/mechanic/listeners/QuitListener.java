package de.laurinhummel.mechanic.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import me.clip.placeholderapi.PlaceholderAPI;

public class QuitListener implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		String playerName = player.getDisplayName();
		event.setQuitMessage(Names.MECHANIC2 + McColors.GOLD + playerName + McColors.AQUA + " Left the Server!");
	}

}
