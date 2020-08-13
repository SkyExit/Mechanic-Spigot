package de.laurinhummel.mechanic.listeners;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.laurinhummel.mechanic.main.Main;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.utils.SettingsModes;

public class DamageListeners implements Listener {
	
	public static HashMap<Player, Long> damage = new HashMap<>();
	FileConfiguration config = Main.getPlugin().getConfig();
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onDamage(EntityDamageEvent event) {	
		
		if(event.getEntityType() == EntityType.PLAYER) {		
			
			Player player = (Player) event.getEntity();
			if(SettingsModes.uuids.contains(event.getEntity().getUniqueId().toString()))
				return;
			if(player.hasPermission("mechanic.damageListener")) {
				if(damage.containsKey(player) && damage.get(player) <= (System.currentTimeMillis() + 10)) {
					damage.remove(player);
				} else {
					String reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.UNDEFINEABLE");
					if(event.getDamage() > 0) {

						if(event.getCause() == DamageCause.BLOCK_EXPLOSION) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.BLOCK_EXPLOSION");
						} else if(event.getCause() == DamageCause.CONTACT) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.CONTACT");
						} else if(event.getCause() == DamageCause.CRAMMING) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.CRAMMING");
						} else if(event.getCause() == DamageCause.DRAGON_BREATH) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.DRAGON_BREATH");
						} else if(event.getCause() == DamageCause.DROWNING) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.DROWNING");
						} else if(event.getCause() == DamageCause.ENTITY_ATTACK) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.ENTITY_ATTACK");
						} else if(event.getCause() == DamageCause.ENTITY_EXPLOSION) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.ENTITY_EXPLOSION");
						} else if(event.getCause() == DamageCause.ENTITY_SWEEP_ATTACK) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.ENTITY_SWEEP_ATTACK");
						} else if(event.getCause() == DamageCause.FALL) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.FALL");
						} else if(event.getCause() == DamageCause.FALLING_BLOCK) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.FALLING_BLOCK");
						} else if(event.getCause() == DamageCause.FIRE) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.FIRE");
						} else if(event.getCause() == DamageCause.FIRE_TICK) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.FIRE_TICK");
						} else if(event.getCause() == DamageCause.FLY_INTO_WALL) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.FLY_INTO_WALL");
						} else if(event.getCause() == DamageCause.HOT_FLOOR) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.HOT_FLOOR");
						} else if(event.getCause() == DamageCause.LAVA) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.LAVA");
						} else if(event.getCause() == DamageCause.LIGHTNING) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.LIGHTNING");
						} else if(event.getCause() == DamageCause.MAGIC) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.MAGIC");
						} else if(event.getCause() == DamageCause.MELTING) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.MELTING");
						} else if(event.getCause() == DamageCause.POISON) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.POISON");
						} else if(event.getCause() == DamageCause.PROJECTILE) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.PROJECTILE");
						} else if(event.getCause() == DamageCause.STARVATION) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.STARVATION");
						} else if(event.getCause() == DamageCause.SUFFOCATION) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.SUFFOCATION");
						} else if(event.getCause() == DamageCause.SUICIDE) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.SUICIDE");
						} else if(event.getCause() == DamageCause.THORNS) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.THORNS");
						} else if(event.getCause() == DamageCause.VOID) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.VOID");
						} else if(event.getCause() == DamageCause.WITHER) {
							reason = config.getString("Languages." + config.getString("Language") + ".DmgListener.WITHER");
						}

						double damage = round((event.getFinalDamage() / 2), 2);

						if(damage == 0.0) {
							return;
						} else {
							if(config.getString("Language").equals("de")) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(Names.MECHANIC2 + "§6" + player.getDisplayName() + " §7hat §6" + damage + " §eHerzen " + "§7" + "Durch " + reason + " §7verloren!");
								}
							} else if(config.getString("Language").equals("en")) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(Names.MECHANIC2 + "§6" + player.getDisplayName() + " §7lost §6" + damage + " §eHearts " + "§7" + "because of " + reason);
								}
							} else {
								player.sendMessage("test");
							}
						}
					}
				}
			}
		}	
	}
	
	long nextRegenerate = System.currentTimeMillis();
	double added = 0.0;
	ArrayList<Player> players = new ArrayList<>();
	
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	 
}