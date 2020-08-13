package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class WorkbenchCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("mechanic.workbench")) {
			if(sender instanceof Player) {
				player.openWorkbench(null, true);
				player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Opening Workbench...");
			} else {
				player.sendMessage(Strings.OnlyForPlayers);
			}
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
	return false;
	}
}
