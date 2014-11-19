package dk.muj.plugins.longerdays;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public class LongerDays extends JavaPlugin
{

	static int timeChange;
	static List<String> worlds;
	private static int run = 100;
	
	Logger log = Bukkit.getLogger();
	
	@Override
	public void onEnable()
	{
	    	//Loading the config if not loaded already.
		this.saveDefaultConfig();
		
		//Getting values from the config
		run = this.getConfig().getInt("Interval");
		worlds = this.getConfig().getStringList("worlds");
		int multiplier = getConfig().getInt("LengthMultiplier");
		
		//Beginning the scheduler
		timeChange = run - run/multiplier;
		Timer timer = new Timer();
		timer.runTaskTimer( this, 0 , run);
		
		
		log.info("[LongerDays] LongerDays is enabled");
	}
	@Override
	public void onDisable() 
	{
		log.info("[LongerDays] LongerDays is disabled");
	}
	
	
}
