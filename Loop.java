// David Kong
// 8/23/11
// Loop.java
// Asks user how many times to roll a dice, and rolls it that many times. 
public class Loop
{
	private int numsides;
	private Dice die1;
	
	public Loop()
	{
		numsides = 0;
		die1 = new Dice();	
	}
	
	public static void main (String [] args)
	{
		Loop myloop  = new Loop();
		
		myloop.getInfo();
		myloop.printRolls();
	}
	
	public void getInfo()
	{
		numsides = Prompt.getValue("\n\n\nEnter the number of sides for your die, ", 2, 1000);
		die1 = new Dice(numsides);
	}
	
	public void printRolls()
	{

		for(int i = 1; i <= 20; i++)
		{
			int num = die1.roll();
			System.out.printf("\n%-6d%-6d", i, num);
		}
		System.out.println("\n\nThe number of rolls was " + die1.numrolls());
		System.out.println("\n\n");						//use new lines
	}
}