// David Kong		9/22/11
// YahtzeeScoreCard.java
// Calculates and prints out a scorecard every turn.
// printScoreCardHeading prints the heading of the scorecard
// printPlayerStatus will print the numbers in every category
// changeScore will call various methods based on the dice values
//    and calculate a new score, then input it into the correct
//    category
public class YahtzeeScoreCard
{
	// Prints the heading of the scorecard
	public void printScoreCardHeading()
	{
		System.out.println("\n                                               3of  4of  Fll Smll Lrg");
		System.out.println("  NAME            1    2    3    4    5    6   Knd  Knd  Hse Strt Strt Chnc  Ytz!");
		System.out.println("+--------------------------------------------------------------------------------+");
	}
	
	// Prints the values in the score arrays
	public void printPlayerStatus(YahtzeePlayer yp)
	{
		if (yp.getName().length() <= 12)
		{
			System.out.printf("| %-12s |",yp.getName());
		}
		else
		{
			System.out.printf("| %-12s |",yp.getName().substring(0,12));
		}
		for (int i = 0; i < 13; i++)
		{
			if (yp.getScoreArrayElement(i) > -1)
			{
				System.out.printf(" %2d |",yp.getScoreArrayElement(i));
			}
			else
			{
				System.out.print("    |");
			}
			if (i == 11)
			{
				System.out.print(" ");
			}
		}
		System.out.println("\n+--------------------------------------------------------------------------------+");
	}
	
	// Calcualtes the score based on what the player chose
	public void changeScore(YahtzeePlayer yp, DiceGroup dice, int choice)
	{
		int sum = 0;
		
		// determines which method to call to calculate scores
		if (choice >= 1 && choice <= 6)
			sum = addDice(dice, choice);
		else if (choice == 7)
			sum = addThree(dice);
		else if (choice == 8)
			sum = addFour(dice);
		else if (choice == 9)
			sum = addHouse(dice);
		else if (choice == 10)
			sum = addSmallStraight(dice);
		else if (choice == 11)
			sum = addLargeStraight(dice);
		else if (choice == 12)
			sum = addChance(dice);
		else if (choice == 13)
			sum = addYahtzee(dice);

		// Assigns "sum" into the score array
		yp.setScoreArrayElement(choice-1, sum);	
	}
	
	// For categories 1-6, just add the dice based on category number
	public int addDice(DiceGroup dice, int choice)
	{
		int sum = 0;
		
		for (int i = 0; i< dice.die.length; i++)
			if (dice.die[i].getLastRollValue() == choice)
				sum += choice;
		
		return sum;
	}
	
	// Adds 3 of a kinds
	public int addThree(DiceGroup dice)
	{
		int sum = 0;
		int check = 0;
		int timesRolled = 0;

		for (int i = 0; i< dice.die.length; i++)
		{
			check = dice.die[i].getLastRollValue();
			timesRolled = 0;
			for (int k = 0; k< dice.die.length; k++)
			{
				if (dice.die[k].getLastRollValue() == check)
					timesRolled++;
				if (timesRolled == 3)		//determines if 3 of a kind or not
					sum = dice.getTotal();
			}
			System.out.println("hihi");
		}
		
		return sum;
	}
	
	// Adds 4 of a kinds
	public int addFour(DiceGroup dice)
	{
		int sum = 0;
		int check = 0;
		int timesRolled = 0;
		
		for (int i = 0; i< dice.die.length; i++)
		{
			check = dice.die[i].getLastRollValue();
			timesRolled = 0;
			for (int k = 0; k< dice.die.length; k++)
			{
				if (dice.die[k].getLastRollValue() == check)
					timesRolled++;
				if (timesRolled == 4)			//determines if 4 of a kind or not
					sum = dice.getTotal();
			}
		}
		
		return sum;
	}
	
	// Adds Full Houses
	public int addHouse(DiceGroup dice)
	{
		int check = 0;
		int sum = 0;
		int checkCounter = 0;
		boolean condition1 = false;
		int notNumber = -1;
		
		for (int i = 0; i< dice.die.length; i++)
		{
			check = dice.die[i].getLastRollValue();
			checkCounter = 0;
			for (int k = 0; k< dice.die.length; k++)
			{
				if (dice.die[k].getLastRollValue() == check)
				{
					checkCounter++;
				}
				
				if (checkCounter == 2 && dice.die[k].getLastRollValue() != notNumber)
				{
					notNumber = dice.die[k].getLastRollValue();
					condition1 = true;
				}
				
				else if (checkCounter == 3 && dice.die[k].getLastRollValue() != notNumber && condition1)//checks if full house
				{
					sum = 25;
				}
			}
		}	
		return sum;
	}
	
	// Add Small Straights
	public int addSmallStraight(DiceGroup dice)
	{
		int sum = 0;
		int check = 0;
		boolean dice1, dice2, dice3, dice4, dice5, dice6;
		dice1 = dice2 = dice3 = dice4 = dice5 = dice6 = false;
		
		for (int i = 0; i< dice.die.length; i++)
		{
			check = dice.die[i].getLastRollValue();
			
			if (check == 1)
				dice1 = true;
			else if (check == 2)
				dice2 = true;
			else if (check == 3)
				dice3 = true;
			else if (check == 4)
				dice4 = true;
			else if (check == 5)
				dice5 = true;
			else if (check == 6)
				dice6 = true;
		}
			
		// determines if small straight or not
		if ((dice1 && dice2 && dice3 && dice4) || (dice2 && dice3 && dice4 && dice5) || (dice3 && dice4 && dice5 && dice6))
			sum = 30;
		
		return sum;		
	}
	
	// Add Large Straights
	public int addLargeStraight(DiceGroup dice)
	{
		int sum = 0;
		int check = 0;
		boolean dice1, dice2, dice3, dice4, dice5, dice6;
		dice1 = dice2 = dice3 = dice4 = dice5 = dice6 = false;
		
		for (int i = 0; i< dice.die.length; i++)
		{
			check = dice.die[i].getLastRollValue();
			
			if (check == 1)
				dice1 = true;
			else if (check == 2)
				dice2 = true;
			else if (check == 3)
				dice3 = true;
			else if (check == 4)
				dice4 = true;
			else if (check == 5)
				dice5 = true;
			else if (check == 6)
				dice6 = true;
		}
			
		// determines if large straight or not
		if ((dice1 && dice2 && dice3 && dice4 && dice5) || (dice2 && dice3 && dice4 && dice5 && dice6))
			sum = 40;	
		
		return sum;		
	}
	
	// Adds all the dice, for chance
	public int addChance(DiceGroup dice)
	{
		int sum = dice.getTotal();
		
		return sum;
	}

	// Adds Yahtzees
	public int addYahtzee(DiceGroup dice)
	{
		int sum, check, numTimes;
		sum = check = numTimes = 0;
		
		for (int i = 0; i< dice.die.length; i++)
		{
			check = dice.die[i].getLastRollValue();
			numTimes = 0;
			for (int k = 0; k< dice.die.length; k++)
			{
				if (dice.die[k].getLastRollValue() == check)
					numTimes++;
				if (numTimes == 5)				//determines if yahtzee or not
					sum = 50;
			}
		}
		
		return sum;
	}
}