// David Kong		11/4/11
// Chick.java
// This class is similar to Cow.java and Pig.java,
// but it returns a random sound when the passed
// in parameter is true.

public class Chick implements Animal
{
	private String myType;
    private String mySound;
    private boolean check;

  	public Chick()	//always "cluck"
  	{	
    	myType = "chick";
    	mySound = "cheep";
  	}
  	
  	public Chick(boolean b)	//either "chick" or "cluck"
  	{
    	myType = "chick";
    	check = b;
    }

  	public String getSound()
  	{
  		if (check == true)
  		{	
			int temp = (int)(Math.random() * 2);
			if (temp == 1)
				mySound = "cheep";
			else
				mySound = "cluck";
		}
		else 
			mySound = "cheep";
    	return mySound;
  	}

  	public String getType()
  	{
    	return myType;
  	}
}