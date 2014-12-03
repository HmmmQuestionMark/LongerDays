package dk.muj.plugins.longerdays.entity;

import com.massivecraft.massivecore.MassiveCore;
import com.massivecraft.massivecore.store.Coll;
import com.massivecraft.massivecore.store.MStore;

import dk.muj.plugins.longerdays.LongerDays;

public class MConfColl extends Coll<MConf>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static MConfColl i = new MConfColl();
	public static MConfColl get() { return i; }
	private MConfColl()
	{
	  //This is only possible if you made a Const class, which we have here.
	  //You should also need the static .get() method in your plugin, which we have here.
		super(COLLECTION_MCONF, MConf.class, MStore.getDb(), LongerDays.get());
	}
	
	// -------------------------------------------- //
	// DATABASE location
	// -------------------------------------------- //
	
	
	public static final String COLLECTION_MCONF = "longerdays_mconf";
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
		
	//This is important. I tried without it and it didn't work.
	@Override
	public void init()
	{
		super.init();
		MConf.i = this.get(MassiveCore.INSTANCE, true);
	}
}
