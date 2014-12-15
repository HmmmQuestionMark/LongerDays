package dk.muj.plugins.longerdays;

public class DayLengthSetting
{
	public DayLengthSetting()
	{
		
	}
	
	private int yearLength = 400;
	
	private int summerDayLength = 1;
	private int summerNightLength = 1;
	
	private int fallDayLength = 1;
	private int fallNightLength = 1;
	
	private int winterDayLength = 1;
	private int winterNightLength = 1;
	
	private int springDayLength = 1;
	private int springNightLength = 1;
	
	public int getSummerDayLength()
	{
		return summerDayLength;
	}
	public void setSummerDayLength(int summerDayLength)
	{
		this.summerDayLength = summerDayLength;
	}

	public int getSummerNightLength()
	{
		return summerNightLength;
	}

	public void setSummerNightLength(int summerNightLength)
	{
		this.summerNightLength = summerNightLength;
	}

	public int getFallDayLength()
	{
		return fallDayLength;
	}

	public void setFallDayLength(int fallDayLength)
	{
		this.fallDayLength = fallDayLength;
	}

	public int getFallNightLength()
	{
		return fallNightLength;
	}

	public void setFallNightLength(int fallNightLength)
	{
		this.fallNightLength = fallNightLength;
	}

	public int getWinterDayLength()
	{
		return winterDayLength;
	}

	public void setWinterDayLength(int winterDayLength)
	{
		this.winterDayLength = winterDayLength;
	}

	public int getWinterNightLength()
	{
		return winterNightLength;
	}

	public void setWinterNightLength(int winterNightLength)
	{
		this.winterNightLength = winterNightLength;
	}

	public int getSpringDayLength()
	{
		return springDayLength;
	}

	public void setSpringDayLength(int springDayLength)
	{
		this.springDayLength = springDayLength;
	}

	public int getSpringNightLength()
	{
		return springNightLength;
	}

	public void setSpringNightLength(int springNightLength)
	{
		this.springNightLength = springNightLength;
	}
	public int getYearLength()
	{
		return yearLength;
	}
	public void setYearLength(int yearLength)
	{
		this.yearLength = yearLength;
	}
}
