package net.whispwriting.lobby;

import net.whispwriting.lobby.commands.LobbyCommand;
import net.whispwriting.lobby.events.JoinEvent;
import net.whispwriting.lobby.files.LobbyLocationFile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {

    public LobbyLocationFile lobbyLocation = new LobbyLocationFile(this);

    @Override
    public void onEnable() {
        lobbyLocation.get().options().copyDefaults(true);
        lobbyLocation.save();
        this.getCommand("lobbyset").setExecutor(new LobbyCommand(this));

        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
