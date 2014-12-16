package dk.muj.plugins.longerdays.engine;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import com.massivecraft.massivecore.EngineAbstract;

import dk.muj.plugins.longerdays.LongerDays;
import dk.muj.plugins.longerdays.LongerDaysAPI;
import dk.muj.plugins.longerdays.entity.MConf;

public class TimeEngine extends EngineAbstract
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static TimeEngine i = new TimeEngine();
	public static TimeEngine get() { return i; }
	public TimeEngine() {}
	
	// -------------------------------------------- //
	// CONSTANTS
	// -------------------------------------------- //
	
	// The amount of moonphases minus one.
	private final static int moonphases = 7;
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public Plugin getPlugin()
	{
		return LongerDays.get();
	}
	
	@Override
	public Long getPeriod()
	{
		return 1l;
	}
	
	@Override
	public Long getDelay()
	{
		return 1l;
	}
	
	// -------------------------------------------- //
	// REPEATING TASK
	// -------------------------------------------- //
	
	@Override
	public void run() 
	{	//Loop through the worlds
		for (World w : Bukkit.getServer().getWorlds())
			this.WorldChangeTime(w);
		
		//MConf.get().counter += MConf.get().schedulerTime;
	}
	
	// -------------------------------------------- //
	// METHODS
	// -------------------------------------------- //
	
	private void WorldChangeTime(World w)
	{
		String name = w.getName();
		
		//Not all worlds needs to get time changed.
		if(!MConf.get().worldTimeMultipliers.containsKey(name))
		    return;
		
		//Here the counter is used.
		//If the multiplier is 3, the time would NOT be set back
		//one out of three times. THus making the day three times longer
		if(w.getFullTime() % LongerDaysAPI.getMultiplier(w) == 0)
			return;
		
		//Here we actually change the time
		w.setTime( w.getTime() - MConf.get().schedulerTime);
		
		//To keep the moonpahse in sync, we have to change the time a few times.
		//We can't change it ny a whole day (24000 ticks). Because then the moonphase is not changed.
		for(int i = 0; i < moonphases; i++)
			w.setTime(w.getTime() - 1);
		
		//Because the time was changed slightly in the above code, keeping track of the moonphase.
		//We have to change it back
		w.setTime(w.getTime() + moonphases);
	}
}