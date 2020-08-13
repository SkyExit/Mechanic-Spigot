package de.laurinhummel.mechanic.commands;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Names;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerLocateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(sender != null) {
            if(player.hasPermission("mechanic.playerLocate")) {
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        double x = target.getLocation().getX();
                        double y = target.getLocation().getY();
                        double z = target.getLocation().getZ();
                        String world = target.getWorld().toString();

                        String targetName = target.getDisplayName();
                        String playerName = player.getDisplayName();

                        player.sendMessage(Names.MECHANIC2 + McColors.GOLD + targetName + ": " + McColors.AQUA + "X: " + McColors.GOLD + x + McColors.AQUA + " Y: " + McColors.GOLD + y + McColors.AQUA + " Z: " + McColors.GOLD + z + McColors.AQUA + " in World: " + McColors.GOLD + world);
                        target.sendMessage(Names.MECHANIC2 + McColors.GOLD + playerName + McColors.AQUA + "Asked for your Position!");
                    }
                }
            }
        }
        return false;
    }
}
