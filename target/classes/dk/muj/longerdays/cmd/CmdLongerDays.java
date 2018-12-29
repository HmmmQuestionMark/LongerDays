package com.massivecraft.longerdays.cmd;

import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.MassiveCommandVersion;
import com.massivecraft.longerdays.LongerDays;

public class CmdLongerDays extends MassiveCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //

	public CmdLongerDaysInfo cmdLongerDaysInfo = new CmdLongerDaysInfo();
	public CmdLongerDaysDebug cmdLongerDaysDebug = new CmdLongerDaysDebug();
	public CmdLongerdaysConfig cmdLongerdaysConfig = new CmdLongerdaysConfig();
	public MassiveCommandVersion innerCmdVersion = new MassiveCommandVersion(LongerDays.get());

	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //

	public CmdLongerDays()
	{
		super.addAliases("ld");
	}

}
