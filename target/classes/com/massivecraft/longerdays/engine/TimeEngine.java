package com.massivecraft.longerdays.engine;

import com.massivecraft.longerdays.entity.MConf;
import com.massivecraft.massivecore.Engine;
import com.massivecraft.longerdays.LongerDaysAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;

public class TimeEngine extends Engine
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
	// FIELDS
	// -------------------------------------------- //

	private int counter = 0;

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	@Override
	public Long getPeriod()
	{
		return 1L;
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
	{
		counter++;
		for (World w : Bukkit.getServer().getWorlds())
		{
			this.worldChangeTime(w);
		}
		
		//MConf.get().counter += MConf.get().schedulerTime;
	}
	
	// -------------------------------------------- //
	// METHODS
	// -------------------------------------------- //
	
	private void worldChangeTime(World w)
	{
		String name = w.getName();
		
		//Not all worlds needs to get time changed.
		if(!MConf.get().worldTimeMultipliers.containsKey(name)) return;

		if (w.getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE) == Boolean.FALSE) return;
		
		// Here the counter is used.
		// If the multiplier is 3, the time would NOT be set back
		// one out of three times. THus making the day three times longer
		if(counter % LongerDaysAPI.getMultiplier(w) == 0) return;
		
		//Here we actually change the time
		w.setTime(w.getTime() - 1);
		
		//To keep the moonpahse in sync, we have to change the time a few times.
		//We can't change it a whole day (24000 ticks). Because then the moonphase is not changed.
		for(int i = 0; i < moonphases; i++)
			w.setTime(w.getTime() - 1);
		
		// Because the time was changed slightly in the above code, keeping track of the moonphase.
		// We have to change it back
		w.setTime(w.getTime() + moonphases);
	}
}