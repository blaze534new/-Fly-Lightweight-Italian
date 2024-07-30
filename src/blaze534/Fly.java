package blaze534;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof ConsoleCommandSender || sender instanceof Player) {
			
			if (cmd.getName().equalsIgnoreCase("fly")) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					if(args.length==0) {
						if(sender.hasPermission("fly.use")){
							
							if (p.getAllowFlight()) {
								p.setAllowFlight(false);
								sender.sendMessage("§4Fly tolta");
							}else {
								p.setAllowFlight(true);
								sender.sendMessage("§2Fly messa");
							}
							return true;
						}else {
							sender.sendMessage("Non hai il permesso per eseguire questo comando!");
							return true;
						}
					}else if(args.length==2) {
						if(sender.hasPermission("fly.admin")) {
							Player target = Bukkit.getServer().getPlayerExact(args[1]);
							if(target != null) {
								if(args[0].equalsIgnoreCase("on")) {
									
									if (target.getAllowFlight()) {
										sender.sendMessage("§4Il player ha già la fly");
									}else {
										target.setAllowFlight(true);
										sender.sendMessage("§2fly messa a"+ target);
									}
									
									
									
								}else if(args[0].equalsIgnoreCase("off")) {
									if (target.getAllowFlight()) {
										target.setAllowFlight(false);
										sender.sendMessage("§4Fly tolta a"+ target);
									}else {
										sender.sendMessage("§4Il player non ha la fly attivata");
									}
									
									
									
								}else {
									sender.sendMessage("§4Argomento sconosciuto usa on o off!");
								}
							}else{
								sender.sendMessage("§4Il player non è online!");
							}
						}else {
							sender.sendMessage("§4Non hai il permesso per modificare la fly altrui usa semplicemente /fly senza argomenti");
						}
						
					}else if(args.length==1) {
						if(sender.hasPermission("fly.admin")) {
							Player target1 = Bukkit.getServer().getPlayerExact(args[1]);
							if(target1 != null) {
								if (target1.getAllowFlight()) {
									target1.setAllowFlight(false);
									sender.sendMessage("§4Fly tolta a"+ target1);
								}else {
									target1.setAllowFlight(true);
									sender.sendMessage("§2Fly messa a"+ target1);
								}
							
							
							
							}else {
								sender.sendMessage("§4Il player non è online!");
								return true;
							}
						}
						
						
					}else {
						sender.sendMessage("§4Utilizzo di arg sbagliato es:/fly on blazetiktok");
						return true;
					}
				}else {
					System.out.println("Questo comando può essere eseguito solo dai giocatori!");
					return true;
				}
			}
		
		}
		
		
		
		return false;
	}

}
