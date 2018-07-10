package fr.ismania.nootherbungeecord;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	private String bungeeIp;
	private String error_message;
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		bungeeIp = getConfig().getString("bungeecord.ip");
		error_message = getConfig().getString("bungeecord.not_autorized");
		
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		
		if(e.getRealAddress().getHostAddress().equals(bungeeIp)) {
			
			e.allow();
			
		} else {
			
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER, error_message.replace("&", "§"));
			
		}
		
	}
	
}
