package dk.muj.plugins.longerdays.cmd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.arg.ARWorld;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.mixin.Mixin;
import com.massivecraft.massivecore.util.Txt;

import dk.muj.plugins.longerdays.DayLengthSetting;
import dk.muj.plugins.longerdays.LongerDaysAPI;
import dk.muj.plugins.longerdays.Perm;
import dk.muj.plugins.longerdays.entity.MConf;

public class CmdLongerDaysInfo extends MassiveCommand
{

	public CmdLongerDaysInfo()
	{
		super.addAliases("info");
		super.addRequiredArg("world");
		super.addRequirements(ReqHasPerm.get(Perm.INFO.node));
	}
	
	
	@Override
	public void perform()
	{
		World world = super.arg(0, ARWorld.get(), ((Player)sender).getWorld());
		if(world == null) return;
		int day = (int) (world.getFullTime()/24000);
		DayLengthSetting setting = MConf.get().worldTimeMultipliers.get(world.getName());
		if(setting == null)
		{
			sender.sendMessage(Txt.parse("<b>That world does not have specific settings"));
			return;
		}
		int daysInYear = setting.getYearLength();
		int dayInYear = day % daysInYear;
		
		List<String> msgLines = new ArrayList<String>();
		msgLines.add(Txt.titleize("Time info "+Mixin.getWorldDisplayName(world.getName())));
		msgLines.add(Txt.parse("<pink>Day: <i>"+ dayInYear));
		msgLines.add(Txt.parse("<pink>Year length: <i>"+ daysInYear + " days"));
		msgLines.add((Txt.parse("<pink>Season: <i>"+ LongerDaysAPI.getSeason(world))));
		msgLines.add((Txt.parse("<pink>Day length: <i>"+ LongerDaysAPI.getMultiplierDay(world)*10 + "min")));
		msgLines.add((Txt.parse("<pink>Night length: <i>"+ LongerDaysAPI.getMultiplierNight(world)*10 + "min")));
		
		sender.sendMessage(msgLines.toArray(new String[msgLines.size()]));
	}
}
