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

public class PositionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("mechanic.positions")) {
			FileConfiguration config = Main.getPlugin().getConfig();
			if(args.length == 2) {
				if(args[0].equals("set")) {
					double X = player.getLocation().getBlockX();
					double Y = player.getLocation().getBlockY();
					double Z = player.getLocation().getBlockZ();
					String world = player.getLocation().getWorld().getName();
					
					config.set("Location." + args[1] + ".x", X);
					config.set("Location." + args[1] + ".y", Y);
					config.set("Location." + args[1] + ".z", Z);
					config.set("Location." + args[1] + ".world", world);
					Main.getPlugin().saveConfig();
					
					for (Player p : Bukkit.getOnlinePlayers()) {
					    p.sendMessage(Names.MECHANIC2 + McColors.GOLD + player.getDisplayName() + McColors.AQUA + " added a Position called " + McColors.GOLD + args[1]);
					    p.sendMessage(Names.MECHANIC2 + McColors.AQUA + "X: " + McColors.GOLD + X + McColors.AQUA + " Y: " + McColors.GOLD + Y + McColors.AQUA + " Z: " + McColors.GOLD + Z + McColors.AQUA + " in World: " + McColors.GOLD + world);
					}
					
				} else if(args[0].equals("remove")) {
					String world = config.getString("Location." + args[1] + ".world");
					if(world != null) {
					config.set("Location." + args[1] + ".x", null);
					config.set("Location." + args[1] + ".y", null);
					config.set("Location." + args[1] + ".z", null);
					config.set("Location." + args[1] + ".world", null);
					Main.getPlugin().saveConfig();
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Removed: " + McColors.GOLD + args[1]);
					} else {
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Position " + McColors.GOLD + args[1] + McColors.AQUA + " isn't there!");
					}
					
				} else if(args[0].equals("get")) {
					double X = config.getDouble("Location." + args[1] + ".x");
					double Y = config.getDouble("Location." + args[1] + ".y");
					double Z = config.getDouble("Location." + args[1] + ".z");
					String world = config.getString("Location." + args[1] + ".world");
					
					if(world != null) {
						player.sendMessage(Names.MECHANIC2 +McColors.GOLD + args[1] + McColors.AQUA + " at coordinates " + McColors.AQUA + "X: " + McColors.GOLD + X + McColors.AQUA + " Y: " + McColors.GOLD + Y + McColors.AQUA + " Z: " + McColors.GOLD + Z + McColors.AQUA + " in World: " + McColors.GOLD + world);
					} else {
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Position " + McColors.GOLD + args[1] + McColors.AQUA + " isn't there!");
					}
					
				} else if(args[0].equals("list")) {
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Coming Soon!");
				} else {
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Invalid arguments!");
				}
			} else {
				player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You have to use " + McColors.GOLD + "/position set/remove/get");
			}
			
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
		return false;
	}

}
