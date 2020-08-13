package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class FlySpeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("mechanic.flySpeed")) {
				if(args.length == 1) {
					if(args[0].equals("1")) {
						player.setFlySpeed((float) 0.1);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("2")) {
						player.setFlySpeed((float) 0.2);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("3")) {
						player.setFlySpeed((float) 0.3);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("4")) {
						player.setFlySpeed((float) 0.4);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("5")) {
						player.setFlySpeed((float) 0.5);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("6")) {
						player.setFlySpeed((float) 0.6);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("7")) {
						player.setFlySpeed((float) 0.7);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("8")) {
						player.setFlySpeed((float) 0.8);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("9")) {
						player.setFlySpeed((float) 0.9);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("10")) {
						player.setFlySpeed((float) 1.0);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("0")) {
						player.setFlySpeed((float) 0.0);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-1")) {
						player.setFlySpeed((float) -0.1);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-2")) {
						player.setFlySpeed((float) -0.2);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-3")) {
						player.setFlySpeed((float) -0.3);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-4")) {
						player.setFlySpeed((float) -0.4);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-5")) {
						player.setFlySpeed((float) -0.5);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-6")) {
						player.setFlySpeed((float) -0.6);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-7")) {
						player.setFlySpeed((float) -0.7);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-8")) {
						player.setFlySpeed((float) -0.8);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-9")) {
						player.setFlySpeed((float) -0.9);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					} else if(args[0].equals("-10")) {
						player.setFlySpeed((float) -1.0);
						player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Flyspeed was set to " + McColors.GOLD + args[0]);
					}
				} else {
					player.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + "Please use a Parameter between 1-10!");
				}
			} else 
				player.sendMessage(Strings.NotEnoughtPermissions);
		} else
			sender.sendMessage(Strings.OnlyForPlayers);
	   return false;
	}

}