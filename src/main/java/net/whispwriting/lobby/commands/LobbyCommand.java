package net.whispwriting.lobby.commands;

import net.whispwriting.lobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {

    private Lobby plugin;

    public LobbyCommand(Lobby pl){
        plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("Lobby.setLobby")) {
                    Location loc = player.getLocation();
                    plugin.lobbyLocation.get().set("lobby-location", loc);
                    plugin.lobbyLocation.save();
                    player.sendMessage(ChatColor.GREEN + "Lobby location set.");
                    return true;
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
                    return true;
                }
            }else{
                player.sendMessage(ChatColor.AQUA + "/lobby " + ChatColor.DARK_AQUA + "set");
                return true;
            }
        }else{
            sender.sendMessage(ChatColor.RED + "Only players may execute that command.");
            return true;
        }
    }
}
