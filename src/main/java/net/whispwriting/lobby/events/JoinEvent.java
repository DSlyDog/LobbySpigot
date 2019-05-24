package net.whispwriting.lobby.events;

import net.whispwriting.lobby.Lobby;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private Lobby plugin;

    public JoinEvent(Lobby pl){
        plugin = pl;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Location loc = (Location) plugin.lobbyLocation.get().get("lobby-location");
        loc.setPitch(event.getPlayer().getLocation().getPitch());
        loc.setYaw(event.getPlayer().getLocation().getYaw());
        event.getPlayer().teleport(loc);
    }

}
