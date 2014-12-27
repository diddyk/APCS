// David Kong		11/4/11
// NamedCow.java
// This class is derived from Cow.java, but
// there is another string returned, the
// name of the cow passed in from the parameter
// list in Farm.java

public class NamedCow extends Cow
{
	private String myName;

	public NamedCow(String s)
	{
		super();
		myName = s;
 	}
	
	public String getName()
	{
		return myName;
	}
}