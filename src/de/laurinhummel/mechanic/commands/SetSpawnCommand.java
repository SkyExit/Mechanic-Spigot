package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class SetSpawnCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("mechanic.setSpawn")) {
				if(args.length == 0) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Spawn.World", player.getWorld().getName());
					config.set("Spawn.X", player.getLocation().getX());
					config.set("Spawn.Y", player.getLocation().getY());
					config.set("Spawn.Z", player.getLocation().getZ());
					config.set("Spawn.Yaw", player.getLocation().getYaw());
					config.set("Spawn.Pitch", player.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					player.sendMessage(Names.MECHANIC2 + "Spawn set!");
					
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
