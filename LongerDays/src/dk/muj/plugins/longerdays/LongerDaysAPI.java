package dk.muj.plugins.longerdays;

import org.bukkit.World;

import dk.muj.plugins.longerdays.entity.MConf;

public class LongerDaysAPI
{
	
	private LongerDaysAPI(){}

	public static int getMultiplier(World w)
	{
		int time = (int) w.getTime();
		Season s = getSeason(w);
			switch(s)
			{
				case SPRING: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getSpringDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getSpringNightLength();
				case SUMMER: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getSummerDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getSummerNightLength();
				case FALL: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getFallDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getFallNightLength();
				case WINTER: return (isDay(time))  ?  MConf.get().worldTimeMultipliers.get(w.getName()).getWinterDayLength() :  MConf.get().worldTimeMultipliers.get(w.getName()).getWinterNightLength();
				default: return 1;
			}
		
	}
	
	public static int getMultiplierNight(World w)
	{
		Season s = getSeason(w);
			switch(s)
			{
				case SPRING: return MConf.get().worldTimeMultipliers.get(w.getName()).getSpringNightLength();
				case SUMMER: return MConf.get().worldTimeMultipliers.get(w.getName()).getSummerNightLength();
				case FALL: return MConf.get().worldTimeMultipliers.get(w.getName()).getFallNightLength();
				case WINTER: return MConf.get().worldTimeMultipliers.get(w.getName()).getWinterNightLength();
				default: return 1;
			}
		
	}
	
	public static int getMultiplierDay(World w)
	{
		Season s = getSeason(w);
			switch(s)
			{
				case SPRING: return MConf.get().worldTimeMultipliers.get(w.getName()).getSpringDayLength();
				case SUMMER: return MConf.get().worldTimeMultipliers.get(w.getName()).getSummerDayLength();
				case FALL: return MConf.get().worldTimeMultipliers.get(w.getName()).getFallDayLength();
				case WINTER: return MConf.get().worldTimeMultipliers.get(w.getName()).getWinterDayLength();
				default: return 1;
			}
		
	}
	
	public static Season getSeason(World w)
	{
		int day = (int) (w.getFullTime()/24000);
		int daysInYear = MConf.get().worldTimeMultipliers.get(w.getName()).getYearLength();
		int dayInYear = day % daysInYear;
		int daysInSeason = daysInYear/4;
		
		if(dayInYear < daysInSeason)
			return Season.SPRING;
		else if(dayInYear < daysInSeason*2)
			return Season.SUMMER;
		else if(dayInYear < daysInSeason*3)
			return Season.FALL;
		else
			return Season.WINTER;
		
	}
	
	public static boolean isDay(int time)
	{
		if(time < 12000)
			return true;
		return false;
	}
}
