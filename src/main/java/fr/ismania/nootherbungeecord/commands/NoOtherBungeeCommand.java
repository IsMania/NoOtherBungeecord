package fr.ismania.nootherbungeecord.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.ismania.nootherbungeecord.Main;

public class NoOtherBungeeCommand implements CommandExecutor {
	
	private Main main;
	
	public NoOtherBungeeCommand(Main main) {
		this.main = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 1) {
			
			main.reloadConfig();
			
			sender.sendMessage("§aConfig of NoOtherBungeecord reload !");
			
		} else {
			sender.sendMessage("§c/nootherbungeecord reload");
		}
		
		return true;
		
	}

}
