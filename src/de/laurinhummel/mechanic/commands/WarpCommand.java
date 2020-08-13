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

public class WarpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			FileConfiguration players = Main.getPlugin().getConfig();
			if(player.hasPermission("mechanic.warp")) {
				if(args.length == 1) {
					
					String warpname = args[0];
					String warp = players.getString("warps." + warpname + ".World");
					if(warp != null) {
						World world = Bukkit.getWorld(players.getString("warps." + warpname + ".World"));
						double x = players.getDouble("warps." + warpname + ".X");
						double y = players.getDouble("warps." + warpname + ".Y");
						double z = players.getDouble("warps." + warpname + ".Z");
						float yaw = (float) players.getDouble("warps." + warpname + ".Yaw");
						float pitch = (float) players.getDouble("warps." + warpname + ".Pitch");
						Location location = new Location(world, x, y, z, yaw, pitch);
						player.teleport(location);
						player.sendMessage(Names.MECHANIC2 + "Teleporting...");
					} else {
						player.sendMessage(Names.MECHANIC2 + "There is no warp called like this!");
					}
					
				} else {
					player.sendMessage(Names.MECHANIC2 + "You have to set a Warp-name!");
				}
			} else {
				player.sendMessage(Strings.NotEnoughtPermissions);
			}
			
		}
	
	return false;

	}
}
