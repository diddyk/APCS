// David Kong		11/4/11
// Pig.java
// This class is similar to Cow.java,
// returning a sound and type of string

public class Pig implements Animal
{
  	private String myType;
  	private String mySound;

  	public Pig()
  	{
    	myType = "pig";
    	mySound = "oink";
  	}

  	public String getSound()
  	{
    	return mySound;
  	}

  	public String getType()
  	{
    	return myType;
  	}
}