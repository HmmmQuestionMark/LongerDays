package com.massivecraft.longerdays.cmd;

import com.massivecraft.longerdays.entity.MConf;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.type.TypeWorld;
import com.massivecraft.massivecore.mixin.MixinWorld;
import com.massivecraft.massivecore.util.Txt;
import com.massivecraft.longerdays.LongerDaysAPI;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class CmdLongerDaysDebug extends MassiveCommand
{

	public CmdLongerDaysDebug()
	{
		this.addParameter(TypeWorld.get(), true, "world", "your", true);
	}
	
	
	@Override
	public void perform() throws MassiveException
	{
		World world = this.readArg(me.getWorld());

		int day = (int) (world.getFullTime()/LongerDaysAPI.DAY_LENGTH_TICKS);
		int daysInYear = MConf.get().worldTimeMultipliers.get(world.getName()).getYearLength();
		int dayInYear = day % daysInYear;
		int daysInSeason = daysInYear/4;
		
		List<String> msgLines = new ArrayList<>();
		msgLines.add(Txt.titleize("Debug info "+ MixinWorld.get().getWorldDisplayName(world.getName())).toPlain(true));
		
		msgLines.add(Txt.parse("<pink>Time: <i>"+ world.getTime()));
		msgLines.add(Txt.parse("<pink>IsDay: <i>"+ LongerDaysAPI.isDay((int) world.getTime())));
		msgLines.add(Txt.parse("<pink>Day: <i>"+ day));
		msgLines.add(Txt.parse("<pink>DaysInyear: <i>"+ daysInYear));
		msgLines.add(Txt.parse("<pink>DayInYear: <i>"+ dayInYear));
		msgLines.add(Txt.parse("<pink>DaysInSeason: <i>"+ daysInSeason));
		msgLines.add(Txt.parse("<pink>Season: <i>"+ LongerDaysAPI.getSeason(world)));
		
		message(msgLines.toArray(new String[msgLines.size()]));
	}
	
}
