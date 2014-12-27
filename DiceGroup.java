// David Kong
// DiceGroup.java
// Rolls and prints dice to the screen

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DiceGroup
{
	public Dice [] die;
	
	public DiceGroup()						//constructor
	{
		die = new Dice [5];
		for (int i = 0; i< die.length; i++)
		{
			die[i] = new Dice();
		}
	}
	
	public DiceGroup(int d)					//constructor
	{
		die = new Dice [d];
		for (int i = 0; i< die.length; i++)
		{
			die[i] = new Dice();
		}
	}
	
	public static void main(String [] args)
	{
		DiceGroup seedice = new DiceGroup ( );
		
		seedice.rollDice();
		seedice.printDice();	
	}
	
	public Dice [] getDie()
	{
		return die;
	}
	
	// Rolls the dice
	public void rollDice()
	{
		for (int i = 0; i< die.length; i++)
		{
			die[i].roll();
		}
	}
	
	// Rolls the dice a certain number of times
	public void rollDice(String rawHold)
	{
		for (int i = 0; i< die.length; i++)
		{
			boolean doRoll = true;
			
			for (int j = 0; j < rawHold.length(); j++)
			{
				if ((int)rawHold.charAt(j) - 48 == (i+1))
				{
					doRoll = false;
				}
			}
			
			if (doRoll)
			{
				die[i].roll();
			}
		}
	}
	
	// Gets the total of the dice
	public int getTotal()
	{
		int sum = 0;
		for (int i=0; i < die.length; i++)
		{
			sum += die[i].getLastRollValue();
		}
		return sum;
	}
	
	// Prints the other part dice
	public void printDice()
	{
		printDiceHeadings();
		
		for (int row = 0; row < 6; row++)
		{
			System.out.print(" ");
			for (int diceindex = 0; diceindex < die.length; diceindex++)
			{
					findAndPrintCorrectLine(row,diceindex);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Prints part of the dice
	public void printDiceHeadings()
	{
		System.out.println();
		for (int i = 0; i < die.length; i++)
		{
			System.out.print("    # " + (i+1) + "       ");
		}
		System.out.println();
	}
	
	// Prints dice by using dice.txt
	public void findAndPrintCorrectLine(int row, int diceindex)
	{
		String line = new String("");
		File file = new File("dice.txt");
		Scanner infile = null;
		try
		{
			infile = new Scanner (file);
		}
		catch (FileNotFoundException e)
		{
			System.out.println ("Error: Unable to find " + file + ".");
		}
		int composite = 7 * row + die[diceindex].getLastRollValue();
		int linenum = getLineNumber(composite);
		
		for (int filerow = 0; filerow < linenum; filerow++)
		{
			line = infile.nextLine();
		}
		System.out.print(line + "     ");
		infile.close();
	}
	
	// Gets line number to help print dice using dice.txt
	public int getLineNumber(int value)
	{
		if (value < 14)
			return value / 7 + 1;
		else
		{
			switch(value)
			{
				case 15: case 23: case 25: case 29:
					return 2;
				case 18: case 19: case 20: case 27: case 32: case 33: case 34:
					return 3;
				case 22: case 24: case 26:
					return 4;
				case 16: case 17:
					return 5;
				case 30: case 31:
					return 6;
				default:  // for value >= 35
					return 7;
			}
		}
	}

}