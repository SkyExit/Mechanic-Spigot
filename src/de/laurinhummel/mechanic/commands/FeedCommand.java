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


public class FeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			FileConfiguration config = Main.getPlugin().getConfig();
			if(player.hasPermission("mechanic.feed")) {
				if(args.length == 0 ) {
					player.setFoodLevel(20);
					player.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + config.getString("Languages." + config.getString("Language") + ".Strings.youGotFeeded"));
				} else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						target.setFoodLevel(20);
						target.sendMessage(Names.MECHANIC2 + McColors.DARK_RED + config.getString("Languages." + config.getString("Language") + ".Strings.youGotFeeded"));
						player.sendMessage(Names.MECHANIC2 + McColors.GOLD + target.getName() + McColors.DARK_RED + " " + config.getString("Languages." + config.getString("Language") + ".Strings.heGotFeeded"));
					} else 
						player.sendMessage(Strings.missingPlayer);
				} else 
					player.sendMessage(Strings.NoParamsPlease);
			} else 
				player.sendMessage(Strings.NotEnoughtPermissions);
		} else
			sender.sendMessage(Strings.OnlyForPlayers);
	   return false;
	}

}