package de.laurinhummel.mechanic.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FlightBooster implements Listener {
    @EventHandler
    public void onFlight(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("mechanic.flyBoost")) {
            if(!player.isOnGround() && player.getFallDistance() >= 3) {
                player.setGliding(true);

                ItemStack diamondBlock = new ItemStack(Material.DIAMOND_BLOCK);
                ItemStack emeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
                ItemStack goldBlock = new ItemStack(Material.GOLD_BLOCK);
                ItemStack ironBlock = new ItemStack(Material.IRON_BLOCK);
                ItemStack redStoneBlock = new ItemStack(Material.REDSTONE_BLOCK);
                ItemStack coalBlock = new ItemStack(Material.COAL_BLOCK);

                if(player.hasPermission("mechanic.flyBoost.booster")) {
                    if(player.getInventory().getItemInMainHand().isSimilar(diamondBlock)) {
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(15));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 7));
                    } else if(player.getInventory().getItemInMainHand().isSimilar(emeraldBlock)) {
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(10));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 6));
                    } else if(player.getInventory().getItemInMainHand().isSimilar(goldBlock)) {
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(8.4));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 5));
                    } else if(player.getInventory().getItemInMainHand().isSimilar(ironBlock)) {
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 4));
                    } else if(player.getInventory().getItemInMainHand().isSimilar(redStoneBlock)) {
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(3.6));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 3));
                    } else if(player.getInventory().getItemInMainHand().isSimilar(coalBlock)) {
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(2.4));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 2));
                    } else {
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(1.2));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 1));
                    }
                } else {
                    player.setVelocity(player.getEyeLocation().getDirection().multiply(1.2));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 1));
                }


                Location location = player.getLocation();

                player.spawnParticle(Particle.CLOUD, location, 1);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 255));
            }
        }
    }
}