package dk.muj.plugins.longerdays.cmd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.arg.ARWorld;
import com.massivecraft.massivecore.mixin.Mixin;
import com.massivecraft.massivecore.util.Txt;

import dk.muj.plugins.longerdays.LongerDaysAPI;
import dk.muj.plugins.longerdays.entity.MConf;

public class CmdLongerDaysDebug extends MassiveCommand
{

	public CmdLongerDaysDebug()
	{
		super.addAliases("debug");
		super.addRequiredArg("world");
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
		
		List<String> msgLines = new ArrayList<String>();
		msgLines.add(Txt.titleize("Debug info "+ Mixin.getWorldDisplayName(world.getName())));
		
		msgLines.add(Txt.parse("<pink>Time: <i>"+ world.getTime()));
		msgLines.add(Txt.parse("<pink>IsDay: <i>"+ LongerDaysAPI.isDay((int) world.getTime())));
		msgLines.add(Txt.parse("<pink>Day: <i>"+ day));
		msgLines.add(Txt.parse("<pink>DaysInyear: <i>"+ daysInYear));
		msgLines.add(Txt.parse("<pink>DayInYear: <i>"+ dayInYear));
		msgLines.add(Txt.parse("<pink>DaysInSeason: <i>"+ daysInSeason));
		msgLines.add(Txt.parse("<pink>Season: <i>"+ LongerDaysAPI.getSeason(world)));
		
		sender.sendMessage(msgLines.toArray(new String[msgLines.size()]));
	}
	
}
