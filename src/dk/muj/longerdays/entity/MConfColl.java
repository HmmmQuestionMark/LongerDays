package dk.muj.longerdays.entity;

import com.massivecraft.massivecore.store.Coll;

public class MConfColl extends Coll<MConf>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static MConfColl i = new MConfColl();
	public static MConfColl get() { return i; }
	private MConfColl()
	{
		super(COLLECTION_MCONF);
	}
	
	// -------------------------------------------- //
	// DATABASE location
	// -------------------------------------------- //

	public static final String COLLECTION_MCONF = "longerdays_mconf";
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	@Override
	public void setActive(boolean active)
	{
		super.setActive(active);

		if ( ! active) return;

		MConf.i = this.get(COLLECTION_MCONF, true);
	}

}
