package de.laurinhummel.mechanic.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.shortcuts.Strings;

public class GodToolCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("mechanic.godTool")) {
		ItemStack item = player.getItemInHand();
		String itemName = player.getItemInHand().toString().toLowerCase();
		ItemMeta itemMeta = item.getItemMeta();
		if(itemName.contains("sword")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
			itemMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10, true);
			itemMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 10, true);
			itemMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 10, true);
			itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
			itemMeta.addEnchant(Enchantment.KNOCKBACK, 3, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Aspect of the Dragons");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Sharpness X");
			lore.add(McColors.RED + "Smite X");
			lore.add(McColors.RED + "Bane of Arthropods X");
			lore.add(McColors.RED + "Knockback III");
			lore.add(McColors.RED + "Fire Aspect X");
			lore.add(McColors.RED + "Looting X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		} else if(itemName.contains("spade")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
			itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Super Shovel");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Fortune X");
			lore.add(McColors.RED + "Efficiency X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		} else if(itemName.contains("pickaxe")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
			itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Stonk Pickaxe");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Fortune X");
			lore.add(McColors.RED + "Efficiency X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		} else if(itemName.contains("axe")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
			itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Raider Axe");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Fortune X");
			lore.add(McColors.RED + "Efficiency X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		}  else if(itemName.contains("helmet")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
			itemMeta.addEnchant(Enchantment.OXYGEN, 10, true);
			itemMeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
			itemMeta.addEnchant(Enchantment.THORNS, 10, true);
			itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 10, true);
			itemMeta.addEnchant(Enchantment.FROST_WALKER, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Perfect Diamond Helmet Tier X");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Protection X");
			lore.add(McColors.RED + "Fire protection X");
			lore.add(McColors.RED + "Feather Falling X");
			lore.add(McColors.RED + "Blast Protection X");
			lore.add(McColors.RED + "Projectile Protetion X");
			lore.add(McColors.RED + "Respiration X");
			lore.add(McColors.RED + "Aqua Affinity X");
			lore.add(McColors.RED + "Thorns X");
			lore.add(McColors.RED + "Depth Strider X");
			lore.add(McColors.RED + "Frost Walker X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		} else if(itemName.contains("chestplate")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
			itemMeta.addEnchant(Enchantment.OXYGEN, 10, true);
			itemMeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
			itemMeta.addEnchant(Enchantment.THORNS, 10, true);
			itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 10, true);
			itemMeta.addEnchant(Enchantment.FROST_WALKER, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Perfect Diamond Chestplate Tier X");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Protection X");
			lore.add(McColors.RED + "Fire protection X");
			lore.add(McColors.RED + "Feather Falling X");
			lore.add(McColors.RED + "Blast Protection X");
			lore.add(McColors.RED + "Projectile Protetion X");
			lore.add(McColors.RED + "Respiration X");
			lore.add(McColors.RED + "Aqua Affinity X");
			lore.add(McColors.RED + "Thorns X");
			lore.add(McColors.RED + "Depth Strider X");
			lore.add(McColors.RED + "Frost Walker X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		} else if(itemName.contains("leggings")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
			itemMeta.addEnchant(Enchantment.OXYGEN, 10, true);
			itemMeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
			itemMeta.addEnchant(Enchantment.THORNS, 10, true);
			itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 10, true);
			itemMeta.addEnchant(Enchantment.FROST_WALKER, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Perfect Diamond Leggings Tier X");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Protection X");
			lore.add(McColors.RED + "Fire protection X");
			lore.add(McColors.RED + "Feather Falling X");
			lore.add(McColors.RED + "Blast Protection X");
			lore.add(McColors.RED + "Projectile Protetion X");
			lore.add(McColors.RED + "Respiration X");
			lore.add(McColors.RED + "Aqua Affinity X");
			lore.add(McColors.RED + "Thorns X");
			lore.add(McColors.RED + "Depth Strider X");
			lore.add(McColors.RED + "Frost Walker X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		} else if(itemName.contains("boots")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
			itemMeta.addEnchant(Enchantment.OXYGEN, 10, true);
			itemMeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
			itemMeta.addEnchant(Enchantment.THORNS, 10, true);
			itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 10, true);
			itemMeta.addEnchant(Enchantment.FROST_WALKER, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Perfect Diamond Boots Tier X");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Protection X");
			lore.add(McColors.RED + "Fire protection X");
			lore.add(McColors.RED + "Feather Falling X");
			lore.add(McColors.RED + "Blast Protection X");
			lore.add(McColors.RED + "Projectile Protetion X");
			lore.add(McColors.RED + "Respiration X");
			lore.add(McColors.RED + "Aqua Affinity X");
			lore.add(McColors.RED + "Thorns X");
			lore.add(McColors.RED + "Depth Strider X");
			lore.add(McColors.RED + "Frost Walker X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		
		} else if(itemName.contains("elytra")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
			itemMeta.addEnchant(Enchantment.OXYGEN, 10, true);
			itemMeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
			itemMeta.addEnchant(Enchantment.THORNS, 10, true);
			itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 10, true);
			itemMeta.addEnchant(Enchantment.FROST_WALKER, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Dragon Fly");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Protection X");
			lore.add(McColors.RED + "Fire protection X");
			lore.add(McColors.RED + "Feather Falling X");
			lore.add(McColors.RED + "Blast Protection X");
			lore.add(McColors.RED + "Projectile Protetion X");
			lore.add(McColors.RED + "Respiration X");
			lore.add(McColors.RED + "Aqua Affinity X");
			lore.add(McColors.RED + "Thorns X");
			lore.add(McColors.RED + "Depth Strider X");
			lore.add(McColors.RED + "Frost Walker X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		
		} else if(itemName.contains("rod")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.LUCK, 10, true);
			itemMeta.addEnchant(Enchantment.LURE, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Shredder");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Luck of the Sea X");
			lore.add(McColors.RED + "Lure X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		
		} else if(itemName.contains("bow")) {
			//Enchantments
			itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
			itemMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 5, true);
			itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
			itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 10, true);
			
			//ItemTitle
			itemMeta.setDisplayName(McColors.GOLD + "Rapid Runaan's bow");
			
			//Lores
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(McColors.RED + "Power X");
			lore.add(McColors.RED + "Punch V");
			lore.add(McColors.RED + "Flame X");
			lore.add(McColors.RED + "Infinity X");
			itemMeta.setLore(lore);
			
			//Flags
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			//Set meta
			item.setItemMeta(itemMeta);
			
		
		}
		else {
			player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "You're not holding a Tool!" + itemName);
		}
		
		} else {
			player.sendMessage(Strings.NotEnoughtPermissions);
		}
		
		return false;
	}

}
