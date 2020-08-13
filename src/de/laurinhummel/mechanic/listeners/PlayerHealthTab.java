package de.laurinhummel.mechanic.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerHealthTab implements Listener {
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player pl = event.getPlayer();
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
		Objective tablist = scoreboard.getObjective("htl");
		if (tablist == null) {
		    String dName = ChatColor.RED + "\u2665";
		    tablist = scoreboard.registerNewObjective("htl", "health", dName, RenderType.HEARTS);
		    tablist.setDisplaySlot(DisplaySlot.PLAYER_LIST);
		    
		    pl.setScoreboard(scoreboard);
		} else {
			pl.setScoreboard(scoreboard);
		}
	} 
			
		
	}
