// David Kong           9/14/11
// Sparks.java
// This program will run a game of "Sparks"
// The game will randomly roll a pair of 6-sided die every game,
// then find the sum of the die.
// If on the first roll, a 7 or 11 is rolled, the player wins.
// If on the frist roll, a 2, 3, or 12 is rolled, the player loses.
// If none of those values are rolled, the game continues until
// the player rolls and gets the same sum as his initial value.
// If the player is able to get the same sum again, the player wins.
// If the player rolls a 7 as a sum, the player loses.
// The program then calculates your win percentage.(Around 49.20%)

public class Sparks
{
       private Dice die1;
       private int gamenum;
       private int wins;
       private int target;
       private boolean win;

       public Sparks()
       {
               die1 = new Dice();
               gamenum = 1;
               wins = target = 0;
               win = false;
       }

       public static void main (String [] args)
       {
               Sparks game = new Sparks();
               game.loopProgram();
       }

       //  Loops the program 1000 times by calling printBorders and playGame
       //  , to play the game of sparks 1000 times
       public void loopProgram()
       {
               System.out.print("\n\n\n");
               while (gamenum < 1001)
               {
                       printBorders();
                       gamenum++;
               }      
               double percentage = wins/10.0;
               System.out.print("\n\nYou won " + percentage + "0 % of the time!\n\n\n");
       }

       //  Prints the borders around each game, as well as calculating the
       //  percentage of wins.
       //  Also calls playGame to run the game.
       public void printBorders()
       {
               System.out.print("\n\nGame " + gamenum + " : ");
               System.out.print("\n   +--------------------------+");
               playGame();
               System.out.print("\n   +--------------------------+\t");
               
               if (win == true)
                       System.out.print("\tPlayer Wins!\n\n");
               else
                       System.out.print("\tPlayer Loses!\n\n");
       }
       
       //  Runs the game of sparks.
       public void playGame()
       {
    	   int rollcount = 1;
           boolean play = true;
           win = false;
           while (play == true)
           {
        	   int roll1 = die1.roll();		//rolls a dice twice
               int roll2 = die1.roll();
               int sum = roll1 + roll2;         
               System.out.printf("\n   |   Roll " + rollcount + "\t: " + roll1 + " + " + roll2 + " = %2d  |", sum);

               if (rollcount == 1)			//if its the first roll
               {
                   target = sum;
                   if (target == 7 || target == 11)
                   {
                	   win = true;
                       wins++;
                       play = false;
                   }
                   else if(target == 2 || target == 3 || target == 12)
                       play = false;      
               }
               else							//for rolls other than the first
               {
            	   if (sum == target)
                   {
            		   win = true;
                       wins++;
                       play = false;
                   }
                   else if (sum == 7)
                       play = false;
               }
               rollcount++;           
           } 
		}
}