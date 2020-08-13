package de.laurinhummel.mechanic.commands;

import java.awt.Color;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class RainbowArmorCommand implements CommandExecutor {
	
	private static HashMap<UUID, Float> hue;
	
	public RainbowArmorCommand() {
		hue = new HashMap<>();
	}

	
	public static BukkitRunnable mainLoop() {
		return new BukkitRunnable() {
			@Override
			public void run() {
				hue.forEach((uuid, h) -> {
					Player player = Bukkit.getPlayer(uuid);
					if (player != null && player.isOnline()) {
						h = handleColor(h, 0.005f);
						setArmor(player, h, 0.02f);
						hue.put(uuid, h);
					}
				});
			}
		};
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("rainbowarmor")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("mechanic.rainbowArmor")) {
				if (hue.containsKey(player.getUniqueId())) {
					hue.remove(player.getUniqueId());
					player.getInventory().setArmorContents(null);
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Rainbowarmor has been " + McColors.GOLD + "Deactivated");
				} else {
					hue.put(player.getUniqueId(), 0.0f);
					player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "Rainbowarmor has been " + McColors.GOLD + "Activated");
				}
		      } else {
		    	   player.sendMessage(Strings.NotEnoughtPermissions);
		      }
			}
		}
		return true;
	}

	
	private static void setArmor(Player player, float hue, float gradientSpeed) {
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

		org.bukkit.Color helmetColor = org.bukkit.Color.fromBGR(getRGB(hue).getRed(), getRGB(hue).getGreen(),
				getRGB(hue).getBlue());
		hue = handleColor(hue, gradientSpeed);
		org.bukkit.Color chestplateColor = org.bukkit.Color.fromBGR(getRGB(hue).getRed(), getRGB(hue).getGreen(),
				getRGB(hue).getBlue());
		hue = handleColor(hue, gradientSpeed);
		org.bukkit.Color leggingsColor = org.bukkit.Color.fromBGR(getRGB(hue).getRed(), getRGB(hue).getGreen(),
				getRGB(hue).getBlue());
		hue = handleColor(hue, gradientSpeed);
		org.bukkit.Color bootsColor = org.bukkit.Color.fromBGR(getRGB(hue).getRed(), getRGB(hue).getGreen(),
				getRGB(hue).getBlue());

		LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetMeta.setColor(helmetColor);
		helmet.setItemMeta(helmetMeta);

		LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplateMeta.setColor(chestplateColor);
		chestplate.setItemMeta(chestplateMeta);

		LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsMeta.setColor(leggingsColor);
		leggings.setItemMeta(leggingsMeta);

		LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsMeta.setColor(bootsColor);
		boots.setItemMeta(bootsMeta);

		player.getInventory().setHelmet(helmet);
		player.getInventory().setChestplate(chestplate);
		player.getInventory().setLeggings(leggings);
		player.getInventory().setBoots(boots);

	}
	
	private static float handleColor(float hue, float speed) {
		hue += speed;
		if (hue > 1.0f)
			hue = 0.0f;
		return hue;
	}

	private static Color getRGB(float hue) {
		return Color.getHSBColor(hue, 1f, 1f);
	}
}
