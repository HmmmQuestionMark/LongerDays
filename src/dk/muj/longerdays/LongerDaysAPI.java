package dk.muj.longerdays;

import dk.muj.longerdays.entity.MConf;
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
		DayLengthSetting setting = MConf.get().worldTimeMultipliers.get(w.getName());
		if (isDay(time)) return setting.getDayLengthMultiplier();
		else return setting.getNightLengthMultiplier();
		
	}

	public static boolean isDay(long time)
	{
		return time < (DAY_LENGTH_TICKS/2);
	}

}
