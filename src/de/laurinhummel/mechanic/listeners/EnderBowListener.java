package de.laurinhummel.mechanic.listeners;

import de.laurinhummel.mechanic.shortcuts.McColors;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EnderBowListener implements Listener {
    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        if(event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            //get player main hand for bow
            if(arrow.getShooter() instanceof Player) {
                if(event.getHitBlock() != null) {
                    Block target = event.getHitBlock();
                    Player shooter = (Player) arrow.getShooter();

                    if(shooter.hasPermission("mechanic.enderbow")) {

                        //ItemStack
                        ItemStack enderBow = new ItemStack(Material.BOW);
                        ItemMeta ebMeta = enderBow.getItemMeta();
                        ebMeta.setDisplayName(McColors.DARK_PURPLE + "Ender Bow");
                        ArrayList<String> lore = new ArrayList<String>();
                        lore.add(McColors.RED + "Shoot arrows and teleport!");
                        ebMeta.setLore(lore);
                        enderBow.setItemMeta(ebMeta);

                        if(shooter.getInventory().getItemInMainHand().equals(enderBow)) {
                            Location loc = target.getLocation();
                            double x = loc.getBlockX();
                            double y = (loc.getBlockY() + 1);
                            double z = loc.getBlockZ();
                            shooter.teleport(new Location(shooter.getWorld(), x, y, z));
                            shooter.getWorld().playSound(shooter.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10, 1);
                        }
                    }
                }
            }
        }
    }
}
