package dk.muj.plugins.longerdays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import dk.muj.plugins.longerdays.entity.MConf;

public class Timer extends BukkitRunnable
{

	@Override
	public void run() {
		for(World w : Bukkit.getServer().getWorlds()){
			String name = w.getName();
			if(!MConf.get().worldTimeMultipliers.containsKey(name))
			    return;
			int multiplier = MConf.get().worldTimeMultipliers.get(name);
			int timeChange = LongerDays.schedulerTime - LongerDays.schedulerTime/multiplier;
			long time = w.getTime();
			w.setTime(time - timeChange);
			w.setTime(w.getTime() + 23999);
			w.setTime(w.getTime() + 23999);
			w.setTime(w.getTime() + 23999);
			w.setTime(w.getTime() + 23999);
			w.setTime(w.getTime() + 23999);
			w.setTime(w.getTime() + 23999);
			w.setTime(w.getTime() + 23999);
			w.setTime(w.getTime() + 7);
			}
	}

}
