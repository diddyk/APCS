// David Kong		11/4/11
// Cow.java
// This class cow implements the interface Animal
// which is responsbile for grabbing the name and
// sound strings from Cow.java. It is also the
// superclass of NamedCow.java.

public class Cow implements Animal
{
	private String myType;
    private String mySound;

 	public Cow()
    {
    	myType = "cow";
    	mySound = "moo";
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