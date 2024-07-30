package blaze534;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		System.out.println("Fly plugin fatto da blaze534.py su discord");
		getCommand("fly").setExecutor(new Fly());
	}
	
	public void onDisable() {
		System.out.println("Arrivederci!");
	}
	
	public static Main getInstance() {
		return plugin;
	}
	


}
