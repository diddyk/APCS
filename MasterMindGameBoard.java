// David Kong		10/20/11
// MasterMindGameBoard.java
// Stores GameBoard values of MasterMind
// Manages user-inputted PegArray and master PegArray

public class MasterMindGameBoard
{
	private PegArray [] board;
	private PegArray master;
	
	public MasterMindGameBoard()  //constructor
	{
		master = new PegArray();
		Dice die = new Dice();
		for (int i = 0; i < master.length(); i++)
		{	
			int value = die.roll() + 64;
			master.getPeg(i).putLetter((char)value);
		}
		board = new PegArray [10];
		for (int i = 0; i < board.length; i++)
		{
			board[i] = new PegArray();
		}
	}
	
	public static void main (String [] args)
	{
		MasterMindGameBoard myboard = new MasterMindGameBoard();
		myboard.showBoard(true);
	}
	
	//Calls appropriate methods to print out board
	public void showBoard (boolean reveal)
	{
		header();
		showMainGameArray(reveal);
		showExactMatches();
		showPartialMatches();
	}
	
	//Prints out the board header
	public void header ( )
	{
		System.out.println("\n+----------------------------------------------------------------------+");
		System.out.print("| MASTER      1     2     3     4     5     6     7     8     9     10 |");
	}
	
	//Prints out the board
	public void showMainGameArray (boolean reveal)
	{
		for (int i = 0; i < master.length(); i++)
		{
			System.out.println("\n+-------+  +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+");
			if (reveal)
			{
				System.out.print("|   " + master.getPeg(i).getLetter() + "   |  |");
			}
			else
			{
				System.out.print("|  ***  |  |");
			}
			for (int j = 0; j < board.length; j++)
			{
				if (board[j].getPeg(i).getLetter() == 'X')
				{
					System.out.print("     |");
				}
				else
				{
					System.out.print("  " + board[j].getPeg(i).getLetter() + "  |");
				}
			}
		}
	}
	
	//Displays exact matches on gameboard
	public void showExactMatches ( )
	{
		System.out.println("\n+-------+  +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+");
		System.out.print("| Exact   ");
		for (int i = 0; i < board.length; i++)
		{
			if (board[i].getExactMatches() != -1)
			{
				System.out.print("    " + board[i].getExactMatches() + " ");  //gets exact matches
			}
			else
			{
				System.out.print("      ");
			}
		}
		System.out.print(" |\n");
	}
	
	//Displays Partial matches on gameboard
	public void showPartialMatches ( )
	{
		System.out.print("| Partial ");
		for (int i = 0; i < board.length; i++)
		{
			if (board[i].getPartialMatches() != -1)
			{
				System.out.print("    " + board[i].getPartialMatches() + " "); //gets partial matches
			}
			else
			{
				System.out.print("      ");
			}
		}
		System.out.println(" |\n+----------------------------------------------------------------------+\n");
	}
	
	public PegArray getArray (int i) //returns user-inputted array
	{
		return board[i];
	}
	
	public PegArray getMaster() //returns the "master" array
	{
		return master;
	}
}