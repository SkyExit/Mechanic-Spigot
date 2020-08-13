package de.laurinhummel.mechanic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class NicknameCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("mechanic.nick")) {
			if(args.length == 2) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					String cmdExe = player.getDisplayName();
					String targetName = target.getDisplayName();
					String newName = args[1];
					target.setDisplayName(newName);
					target.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Your nickname changed to " + McColors.GOLD + newName + McColors.AQUA + " by " + McColors.GOLD + cmdExe);
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You changed the Nickname of " + McColors.GOLD + targetName + McColors.AQUA + " to " + McColors.GOLD + newName);
				} else {
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Player isn't there!");
				}
			} else {
				player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You have to mention a player and Set a Nickname!");
			}
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
		return false;
	}

}