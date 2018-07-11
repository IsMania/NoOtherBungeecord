package fr.ismania.nootherbungeecord;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.ismania.nootherbungeecord.commands.NoOtherBungeeCommand;

public class Main extends JavaPlugin implements Listener, CommandExecutor {

	private String bungeeIp;
	private String error_message;
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(this, this);
		
		getCommand("nootherbungeecord").setExecutor(new NoOtherBungeeCommand(this));
		
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		
		bungeeIp = getConfig().getString("bungeecord.ip");
		error_message = getConfig().getString("bungeecord.messages.not_autorized").replace("&", "§");
		
		if(e.getRealAddress().getHostAddress().equals(bungeeIp)) {
			
			e.allow();
			
			System.out.println("User : " + e.getPlayer().getName() + " connect with bungecord ip : " + e.getRealAddress().getHostAddress());
			
		} else {
		
			e.setKickMessage(error_message);
			e.setResult(PlayerLoginEvent.Result.KICK_FULL);
			
			System.out.println("User : " + e.getPlayer().getName() + " try to connect with bungecord ip : " + e.getRealAddress().getHostAddress());
			
		}
		
	}
	
}
