// David Kong		10/21/11
// MasterMind.java
// Runs the game of MasterMind
// Calls MasterMindGameBoard which manages the gameboard, which
// calls PegArray and Peg to manage individual pegs
// Manages peg input and turn number.
// Also determinds if user has won or not.
//board.getArray(index).getPeg(i).putLetter(input)
//board.getArray(index).findMatches(board.getMaster)
//keyboard.nextLine().charAt(0)

import java.util.Scanner;

public class MasterMind
{
	private int counter;
	private MasterMindGameBoard board;
	private Scanner keyboard;
	
	public MasterMind()  //constructor
	{
		counter = 0;
		keyboard = new Scanner(System.in);
		board = new MasterMindGameBoard();
	}
	
	public static void main (String [] args)
	{
		MasterMind game = new MasterMind();
		game.play();	
	}
	
	//plays the game by looping askUser 10 times, 
	// and checking if user won each time
	public void play()  
	{
		boolean win = false;
		int breaker = 0;
		printIntroduction();
		System.out.print("\n\nThis is your game board: \n");
		board.showBoard(true);
		while(!win && counter < 10 && breaker == 0)  //loops ten times 
		{
			askUser();
			if (board.getArray(counter - 1).getExactMatches() == 4) //if exact value 4
			{
				win = true;
				breaker = -1;
			}
		}
		
		//prints out corresponding messages
		if (win == true)
			System.out.print("\n\nCongrats! You won MasterMind in " + counter + " turns!\n\n\n");
		else
			System.out.print("\n\nSorry! You lost MasterMind!\n\n\n");
	}
	
	//prints introduciton block
	public void printIntroduction ( )
	{
		System.out.println("\n\n+------------------------------------------------------------------------------------+");
		System.out.println("| WELCOME TO MONTA VISTA MASTERMIND!                                                 |");
		System.out.println("|                                                                                    |");
		System.out.println("| The game of MasterMind is played on a four-peg gameboard, and six peg colors can   |");
		System.out.println("| be used.  First, the computer will choose a random combination of four pegs, using |");
		System.out.println("| some of the six colors (black, white, blue, green, yellow, and red).  Repeats are  |");
		System.out.println("| allowed, so there are 6 * 6 * 6 * 6 = 1296 possible combinations.  This \"master    |");
		System.out.println("| combination\" is then hidden from the player, and the player starts making guesses  |");
		System.out.println("| at the master combination.  The player has 10 turns to guess the combination.      |");
		System.out.println("| Each time the player makes a guess for the 4-peg combination, the number of exact  |");
		System.out.println("| matches and partial matches are then reported back to the user. If the player      |");
		System.out.println("| finds the exact combination, the game ends with a win.  If the player does not     |");
		System.out.println("| find the master combination after 10 turns, the game ends with a loss.             |");
		System.out.println("|                                                                                    |");
		System.out.println("| LET'S PLAY SOME MASTERMIND!                                                        |");
		System.out.println("+------------------------------------------------------------------------------------+\n\n");
		System.out.print("Hit the Enter key to start the game : ");
		keyboard.nextLine();
	}
	
	//Asks user for input. If bad input, re-prompt
	//Saves input values to individuals Peg in PegArray
	//Also prints out turn number
	public void askUser()
	{		
		char input = 'X';
		System.out.print("\n\n");
		System.out.print("Turn: " + (counter + 1) + "\n\n");  //prints turn number
		for (int i = 0; i < 4; i++)
		{
			do
			{
				System.out.print("Enter the letter for peg " + (i + 1) + " (A, B, C, D, E, or F): ");
				input = keyboard.next().toUpperCase().charAt(0);
			}while (input < 'A' || input > 'F'); //reprompt
			board.getArray(counter).getPeg(i).putLetter(input); //saves inputted values
		}
		board.getArray(counter).findMatches(board.getMaster()); //finds matches
		
		board.showBoard(true);  //shows board
		counter++;
	}
}