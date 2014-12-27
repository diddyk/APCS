// David Kong		10/3/11
// Roman.java

import java.util.Scanner;

public class RomanTester
{
	private int choice;
	public RomanTester()
	{
		choice = 0;
	}
	
	public static void main (String [] args)
	{
		RomanTester test = new RomanTester();
		test.promptUser();	
	}
	
	public void promptUser()
	{
		Scanner keyboard = new Scanner (System.in);
		System.out.print("\n\n\n");
		System.out.print("Welcome to Roman.java!");
		System.out.print("\n\n\nPlease choose what you would like to do: ");
		System.out.print("\n----------------------------------------");
		System.out.print("\n[1] Convert from Roman to Arabic");
		System.out.print("\n[2] Convert from Arabic to Roman");
		System.out.print("\n[3] Exit Program\n\n\n");
		do
		{
			System.out.print("\nPlease make a choice, between 1 and 3 -> ");
			choice = keyboard.nextInt();
		} while(choice < 1 || choice > 3);
		makeChoice();
	}
	
	public void makeChoice()
	{
		Scanner keyboard = new Scanner (System.in);
		switch(choice)
		{
			case 1:
				System.out.print("\n\nEnter a Roman numeral to convert into an Arabic number -> ");
				String s = keyboard.nextLine();
				System.out.print("\n\nThe Arabic number is: " + Roman.toArabic(s));
				break;
			case 2:
				System.out.print("\n\nEnter an Arabic number to convert into a Roman numeral -> ");
				int temp = keyboard.nextInt();
				Roman.toRoman(temp);
				break;
			case 3:
				System.out.print("\n\n");
				System.exit(0);
				break;
			default:
		}
		System.out.print("\n\n\n");
	}
}