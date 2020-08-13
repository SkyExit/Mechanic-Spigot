package de.laurinhummel.mechanic.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class SuicideCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("mechanic.suicide")) {
				if(player.getGameMode() == GameMode.SURVIVAL) {
					player.damage(20);
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You killed yourself");
				} else {
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You need to be in gamemode " + McColors.GOLD + "survival");
				}
			} else 
				player.sendMessage(Strings.NotEnoughtPermissions);
		} else
			sender.sendMessage(Strings.OnlyForPlayers);
	   return false;
	}

}
