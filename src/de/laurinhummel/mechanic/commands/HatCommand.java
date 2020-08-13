package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class HatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("mechanic.hat")) {
		@SuppressWarnings("deprecation")
		ItemStack item = player.getItemInHand();
		String itemname = item.toString();
		player.getInventory().setHelmet(item);
		player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Now you're wearing a " + McColors.GOLD + itemname);
		
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
		return false;
	}
	

}
