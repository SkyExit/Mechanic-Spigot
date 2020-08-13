package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class NukeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		Entity entity = (Entity) player;
		if(player.hasPermission("mechanic.nuke")) {
		if(args.length == 0) {
			player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Nuke is launchning with a strength of " + McColors.GOLD + 500);
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 255));
			entity.getWorld().createExplosion(player.getLocation(), 500.4F, true);
		   } else {
			   player.sendMessage(Strings.NoParamsPlease);
		   }
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
		return false;
	}

}
