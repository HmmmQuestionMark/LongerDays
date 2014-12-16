package dk.muj.plugins.longerdays.cmd;

import org.bukkit.World;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.arg.ARInteger;
import com.massivecraft.massivecore.cmd.arg.ARWorld;

import dk.muj.plugins.longerdays.LongerDaysAPI;
import dk.muj.plugins.longerdays.entity.MConf;

public class CmdLongerDaysDebug extends MassiveCommand
{

	public CmdLongerDaysDebug()
	{
		super.addAliases("ldb");
		super.addRequiredArg("world");
		super.setErrorOnToManyArgs(false);
		
	}
	
	
	@Override
	public void perform()
	{
		World world = super.arg(0, ARWorld.get(), ((Player)sender).getWorld());
		if(world == null) return;
		int day = (int) (world.getFullTime()/24000);
		int daysInYear = MConf.get().worldTimeMultipliers.get(world.getName()).getYearLength();
		int dayInYear = day % daysInYear;
		int daysInSeason = daysInYear/4;
		
		sender.sendMessage("Time: "+ world.getTime());
		sender.sendMessage("IsDay: "+ LongerDaysAPI.isDay((int) world.getTime()));
		sender.sendMessage("Day: "+ day);
		sender.sendMessage("DaysInyear: "+ daysInYear);
		sender.sendMessage("DayInYear: "+ dayInYear);
		sender.sendMessage("DaysInSeason: "+ daysInSeason);
		sender.sendMessage("Season: "+ LongerDaysAPI.getSeason(world));
		
		Integer i = super.arg(1, ARInteger.get(), 0);
		if(i == null) return;
		
		world.setTime(world.getTime()+i);
		
	}
	
}
