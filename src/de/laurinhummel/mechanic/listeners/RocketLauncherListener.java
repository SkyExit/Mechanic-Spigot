package de.laurinhummel.mechanic.listeners;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.McColors;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class RocketLauncherListener implements Listener {
    @EventHandler
    public void shootFireball(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        //ItemStack
        ItemStack rocketL = new ItemStack(Material.BLAZE_ROD);
        ItemMeta rocketLMeta = rocketL.getItemMeta();
        rocketLMeta.setDisplayName(McColors.DARK_PURPLE + "Rocket Launcher");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(McColors.RED + "Shoot Rockets!");
        rocketLMeta.setLore(lore);
        rocketL.setItemMeta(rocketLMeta);

        if(player.getInventory().getItemInMainHand().equals(rocketL)) {
            Location loc = player.getLocation();
            Fireball fireball = (Fireball) Objects.requireNonNull(loc.getWorld()).spawnEntity(loc, EntityType.FIREBALL);
            fireball.setVelocity(loc.getDirection().multiply(0.5));
            fireball.setIsIncendiary(false);
            fireball.setYield(0F);
        }
    }
}
