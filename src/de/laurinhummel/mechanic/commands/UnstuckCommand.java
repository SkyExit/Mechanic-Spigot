package de.laurinhummel.mechanic.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;

public class UnstuckCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("mechanic.unstuck")) {
			int newY = player.getWorld().getHighestBlockYAt(player.getLocation());
			double X = player.getLocation().getX();
			double Z = player.getLocation().getZ();
			Location newLoc = player.getLocation();
			newLoc.setX(X);
			newLoc.setY(newY);
			newLoc.setZ(Z);
			player.teleport(newLoc);
			player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "There you go!");
		}
		return false;
	}

}
