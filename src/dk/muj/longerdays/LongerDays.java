package dk.muj.longerdays;

import dk.muj.longerdays.cmd.CmdLongerDays;
import dk.muj.longerdays.engine.TimeEngine;
import dk.muj.longerdays.entity.MConfColl;
import com.massivecraft.massivecore.MassivePlugin;

public class LongerDays extends MassivePlugin
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static LongerDays i;
	public static LongerDays get() { return i; }
	public LongerDays()
	{
		i = this;
		this.setVersionSynchronized(false);
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void onEnableInner()
	{
		// Init
		this.activate(
			MConfColl.class,
			TimeEngine.class,
			CmdLongerDays.class
		);
	}

}