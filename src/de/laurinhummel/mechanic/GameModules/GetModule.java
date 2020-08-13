package de.laurinhummel.mechanic.GameModules;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.laurinhummel.mechanic.shortcuts.McColors;

public class GetModule implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(sender instanceof Player) {
			World world = player.getWorld();
			if(player.hasPermission("mechanic.getModule")) {
					if(args[0].equals("dash")) {
						ItemStack dashUnit = new ItemStack(Material.CARROT_ON_A_STICK);
						ItemMeta dashUnitMeta = dashUnit.getItemMeta();
						dashUnitMeta.setDisplayName(McColors.AQUA + "Dash Unit");
						dashUnitMeta.setUnbreakable(true);
						dashUnit.setItemMeta(dashUnitMeta);
						
						world.dropItem(player.getLocation(), dashUnit);
					} else if(args[0].equals("jump")) {
						ItemStack jumpUnit = new ItemStack(Material.LEATHER_BOOTS);
						ItemMeta jumpUnitMeta = jumpUnit.getItemMeta();
						jumpUnitMeta.setDisplayName(McColors.AQUA + "Jump Unit");
						jumpUnitMeta.setUnbreakable(true);
						jumpUnit.setItemMeta(jumpUnitMeta);
						
						world.dropItem(player.getLocation(), jumpUnit);
					}
			}
		}
		return false;
	}

}
