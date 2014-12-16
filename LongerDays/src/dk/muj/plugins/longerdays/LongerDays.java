package dk.muj.plugins.longerdays;

import com.massivecraft.massivecore.MassivePlugin;

import dk.muj.plugins.longerdays.cmd.CmdLongerDaysDebug;
import dk.muj.plugins.longerdays.engine.TimeEngine;
import dk.muj.plugins.longerdays.entity.MConfColl;

public class LongerDays extends MassivePlugin
{
	private static LongerDays i;
	public static LongerDays get() { return i; }
	public LongerDays() { i = this; }
	
	
	CmdLongerDaysDebug outerCmdLonerDaysDebug = new CmdLongerDaysDebug();

	static TimeEngine timer;
	
	@Override
	public void onEnable()
	{
		this.preEnable();  
		
		//Initialize databse
		MConfColl.get().init();
		
		//Start timer
		TimeEngine.get().activate();
		
		outerCmdLonerDaysDebug.register(this);
		
		this.postEnable();
	}
	@Override
	public void onDisable() 
	{
		//Disable timer
		TimeEngine.get().deactivate();
	}	
}