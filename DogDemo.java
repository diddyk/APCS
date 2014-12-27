// David Kong		10/28/11
// DogDemo.java
// Dog.java
// UnderDog.java
// 3 classes in one

// Polymorphism -> take a class, through other defined subclass, 
// can manipulate first class

public class DogDemo   
{
	public static void main ( String [] args )   
	{
		Dog fido = new UnderDog();
		System.out.println("\n\n\n");
		fido.act(); //act calls Underdog's "act"
					//Underdog "act" calls dog "act" first
		System.out.println("\n\n\n");
	}
}

class Dog   
{
	public void act()   
	{
		System.out.print("run ");
		eat();
		//eat calls Underdog's "eat"
		//Underdog's "eat" calls Dog's "eat"
	}

	public void eat()   
	{
		System.out.print("eat ");
	}
}

class UnderDog extends Dog   
{
	public void act()   
	{
		super.act();
		System.out.print("sleep ");
	}

	public void eat()   
	{
		super.eat();
		System.out.print("bark ");
	}
}
