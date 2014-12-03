package dk.muj.plugins.longerdays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import dk.muj.plugins.longerdays.entity.MConf;

public class Timer extends BukkitRunnable
{
		
		
		// This is used every time the time is changed.
		// This was we can check whether or not it should be set back
		private int counter = 0;
		
		// The amount of moonphases minus one.
		private final static int moonphases = 7;
	
		@Override
	public void run() 
	{
		//We add one to the counter
		counter++;
		
		//Loop through the worlds
		for (World w : Bukkit.getServer().getWorlds())
		{
			this.WorldChangeTime(w);
		}
	}
	
	private void WorldChangeTime(World w)
	{
		String name = w.getName();
		
		//Not all worlds needs to get time changed.
		if(!MConf.get().worldTimeMultipliers.containsKey(name))
		    return;
		
		//Get how much it should be set back.
		int multiplier = MConf.get().worldTimeMultipliers.get(name);
		
		//Here the counter is used.
		//If the multiplier is 3, the time would NOT be set back
		//one out of three times. THus making the day three times longer
		if(counter % multiplier == 0)
			return;
		//Here we actually change the time
		w.setTime( w.getTime() - LongerDays.schedulerTime);
		//To keep the moonpahse in sync, we have to change the time a few times.
		//We can't change it ny a whole day (24000 ticks). Because then the moonphase is not changed.
		for(int i = 0; i < moonphases; i++)
			w.setTime(w.getTime() - 1);
		
		//Because the time was changed slightly in the above code, keeping track of the moonphase.
		//We have to change it back
		w.setTime(w.getTime() + moonphases);
	}

}
