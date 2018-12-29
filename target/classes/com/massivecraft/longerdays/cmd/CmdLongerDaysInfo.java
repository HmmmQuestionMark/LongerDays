package com.massivecraft.longerdays.cmd;

import com.massivecraft.longerdays.DayLengthSetting;
import com.massivecraft.longerdays.LongerDaysAPI;
import com.massivecraft.longerdays.entity.MConf;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.type.TypeWorld;
import com.massivecraft.massivecore.mixin.MixinWorld;
import com.massivecraft.massivecore.util.Txt;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class CmdLongerDaysInfo extends LongerDaysCommand
{

	public CmdLongerDaysInfo()
	{
		this.addParameter(TypeWorld.get(), true, "world", "your", true);
	}
	
	
	@Override
	public void perform() throws MassiveException
	{
		World world = this.readArg(me.getWorld());

		int day = (int) (world.getFullTime()/LongerDaysAPI.DAY_LENGTH_TICKS);
		DayLengthSetting setting = MConf.get().worldTimeMultipliers.get(world.getName());

		if(setting == null)
		{
			msg("<b>That world does not have specific settings");
			return;
		}
		
		List<String> msgLines = new ArrayList<String>();
		msgLines.add(Txt.titleize("Time info "+ MixinWorld.get().getWorldDisplayName(world.getName())).toPlain(true));
		msgLines.add((Txt.parse("<pink>Day length: <i>"+ setting.getDayLengthMultiplier()*10 + "min")));
		msgLines.add((Txt.parse("<pink>Night length: <i>"+ setting.getNightLengthMultiplier()*10 + "min")));
		
		message(msgLines);
	}
}
