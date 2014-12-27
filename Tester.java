public class Tester
{
	public static void main(String[] args)
    {
		Cow c = new Cow();
		System.out.println( c.getType() + " goes " + c.getSound() );

		Pig p = new Pig();
		System.out.println( p.getType() + " goes " + p.getSound() );
		
		Chick h = new Chick();
		System.out.println( h.getType() + " goes " + h.getSound() );
  	}
}