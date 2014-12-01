package dk.muj.plugins.longerdays.cmd;

import java.util.List;

import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.util.MUtil;

import dk.muj.plugins.longerdays.LongerDays;
import dk.muj.plugins.longerdays.Perm;

public class CmdLongerDaysReload extends LongerDaysCmd
{

	public CmdLongerDaysReload()
	{
		this.addRequirements(ReqHasPerm.get(Perm.RELOAD.node));
	}
	
	@Override
	public void perform()
	{
		LongerDays.disableTimer();
		sender.sendMessage("Disabled timer");
		LongerDays.enableTimer();
		sender.sendMessage("Enabled timer");
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("longerdaysreload");
	}
	
}
