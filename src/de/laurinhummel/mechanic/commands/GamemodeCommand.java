package de.laurinhummel.mechanic.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			FileConfiguration config = Main.getPlugin().getConfig();
			if(player.hasPermission("mechanic.gm")) {
				if(args.length == 1) {
					if(args[0].equals("0")) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + config.getString("Languages." + config.getString("Language") + ".Strings.Gamemode.survival"));
					} else if(args[0].equals("1")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + config.getString("Languages." + config.getString("Language") + ".Strings.Gamemode.creative"));
					} else if(args[0].equals("2")) {
						player.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + config.getString("Languages." + config.getString("Language") + ".Strings.Gamemode.adventure"));
					} else if(args[0].equals("3")) {
						player.setGameMode(GameMode.SPECTATOR);
						player.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + config.getString("Languages." + config.getString("Language") + ".Strings.Gamemode.spectator"));
					}
				} else {
					player.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + config.getString("Languages." + config.getString("Language") + ".Strings.Gamemode.paramPlease"));
				}
			} else 
				player.sendMessage(Strings.NotEnoughtPermissions);
		} else
			sender.sendMessage(Strings.OnlyForPlayers);
	   return false;
	}

}