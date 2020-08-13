package de.laurinhummel.mechanic.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class SpawnCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("mechanic.spawn")) {
				if(args.length == 0) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					
					String spawn2 = config.getString("Spawn.World");
					if(spawn2 != null) {
					
						World world = Bukkit.getWorld(config.getString("Spawn.World"));
						double x = config.getDouble("Spawn.X");
						double y = config.getDouble("Spawn.Y");
						double z = config.getDouble("Spawn.Z");
						float yaw = (float) config.getDouble("Spawn.Yaw");
						float pitch = (float) config.getDouble("Spawn.Pitch");
						Location location = new Location(world, x, y, z, yaw, pitch);
						player.teleport(location);
						player.sendMessage(Names.MECHANIC2 + "Teleporting...");
						
					} else {
						player.sendMessage(Names.MECHANIC2 + "You don't have any spawns!");
					}
					
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
