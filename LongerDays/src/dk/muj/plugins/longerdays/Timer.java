package dk.muj.plugins.longerdays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import dk.muj.plugins.longerdays.entity.MConf;

public class Timer extends BukkitRunnable
{

		static int counter;
	@Override
	public void run() {
		counter++;
		for(World w : Bukkit.getServer().getWorlds()){
			String name = w.getName();
			if(!MConf.get().worldTimeMultipliers.containsKey(name))
			    return;
			int multiplier = MConf.get().worldTimeMultipliers.get(name);
			
			if(counter % multiplier == 0)
				return;
			w.setTime( w.getTime() - LongerDays.schedulerTime);
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
