package dk.muj.plugins.longerdays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable
{

	@Override
	public void run() {
		for(World w : Bukkit.getServer().getWorlds()){
			if(!LongerDays.worlds.contains(w.getName()))
			    return;
			long tid = w.getTime();
			w.setTime(tid - LongerDays.timeChange);
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
