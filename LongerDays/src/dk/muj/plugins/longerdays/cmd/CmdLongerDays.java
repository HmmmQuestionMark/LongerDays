package dk.muj.plugins.longerdays.cmd;

import com.massivecraft.massivecore.cmd.HelpCommand;
import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.VersionCommand;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;

import dk.muj.plugins.longerdays.LongerDays;
import dk.muj.plugins.longerdays.Perm;

public class CmdLongerDays extends MassiveCommand
{
	public CmdLongerDaysInfo innerCmdLongerDaysInfo = new CmdLongerDaysInfo();
	public CmdLongerDaysDebug innerCmdLongerDaysDebug = new CmdLongerDaysDebug();
	public VersionCommand innerCmdVersion = new VersionCommand(LongerDays.get(), Perm.VERSION.node, "v", "version");

	public CmdLongerDays()
	{
		super.addAliases("ld");
		super.addSubCommand(HelpCommand.get());
		super.addSubCommand(innerCmdLongerDaysInfo);
		super.addSubCommand(innerCmdLongerDaysDebug);
    	super.addSubCommand(innerCmdVersion);
    	super.addRequirements(ReqHasPerm.get(Perm.BASECOMMAND.node));
	}
}
