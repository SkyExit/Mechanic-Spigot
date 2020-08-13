package de.laurinhummel.mechanic.commands;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;

public class LatestDeathLocationCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		FileConfiguration deathLoc = Main.getPlugin().getConfig();
		if(sender instanceof Player) {
			Player player = (Player) sender;
			UUID UUID = player.getUniqueId();
			
			int x = deathLoc.getInt("DeathLoc." + UUID + ".x");
			int y = deathLoc.getInt("DeathLoc." + UUID + ".y");
			int z = deathLoc.getInt("DeathLoc." + UUID + ".z");
			String world = deathLoc.getString("DeathLoc." + UUID + ".world");
			
			if(world != null) {
				player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You died at coordinates " + McColors.AQUA + "X: " + McColors.GOLD + x + McColors.AQUA + " Y: " + McColors.GOLD + y + McColors.AQUA + " Z: " + McColors.GOLD + z + McColors.AQUA + " in World: " + McColors.GOLD + world);
			}
		}
		return false;
	}

}
