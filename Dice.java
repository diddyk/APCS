// David Kong
// Dice.java
// Rolls some virtual dice

public class Dice
{
	private int rollcount, sides, lastRollValue;
	
	public Dice()
	{
		sides = 6;
		rollcount = lastRollValue = 0;
	}
	
	public Dice(int s)
	{
		sides = s;
		rollcount = lastRollValue = 0;
	}
	
	public int roll()
	{
		rollcount++;
		lastRollValue = (int)(Math.random() * sides) +1;
		return lastRollValue;
	}
	
	public int numrolls()
	{
		return rollcount;
	}
	
	public int getLastRollValue()
	{
		return lastRollValue;
	}
}