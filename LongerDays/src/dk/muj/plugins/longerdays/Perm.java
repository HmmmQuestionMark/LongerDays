package dk.muj.plugins.longerdays;

public enum Perm
{
	// -------------------------------------------- //
	// ENUM
	// -------------------------------------------- //
	
	// Here you have to register the Commands again for their respective permissions.
	RELOAD("reload"),

	
	// END OF LIST
	;
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public final String node;
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	// When constructing the Enum, take the String of it and add our pluginname in beforehand
	Perm(final String node)
	{
		this.node = "longerdays." + node;
	}
		
	// -------------------------------------------- //
	// ToString
	// -------------------------------------------- //
	
	// The obligatory toString-methode, takes the node and makes it into a string
	@Override
	public String toString()
	{
		return node;
	}
}
