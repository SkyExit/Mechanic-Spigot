package de.laurinhummel.mechanic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class EnderchestCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		FileConfiguration config = Main.getPlugin().getConfig();
		if(player.hasPermission("mechanic.enderchest")) {
			if(sender instanceof Player) {
				if(args.length == 0) {
					player.openInventory(player.getEnderChest());
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + config.getString("Languages." + config.getString("Language") + ".Strings.Enderchest.openingEnderchest"));
				} else if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						player.openInventory(target.getEnderChest());
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + config.getString("Languages." + config.getString("Language") + ".Strings.Enderchest.openingEnderchest"));
					} else {
						player.sendMessage(Strings.missingPlayer);
					}
				} else {
					player.sendMessage(Strings.NoParamsPlease);
				}
			} else {
				player.sendMessage(Strings.OnlyForPlayers);
			}
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
	return false;
	}
}
