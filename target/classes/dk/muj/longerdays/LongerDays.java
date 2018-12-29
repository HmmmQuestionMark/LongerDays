package com.massivecraft.longerdays;

import com.massivecraft.longerdays.cmd.CmdLongerDays;
import com.massivecraft.longerdays.engine.TimeEngine;
import com.massivecraft.longerdays.entity.MConfColl;
import com.massivecraft.massivecore.MassivePlugin;

public class LongerDays extends MassivePlugin
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static LongerDays i;
	public static LongerDays get() { return i; }
	public LongerDays() { i = this; }

	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	
	CmdLongerDays outerCmdLongerDays = new CmdLongerDays();

	static TimeEngine timer;

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void onEnableInner()
	{
		// Init
		this.activate(
			MConfColl.get(),
			TimeEngine.get(),
			outerCmdLongerDays
		);
	}

}