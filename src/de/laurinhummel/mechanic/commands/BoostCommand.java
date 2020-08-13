package de.laurinhummel.mechanic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BoostCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("mechanic.flyBoost.booster")) {
            player.setVelocity(player.getEyeLocation().getDirection().multiply(10));
        }
        return false;
    }

}