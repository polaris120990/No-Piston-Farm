package me.polaris120990.NoPiston;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoPiston extends JavaPlugin
{
	public final Logger logger = Logger.getLogger("Minecraft");
	NoPistonBlock listener = new NoPistonBlock();
	public void onEnable()
	{
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_PISTON_EXTEND, listener, Event.Priority.Highest, this);
	    PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + "] v" + pdfFile.getVersion() + " has been enabled.");
		
	}
	
	public void onDisable()
	{
	    PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + "] has been disabled.");
	}
}
