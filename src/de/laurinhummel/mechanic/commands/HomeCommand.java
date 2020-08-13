package de.laurinhummel.mechanic.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class HomeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			FileConfiguration players = Main.getPlugin().getConfig();
			if(player.hasPermission("mechanic.home")) {
				if(args.length == 0) {
					UUID UUID = player.getUniqueId();
					String home = players.getString("homes." + UUID + ".World");
					
					if(home != null) {
					
						World world = Bukkit.getWorld(players.getString("homes." + UUID + ".World"));
						double x = players.getDouble("homes." + UUID + ".X");
						double y = players.getDouble("homes." + UUID + ".Y");
						double z = players.getDouble("homes." + UUID + ".Z");
						float yaw = (float) players.getDouble("homes." + UUID + ".Yaw");
						float pitch = (float) players.getDouble("homes." + UUID + ".Pitch");
						Location location = new Location(world, x, y, z, yaw, pitch);
						player.teleport(location);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + players.getString("Languages." + players.getString("Language") + ".Strings.Homes.teleporting"));
					
					} else {
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + players.getString("Languages." + players.getString("Language") + ".Strings.Homes.noHomes"));
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