package dk.muj.plugins.longerdays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import dk.muj.plugins.longerdays.entity.MConf;

public class Timer extends BukkitRunnable
{
		
	// The amount of moonphases minus one.
	private final static int moonphases = 7;
	
	private int counter = 0;
	
		@Override
	public void run() 
	{
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
		int multiplier = this.getMultiplier(w);
		
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
	
	private int getMultiplier(World w)
	{
		int time = (int) w.getTime();
		Season s = this.getSeason(w);
			switch(s)
			{
				case SPRING: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getSpringDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getSpringNightLength();
				case SUMMER: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getSummerDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getSummerNightLength();
				case FALL: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getFallDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getFallNightLength();
				case WINTER: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getWinterDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getWinterNightLength();
				default: return 1;
			}
		
	}
	
	private Season getSeason(World w)
	{
		int days = counter/24000;
		int daysInYear = MConf.get().worldTimeMultipliers.get(w.getName()).getYearLength();
		int daysInSeason = daysInYear/4;
		int dayInYear = days % daysInYear;
		
		if(dayInYear < daysInSeason)
			return Season.SPRING;
		else if(dayInYear < daysInSeason*2)
			return Season.SUMMER;
		else if(dayInYear < daysInSeason*3)
			return Season.FALL;
		else
			return Season.WINTER;
		
	}
	
	private boolean isDay(int time)
	{
		if(time < 12000)
			return true;
		return false;
	}

}
