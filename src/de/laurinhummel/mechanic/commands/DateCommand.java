package de.laurinhummel.mechanic.commands;

import java.time.LocalTime;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class DateCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("mechanic.date")) {
		String world = player.getWorld().getName();
		long time = Bukkit.getServer().getWorld(world).getTime();
		//long time = time + 6000;
		long time2 = time + 6000;
		long time3 = time2 / 1000;
		long seconds = time3 * 60 * 60;
		LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds);
		player.sendMessage(McColors.GRAY + "It's " + McColors.RED + timeOfDay.toString() + McColors.GRAY + " o'clock in " + McColors.RED + world);
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
		return false;
		
	}
}
