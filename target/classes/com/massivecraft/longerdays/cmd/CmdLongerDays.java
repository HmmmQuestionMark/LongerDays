package com.massivecraft.longerdays.cmd;

import com.massivecraft.longerdays.LongerDays;
import com.massivecraft.massivecore.command.MassiveCommandVersion;

public class CmdLongerDays extends LongerDaysCommand
{
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //

	private static CmdLongerDays i = new CmdLongerDays();
	public static CmdLongerDays get() { return i; }

	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //

	public CmdLongerDaysInfo cmdLongerDaysInfo = new CmdLongerDaysInfo();
	public CmdLongerDaysDebug cmdLongerDaysDebug = new CmdLongerDaysDebug();
	public MassiveCommandVersion innerCmdVersion = new MassiveCommandVersion(LongerDays.get());

	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //

	public CmdLongerDays()
	{
		super.addAliases("ld");
	}

}
