package com.massivecraft.longerdays.cmd;

import com.massivecraft.longerdays.entity.MConf;
import com.massivecraft.massivecore.command.editor.CommandEditSingleton;

public class CmdLongerdaysConfig extends CommandEditSingleton<MConf>
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //

	public CmdLongerdaysConfig()
	{
		super(MConf.get());
	}
	
}
