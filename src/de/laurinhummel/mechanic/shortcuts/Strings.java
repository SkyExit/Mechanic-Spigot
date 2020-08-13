package de.laurinhummel.mechanic.shortcuts;

import org.bukkit.configuration.file.FileConfiguration;

import de.laurinhummel.mechanic.main.Main;

public class Strings {
	static FileConfiguration config = Main.getPlugin().getConfig();
	 //Colors
	 public static final String NotEnoughtPermissions = Names.MECHANIC2 + McColors.RED + config.getString("Languages." + config.getString("Language") + ".Strings.noPermissions");
	 public static final String NoParamsPlease = Names.MECHANIC2 + McColors.RED + config.getString("Languages." + config.getString("Language") + ".Strings.noParamsPlease");
	 public static final String OnlyForPlayers = Names.MECHANIC1 + Colors.RED + config.getString("Languages." + config.getString("Language") + ".Strings.onlyPlayers");
	 public static final String missingPlayer = Names.MECHANIC2 + McColors.RED + config.getString("Languages." + config.getString("Language") + ".Strings.missingPlayer");
	 public static final String mentionPlease = Names.MECHANIC2 + McColors.RED + config.getString("Languages." + config.getString("Language") + ".Strings.mentionPlease");
}
