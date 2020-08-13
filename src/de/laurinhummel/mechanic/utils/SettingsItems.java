package de.laurinhummel.mechanic.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SettingsItems {
	
	public static ItemStack getMenuItem(ItemType type, ItemState state) {
		ItemStack itemStack = new ItemStack(Material.STONE, 1);
		ItemMeta itemMeta = itemStack.getItemMeta();
		ArrayList<String> itemLore = new ArrayList<>();
		if(type == ItemType.DMGALERT) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.ANVIL);
				itemMeta.setDisplayName("§cSchadensanzeige §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt den §eSchaden §7und den §eSchadenstyp §7im Chat an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §eMenu öffnen");
				itemLore.add("§7§o[Shift-Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.ANVIL);
				itemMeta.setDisplayName("§a§lSchadensanzeige §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt den §eSchaden §7und den §eSchadenstyp §7im Chat an");
				itemLore.add(" ");
				itemLore.add("§7§o[Klick] §eMenu öffnen");
				itemLore.add("§7§o[Shift-Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.DMGREMOVER) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.BUCKET);
				itemMeta.setDisplayName("§cSchadenslöscher §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Leert bei §eSchaden §7einen §eSlot");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §eMenu öffnen");
				itemLore.add("§7§o[Shift-Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.BUCKET);
				itemMeta.setDisplayName("§a§lSchadenslöscher §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Leert bei §eSchaden §7einen §eSlot");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §eMenu öffnen");
				itemLore.add("§7§o[Shift-Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.SETTINGS) {
			itemStack.setType(Material.REDSTONE_TORCH);
			itemMeta.setDisplayName("§e§lEinstellungen");
			itemLore.add(" ");
			itemLore.add("§7Stelle verschiedene §eMöglichkeiten §7ein");
			itemLore.add(" ");
		} else if(type == ItemType.DISABLED) {
			itemStack.setType(Material.BARRIER);
			itemMeta.setDisplayName("§cUndefiniert");
			itemLore.add(" ");
			itemLore.add("§cDies ist zur Zeit deaktiviert");
			itemLore.add(" ");
		} 
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		itemMeta.setLore(itemLore);
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
	
	public static ItemStack getDamageAlertItem(ItemType type, ItemState state) {
		ItemStack itemStack = new ItemStack(Material.STONE, 1);
		ItemMeta itemMeta = itemStack.getItemMeta();
		ArrayList<String> itemLore = new ArrayList<>();
		if(type == ItemType.POWER) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.GRAY_GLAZED_TERRACOTTA);
				itemMeta.setDisplayName("§cSchadensanzeige §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt den §eerlittenen Schaden §7im Chat an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.LIME_GLAZED_TERRACOTTA);
				itemMeta.setDisplayName("§a§lSchadensanzeige §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt den §eerlittenen Schaden §7im Chat an");
				itemLore.add(" ");
				itemLore.add("§7§o[Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.REASON) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.IRON_SWORD);
				itemMeta.setDisplayName("§cGrund §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt den §eGrund §8(§7und das §eEntity§8) §7beim §eSchaden §7an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.IRON_SWORD);
				itemMeta.setDisplayName("§a§lGrund §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt den §eGrund §8(§7und das §eEntity§8) §7beim §eSchaden §7an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.YOU) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.SKELETON_SKULL);
				itemMeta.setDisplayName("§cUserseitiges 'Du' §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt bei §eselbst erlittenem Schaden §7ein §e'Du', §7anstatt eines §eSpielernamens§7, an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.PLAYER_HEAD);
				itemMeta.setDisplayName("§a§lUserseitiges 'Du' §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt bei §eselbst erlittenem Schaden §7ein §e'Du', §7anstatt eines §eSpielernamens§7, an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.INFORMATION) {
			itemStack.setType(Material.BOOK);
			itemMeta.setDisplayName("§eInformationen §7/ §eÜbersicht");
			itemLore.add(" ");
			itemLore.add("§7- §7Durch das §eÄndern §7des §eGrunds");
			itemLore.add("    §7wird der §eGrund §7und das §eEntity §7im Chat §e(de)aktiviert");
			itemLore.add("§7- §7Durch das §eÄndern §7des §eUserseitigem 'Du'");
			itemLore.add("    §7wird der Spielername, für sich selbst, als 'Du' angezeigt");
			itemLore.add(" ");
		} else if(type == ItemType.DISABLED) {
			itemStack.setType(Material.BARRIER);
			itemMeta.setDisplayName("§cUndefiniert");
			itemLore.add(" ");
			itemLore.add("§cDies ist zur Zeit deaktiviert");
			itemLore.add(" ");
		} else if(type == ItemType.BACK) {
			itemStack.setType(Material.SPRUCE_DOOR);
			itemMeta.setDisplayName("§8➥ §6Zurück");
			itemLore.add(" ");
			itemLore.add("§eZurück ins letzte Menu");
			itemLore.add(" ");
		} 
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		itemMeta.setLore(itemLore);
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
	
	public static ItemStack getDamageRemoverItem(ItemType type, ItemState state) {
		ItemStack itemStack = new ItemStack(Material.STONE, 1);
		ItemMeta itemMeta = itemStack.getItemMeta();
		ArrayList<String> itemLore = new ArrayList<>();
		if(type == ItemType.POWER) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.GRAY_GLAZED_TERRACOTTA);
				itemMeta.setDisplayName("§cSchadenslöscher §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Leert bei §eSchaden §7einen §eSlot");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.LIME_GLAZED_TERRACOTTA);
				itemMeta.setDisplayName("§a§lSchadenslöscher §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Leert bei §eSchaden §7einen §eSlot");
				itemLore.add(" ");
				itemLore.add("§7§o[Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.GLOBAL_REMOVE) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.ARMOR_STAND);
				itemMeta.setDisplayName("§cGlobales Löschen §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§aAn: §7Löscht §edem Spieler §7ein §eItem§7, sobald er §eSchaden §7bekommt");
				itemLore.add("§cAus: §7Löscht §ejedem Spieler §7ein §eItem§7, sobald jemand §eSchaden §7bekommt");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.ARMOR_STAND);
				itemMeta.setDisplayName("§a§lGlobales Löschen §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§aAn: §7Löscht §ejedem Spieler §7ein §eItem§7, sobald jemand §eSchaden §7bekommt");
				itemLore.add("§cAus: §7Löscht §edem Spieler §7ein §eItem§7, sobald er §eSchaden §7bekommt");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.YOU) {
			if(state == ItemState.DISABLED) {
				itemStack.setType(Material.SKELETON_SKULL);
				itemMeta.setDisplayName("§cUserseitiges 'Du' §8[§4Inaktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt bei §eselbst gelöschtem Item §7ein §e'Du', §7anstatt eines §eSpielernamens§7, an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §aAktivieren");
				itemLore.add(" ");
			} else {
				itemStack.setType(Material.SKELETON_SKULL);
				itemMeta.setDisplayName("§a§lUserseitiges 'Du' §8[§2Aktiv§8]");
				itemLore.add(" ");
				itemLore.add("§7Zeigt bei §eselbst gelöschtem Item §7ein §e'Du', §7anstatt eines §eSpielernamens§7, an");
				itemLore.add(" ");				
				itemLore.add("§7§o[Klick] §cDeaktivieren");
				itemLore.add(" ");
				itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		} else if(type == ItemType.INFORMATION) {
			itemStack.setType(Material.BOOK);
			itemMeta.setDisplayName("§eInformationen §7/ §eÜbersicht");
			itemLore.add(" ");
			itemLore.add("§7- §7Durch das §eÄndern §7des §eglobalen Löschens");
			itemLore.add("    §7wird entweder nur der §eUser §7des §eSchadens");
			itemLore.add("    §7oder §ealle User §7bestraft");
			itemLore.add("§7- §7Durch das §eÄndern §7des §eUserseitigem 'Du'");
			itemLore.add("    §7wird der Spielername, für sich selbst, als 'Du' angezeigt");
			itemLore.add(" ");
		} else if(type == ItemType.DISABLED) {
			itemStack.setType(Material.BARRIER);
			itemMeta.setDisplayName("§cUndefiniert");
			itemLore.add(" ");
			itemLore.add("§cDies ist zur Zeit deaktiviert");
			itemLore.add(" ");
		} else if(type == ItemType.BACK) {
			itemStack.setType(Material.SPRUCE_DOOR);
			itemMeta.setDisplayName("§8➥ §6Zurück");
			itemLore.add(" ");
			itemLore.add("§eZurück ins letzte Menu");
			itemLore.add(" ");
		} 
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		itemMeta.setLore(itemLore);
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
	
	public enum ItemType {
		
		/* main */ 	
		
		DMGALERT,
		DMGREMOVER,
		SETTINGS,
		DISABLED,
		
		/* dmgalert */
		REASON,
		
		/* dmgremover */
		GLOBAL_REMOVE,
		
		/* settings */
		TIMER,
		BACKPACK,
		SCOREBOARD,
		GAMERULES,
		CHALLENGES,
		
		/* timer */
		TIME,
		RESUME,
		REVERSE,
		RESET,

		/* backpack */
		BACKPACK_LEVEL,
		
		/* scoreboard */
		HEARTS,
		TABLIST,
		BELOWNAME,

		/* gamerules */
		NATURALREGENERATION,
		SOUP,
		PVP,
		PLAYERHEALTH,
		DIFFICULTY,
		GLOBAL_HEALTH,
		GLOBAL_HEALTH_REG,
		GLOBAL_FOOD,
		GLOBAL_EXP,
		GLOBAL_INVENTORY,
		SPECIAL,
		DAMAGEMULTIPLIER,
		SLOT,
		
		/* challenges */
		WITHER,
		ENDER_DRAGON,
		FALLDAMAGE,
		DEATH,
		JUMP_DAMAGE,
		SNEAK_DAMAGE,
		JUMP_DEATH,
		SNEAK_DEATH,
		COLLECT,
		RANDOMITEM,
		UNKNOWN,
		LUCKYBLOCK,
		RANDOMIZER,
		RANDOMIZER_ULTRA,
		RANDOMIZER_EXTREME,
		COLLECTCOUNT,
		NOBLOCKPLACE,
		TELEPORT,
		MOVE_DAMAGE,
		MOVE_DEATH,
		LAVA,
		WATER,
		BORDER,
		HALLOWEEN,
		FORCE_BLOCK,
		MLG,
		INVISIBLE,
		HUNTER,
		THEFLOORISAIR,
		
		/* global */
		PAGE1,
		PAGE2,
		PAGE3,
		YOU,
		POWER,
		INFORMATION,
		BACK;
		
	}
	
	public enum ItemState {
		
		NONE,
		DISABLED,
		ENABLED;
		
	}
	
	public enum ItemLevel {
		
		NONE(0),
		ONE(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		TWENTY(20),
		THIRTY(30),
		FOURTY(40),
		FIVTY(50),
		SIXTY(60),
		ERROR(-1);
		
		int level;
		
		private ItemLevel(int level) {
			this.level = level;
		}
		
		public int getLevel() {
			return level;
		}
		
	}
	
}