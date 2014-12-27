// David Kong		10/20/11
// PegArray.java
// Stores an array of pegs defined in the peg class
// One array = master OR user-inputted set
// Can grab value of one peg or number of pegs

public class PegArray
{
	private Peg [] array;
	private int exactmatch, partialmatch;
	
	public PegArray()  //constructor
	{
		array = new Peg [4];
		setValues();
	}
	
	public PegArray (int n)  // if not 4 pegs
	{
		array = new Peg [n];
		setValues();
	}	
	
	public void setValues()  //sets values 
	{
		for (int i = 0; i < array.length; i++)
		{
			array[i] = new Peg();
		}
		
		exactmatch = partialmatch = -1;
	}
	
	public Peg getPeg(int i)  //returns peg value
	{
		return array[i];
	}
	
	public int length()  //returns array length
	{
		return array.length;
	}
	
	public int getExactMatches()  //returns # of exact matches
	{
		return exactmatch;
	}
	
	public int getPartialMatches()  //returns # of patial matches
	{
		return partialmatch;
	}
	
	//do this later
	public void findMatches(PegArray master)  //finds number of exact/partial matches
	{
		exactmatch = 0;		
		partialmatch = 0;
		
		//exact matches
		for (int i = 0; i < array.length; i++)
		{
			if (array[i].getLetter() == master.getPeg(i).getLetter())
				exactmatch++;
		}
		
		//partial matches
		boolean [] checker = new boolean[4]; //prevents wrong solutions
		for(int i = 0; i < master.length(); i++)
		{
			for(int j = 0; j < master.length(); j++)
			{
				//scans through all values through both arrays, master and user-inputted
				if(array[j].getLetter() == master.getPeg(i).getLetter() && !checker[j])
				{
					partialmatch++;
					checker[j] = true;
					j = master.length();
				}
			}
		}
		
		//subtract cases that were counted more than once
		if(partialmatch >= exactmatch)
			partialmatch -= exactmatch;		
	}
}