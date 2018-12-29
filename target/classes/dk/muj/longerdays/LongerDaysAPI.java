package com.massivecraft.longerdays;

import com.massivecraft.longerdays.entity.MConf;
import org.bukkit.World;

public class LongerDaysAPI
{
	// -------------------------------------------- //
	// CONST
	// -------------------------------------------- //

	public static long DAY_LENGTH_TICKS = 24000;

	// -------------------------------------------- //
	// FUNCTIONALITY
	// -------------------------------------------- //

	public static int getMultiplier(World w)
	{
		long time = w.getTime();
		if (isDay(time)) return getMultiplierDay(w);
		else return getMultiplierNight(w);
		
	}
	
	public static int getMultiplierNight(World w)
	{
		Season s = getSeason(w);
		switch(s)
		{
			case SPRING: return MConf.get().worldTimeMultipliers.get(w.getName()).getSpringNightLengthMultiplier();
			case SUMMER: return MConf.get().worldTimeMultipliers.get(w.getName()).getSummerNightLengthMultiplier();
			case FALL: return MConf.get().worldTimeMultipliers.get(w.getName()).getFallNightLengthMultiplier();
			case WINTER: return MConf.get().worldTimeMultipliers.get(w.getName()).getWinterNightLengthMultiplier();
			default: throw new RuntimeException();
		}
		
	}
	
	public static int getMultiplierDay(World w)
	{
		Season s = getSeason(w);
		switch(s)
		{
			case SPRING: return MConf.get().worldTimeMultipliers.get(w.getName()).getSpringDayLengthMultiplier();
			case SUMMER: return MConf.get().worldTimeMultipliers.get(w.getName()).getSummerDayLengthMultiplier();
			case FALL: return MConf.get().worldTimeMultipliers.get(w.getName()).getFallDayLengthMultiplier();
			case WINTER: return MConf.get().worldTimeMultipliers.get(w.getName()).getWinterDayLengthMultiplier();
			default: throw new RuntimeException();
		}
		
	}
	
	public static Season getSeason(World w)
	{
		long day = w.getFullTime()/DAY_LENGTH_TICKS;
		long daysInYear = MConf.get().worldTimeMultipliers.get(w.getName()).getYearLength();
		long dayInYear = day % daysInYear;
		long daysInSeason = daysInYear/4;
		
		if(dayInYear < daysInSeason)
			return Season.SPRING;
		else if(dayInYear < daysInSeason*2)
			return Season.SUMMER;
		else if(dayInYear < daysInSeason*3)
			return Season.FALL;
		else
			return Season.WINTER;
		
	}
	
	public static boolean isDay(long time)
	{
		return time < (DAY_LENGTH_TICKS/2);
	}

}
