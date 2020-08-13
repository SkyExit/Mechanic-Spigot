package de.laurinhummel.mechanic.GameModules;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;

public class JumpUnit implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onPlayerJump(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
			ItemStack jumpUnit = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta jumpUnitMeta = jumpUnit.getItemMeta();
			jumpUnitMeta.setDisplayName(McColors.AQUA + "Jump Unit");
			jumpUnitMeta.setUnbreakable(true);
			jumpUnit.setItemMeta(jumpUnitMeta);
			
	        if(player.getItemInHand().equals(jumpUnit)) {
	        	player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300, 5));
	        	player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 5));
	        	player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 5));
				player.sendMessage(Names.MECHANIC2 + McColors.AQUA + "JUMPING");
				event.setCancelled(true);
				player.getInventory().removeItem(jumpUnit);
				player.updateInventory();
	        }
	}
}