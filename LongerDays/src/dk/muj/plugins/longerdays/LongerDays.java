package dk.muj.plugins.longerdays;

import com.massivecraft.massivecore.MassivePlugin;

import dk.muj.plugins.longerdays.cmd.CmdLongerDaysReload;
import dk.muj.plugins.longerdays.entity.MConf;
import dk.muj.plugins.longerdays.entity.MConfColl;

public class LongerDays extends MassivePlugin
{
	private static LongerDays i;
	public static LongerDays get() { return i; }
	public LongerDays() { i = this; }
	CmdLongerDaysReload outerCmdLongerDaysReload = new CmdLongerDaysReload();

	static Timer timer;
	static int schedulerTime;
	
	@Override
	public void onEnable()
	{
		this.preEnable();  
		
		//Initialize databse
		MConfColl.get().init();
		schedulerTime = MConf.get().run;
		
		//Commands
		outerCmdLongerDaysReload.register(this);
		
		//Start timer
		LongerDays.enableTimer();
		
		this.postEnable();
	}
	@Override
	public void onDisable() 
	{
		//Disable timer
		LongerDays.disableTimer();
	}
	
	public static void disableTimer()
	{
		timer.cancel();
		timer = null;
	}
	
	public static void enableTimer()
	{
		timer = new Timer();
		timer.runTaskTimer( get(), schedulerTime, schedulerTime);
	}
	
}
