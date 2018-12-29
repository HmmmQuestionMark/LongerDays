package com.massivecraft.longerdays;

public class DayLengthSetting
{
	public DayLengthSetting()
	{
		
	}
	
	private int yearLength = 400;
	
	private int summerDayLengthMultiplier = 1;
	private int summerNightLengthMultiplier = 1;
	
	private int fallDayLengthMultiplier = 1;
	private int fallNightLengthMultiplier = 1;
	
	private int winterDayLengthMultiplier = 1;
	private int winterNightLengthMultiplier = 1;
	
	private int springDayLengthMultiplier = 1;
	private int springNightLengthMultiplier = 1;
	
	public int getSummerDayLengthMultiplier()
	{
		return summerDayLengthMultiplier;
	}
	public void setSummerDayLengthMultiplier(int summerDayLengthMultiplier)
	{
		this.summerDayLengthMultiplier = summerDayLengthMultiplier;
	}

	public int getSummerNightLengthMultiplier()
	{
		return summerNightLengthMultiplier;
	}
	public void setSummerNightLengthMultiplier(int summerNightLengthMultiplier)
	{
		this.summerNightLengthMultiplier = summerNightLengthMultiplier;
	}

	public int getFallDayLengthMultiplier()
	{
		return fallDayLengthMultiplier;
	}
	public void setFallDayLengthMultiplier(int fallDayLengthMultiplier)
	{
		this.fallDayLengthMultiplier = fallDayLengthMultiplier;
	}

	public int getFallNightLengthMultiplier()
	{
		return fallNightLengthMultiplier;
	}
	public void setFallNightLengthMultiplier(int fallNightLengthMultiplier)
	{
		this.fallNightLengthMultiplier = fallNightLengthMultiplier;
	}

	public int getWinterDayLengthMultiplier()
	{
		return winterDayLengthMultiplier;
	}
	public void setWinterDayLengthMultiplier(int winterDayLengthMultiplier)
	{
		this.winterDayLengthMultiplier = winterDayLengthMultiplier;
	}

	public int getWinterNightLengthMultiplier()
	{
		return winterNightLengthMultiplier;
	}
	public void setWinterNightLengthMultiplier(int winterNightLengthMultiplier)
	{
		this.winterNightLengthMultiplier = winterNightLengthMultiplier;
	}

	public int getSpringDayLengthMultiplier()
	{
		return springDayLengthMultiplier;
	}
	public void setSpringDayLengthMultiplier(int springDayLengthMultiplier)
	{
		this.springDayLengthMultiplier = springDayLengthMultiplier;
	}

	public int getSpringNightLengthMultiplier()
	{
		return springNightLengthMultiplier;
	}
	public void setSpringNightLengthMultiplier(int springNightLengthMultiplier)
	{
		this.springNightLengthMultiplier = springNightLengthMultiplier;
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
