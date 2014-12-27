// David Kong
// 8/24/11
// Prompt.java
// 

import java.util.Scanner;

public class Prompt
{
	public static int getValue (String ask)				//pass in ask
	{
		Scanner input = new Scanner(System.in);
		System.out.print(ask);
		int value = input.nextInt();
		return value;
	}
	
	public static int getValue (String ask, int min, int max)				//method overloading - int 2-1000
	{
		Scanner input = new Scanner(System.in);
		System.out.print(ask);
		System.out.print("(from " + min + " to " + max + ") -> ");
		int value;
		do 
		{
			value = input.nextInt();
			if (value < min || value > max)
			{
				System.out.print("\nTry again! (from " + min + " to " + max + ") -> ");
			}
		}while(value < min || value > max);
		return value;
	}
	
	public static double getValue (String ask, double min, double max)				//method overloading - double
	{
		Scanner input = new Scanner(System.in);
		System.out.print(ask);
		System.out.printf(" from %6.2f to %6.2f", min, max);					//2 decimal places, format to 6 places
		double value;
		do 
		{
			value = input.nextDouble();
			if (value < min || value > max)
			{
				System.out.printf("\n, Try again, from %6.2f to %6.2f" + " -> ", min, max);					//2 decimal places, format to 6 pla
			}
		}while(value < min || value > max);
		return value;
	}
	
	public static String getString (String ask, int min, int max)				//method overloading - int 2-1000
	{
		Scanner input = new Scanner(System.in);
		String value = null;
		
		System.out.print("\n(from a minimum length of " + min + " characters to a maximum length of " + max + " characters) -> ");

		do 
		{
			value = input.next();
			if (value.length() < min || value.length() > max)
			{
				System.out.print("\nTry again! (from a minimum length of " + min + " characters to a maximum length of " + max + " characters) -> ");
			}
		}while(value.length() < min || value.length() > max);
		return value;
	}
	
	
}