package de.laurinhummel.mechanic.commands;

import de.laurinhummel.mechanic.shortcuts.McColors;
import de.laurinhummel.mechanic.shortcuts.Strings;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String playerName = player.getDisplayName();
        if(player.hasPermission("mechanic.msg")) {
            if(args.length >= 2) {
                Player target = (Player) Bukkit.getPlayer(args[0]);
                if(target != null) {

                    String msg = StringUtils.join(args, ' ', 1, args.length);

                    TextComponent message = new TextComponent(McColors.AQUA + msg);
                    message.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/msg " + playerName + " ") );
                    message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( McColors.AQUA + "Answer to " + McColors.GOLD + playerName ).create() ) );
                    player.spigot().sendMessage(message);
                } else {
                    player.sendMessage(Strings.missingPlayer);
                }
            } else {
                player.sendMessage("please use at least 2 params!");
            }
        } else {
            player.sendMessage(Strings.NotEnoughtPermissions);
        }
        return false;
    }
}
