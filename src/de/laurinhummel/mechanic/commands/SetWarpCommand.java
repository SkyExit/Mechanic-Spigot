package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class SetWarpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("mechanic.setWarp")) {
				if(args.length == 1) {
					
					String warpname = args[0];
					
					FileConfiguration players = Main.getPlugin().getConfig();
					players.set("warps." + warpname + ".World", player.getWorld().getName());
					players.set("warps." + warpname + ".X", player.getLocation().getX());
					players.set("warps." + warpname + ".Y", player.getLocation().getY());
					players.set("warps." + warpname + ".Z", player.getLocation().getZ());
					players.set("warps." + warpname + ".Yaw", player.getLocation().getYaw());
					players.set("warps." + warpname + ".Pitch", player.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					player.sendMessage(Names.MECHANIC2 + "Warp " + warpname + " set!");
					
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