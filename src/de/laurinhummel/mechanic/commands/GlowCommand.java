package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class GlowCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("mechanic.glow")) {
				if(player.isGlowing() == false) {
					player.setGlowing(true);
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Glowing like a " + McColors.GOLD + "GOD");
				} else {
					player.setGlowing(false);
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You're not glowing anymore");
				}
			} else 
				player.sendMessage(Strings.NotEnoughtPermissions);
		} else
			sender.sendMessage(Strings.OnlyForPlayers);
	   return false;
	}

}
