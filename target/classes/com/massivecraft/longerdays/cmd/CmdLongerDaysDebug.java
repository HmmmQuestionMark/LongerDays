package com.massivecraft.longerdays.cmd;

import com.massivecraft.longerdays.LongerDaysAPI;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.type.TypeWorld;
import com.massivecraft.massivecore.mixin.MixinWorld;
import com.massivecraft.massivecore.util.Txt;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class CmdLongerDaysDebug extends LongerDaysCommand
{

	public CmdLongerDaysDebug()
	{
		this.addParameter(TypeWorld.get(), true, "world", "your", true);
	}
	
	
	@Override
	public void perform() throws MassiveException
	{
		World world = this.readArg(me.getWorld());
		
		List<String> msgLines = new ArrayList<>();
		msgLines.add(Txt.titleize("Debug info "+ MixinWorld.get().getWorldDisplayName(world.getName())).toPlain(true));
		
		msgLines.add(Txt.parse("<pink>Time: <i>"+ world.getTime()));
		msgLines.add(Txt.parse("<pink>IsDay: <i>"+ LongerDaysAPI.isDay((int) world.getTime())));
		
		message(msgLines.toArray(new String[msgLines.size()]));
	}
	
}
