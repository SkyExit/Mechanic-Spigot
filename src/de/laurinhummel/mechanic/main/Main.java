package de.laurinhummel.mechanic.main;

import java.util.ArrayList;
import java.util.logging.Logger;

import de.laurinhummel.mechanic.commands.*;
import de.laurinhummel.mechanic.listeners.*;
import de.laurinhummel.mechanic.shortcuts.McColors;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.laurinhummel.mechanic.GameModules.DashUnit;
import de.laurinhummel.mechanic.GameModules.GetModule;
import de.laurinhummel.mechanic.GameModules.JumpUnit;
import de.laurinhummel.mechanic.shortcuts.Colors;
import de.laurinhummel.mechanic.shortcuts.Names;
import de.laurinhummel.mechanic.utils.UpdateChecker;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		PluginManager pluginManager = Bukkit.getPluginManager();
		
		//Commands
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("sethome").setExecutor(new SetHomeCommand());
		getCommand("home").setExecutor(new HomeCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
		getCommand("warp").setExecutor(new WarpCommand());
		getCommand("date").setExecutor(new DateCommand());
		getCommand("flyspeed").setExecutor(new FlySpeedCommand());
		getCommand("walkspeed").setExecutor(new WalkSpeedCommand());
		getCommand("glow").setExecutor(new GlowCommand());
		getCommand("suicide").setExecutor(new SuicideCommand());
		getCommand("rainbowarmor").setExecutor(new RainbowArmorCommand());
		getCommand("wb").setExecutor(new WorkbenchCommand());
		getCommand("ec").setExecutor(new EnderchestCommand());
		getCommand("invsee").setExecutor(new InventorySeeCommand());
		getCommand("hat").setExecutor(new HatCommand());
		getCommand("nick").setExecutor(new NicknameCommand());
		getCommand("nuke").setExecutor(new NukeCommand());
		getCommand("godtool").setExecutor(new GodToolCommand());
		getCommand("position").setExecutor(new PositionCommand());
		getCommand("deathloc").setExecutor(new LatestDeathLocationCommand());
		getCommand("test").setExecutor(new TestCommand());
		getCommand("getmodule").setExecutor(new GetModule());
		getCommand("unstuck").setExecutor(new UnstuckCommand());
		getCommand("boost").setExecutor(new BoostCommand());
		getCommand("msg").setExecutor(new MSGCommand());
		getCommand("playerloc").setExecutor(new PlayerLocateCommand());
		
		//Events
		pluginManager.registerEvents(new JoinListener(), this);
		pluginManager.registerEvents(new QuitListener(), this);
		pluginManager.registerEvents(new PlayerDeathListener(), this);
		pluginManager.registerEvents(new PlayerDeathChest(), this);
		pluginManager.registerEvents(new DamageListeners(), this);
		pluginManager.registerEvents(new PlayerHealthTab(), this);
		pluginManager.registerEvents(new DashUnit(), this);
		pluginManager.registerEvents(new JumpUnit(), this);
		pluginManager.registerEvents(new FlightBooster(), this);
		pluginManager.registerEvents(new EnderBowListener(), this);

		//Recipes
		ItemStack enderBow = new ItemStack(Material.BOW);
		ItemMeta ebMeta = enderBow.getItemMeta();
		ebMeta.setDisplayName(McColors.DARK_PURPLE + "Ender Bow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(McColors.RED + "Shoot arrows and teleport!");
		ebMeta.setLore(lore);
		enderBow.setItemMeta(ebMeta);
		NamespacedKey ebKey = new NamespacedKey(Main.getPlugin(), "ender_bow");
		ShapedRecipe ebRecipe = new ShapedRecipe(ebKey, enderBow);
		ebRecipe.shape(" ES", "E S", " ES");
		ebRecipe.setIngredient('E', Material.ENDER_PEARL);
		ebRecipe.setIngredient('S', Material.STRING);
		Bukkit.addRecipe(ebRecipe);
		
		//Config
		FileConfiguration config = Main.getPlugin().getConfig();
		this.getConfig();
		config.addDefault("Language", "de");
		config.options().copyDefaults(true);
		saveConfig();
		

		
		//UpdateChecker
		Logger logger = this.getLogger();
        new UpdateChecker(this, 80564).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("This Plugin is up-tp-date!");
            } else {
                logger.info("There is a new update available.");
            }
        });
		
		//Console Log
		System.out.println(Names.MECHANIC1 + Colors.RED + "Loading Assets..." + Colors.RESET);
		System.out.println(Names.MECHANIC1 + Colors.RED + "Registrating Commands..." + Colors.RESET);
		System.out.println(Names.MECHANIC1 + Colors.RED + "Registrating Events..." + Colors.RESET);
		System.out.println(Names.MECHANIC1 + Colors.RED + "The Plugin is completly loaded!" + Colors.RESET);
		
		//RainbowArmor mainloop
		RainbowArmorCommand.mainLoop().runTaskTimer(this, 1, 1);
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
	public void onDisable() {
		System.out.println(Names.MECHANIC1 + Colors.RED + "Unloading Assets..." + Colors.RESET);
		System.out.println(Names.MECHANIC1 + Colors.RED + "Deactivating Commands..." + Colors.RESET);
		System.out.println(Names.MECHANIC1 + Colors.RED + "Deactivating Events..." + Colors.RESET);
		System.out.println(Names.MECHANIC1 + Colors.RED + "The Plugin is completly deactivated!" + Colors.RESET);
	}
}
