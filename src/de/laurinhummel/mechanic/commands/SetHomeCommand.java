package de.laurinhummel.mechanic.commands;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class SetHomeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("mechanic.setHome")) {
				if(args.length == 0) {
					
					FileConfiguration players = Main.getPlugin().getConfig();
					UUID UUID = player.getUniqueId();
					players.set("homes." + UUID + ".World", player.getWorld().getName());
					players.set("homes." + UUID + ".X", player.getLocation().getX());
					players.set("homes." + UUID + ".Y", player.getLocation().getY());
					players.set("homes." + UUID + ".Z", player.getLocation().getZ());
					players.set("homes." + UUID + ".Yaw", player.getLocation().getYaw());
					players.set("homes." + UUID + ".Pitch", player.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					player.sendMessage(Names.MECHANIC2 + "Home set!");
					
				} else {
					player.sendMessage(Strings.NoParamsPlease);
				}
			} else {
				player.sendMessage(Strings.NotEnoughtPermissions);
			}
			
		}
		return false;
	}

}
