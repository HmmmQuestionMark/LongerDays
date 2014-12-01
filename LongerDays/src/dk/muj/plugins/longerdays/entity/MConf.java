package dk.muj.plugins.longerdays.entity;

import java.util.Map;

import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;

public class MConf extends Entity<MConf>
{
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	
	protected static transient MConf i;
	public static MConf get() { return i; }
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	
	public Map<String, Integer> worldTimeMultipliers = MUtil.map(
		"world1", 3,
		"world2", 3,
		"world3", 3,
		"world4", 3

	);
	public int run = 120;
}