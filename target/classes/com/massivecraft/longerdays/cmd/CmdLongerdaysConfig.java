package com.massivecraft.longerdays.cmd;

import com.massivecraft.longerdays.entity.MConf;
import com.massivecraft.massivecore.command.editor.CommandEditSingleton;

import java.util.Objects;

public class CmdLongerdaysConfig extends CommandEditSingleton<MConf>
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //

	public CmdLongerdaysConfig()
	{
		super(Objects.requireNonNull(MConf.get()));
	}
	
}
