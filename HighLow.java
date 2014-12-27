// David Kong        11/9/11
// HighLow.java
// This program involves a standard deck of 52 cards. The user will be shown one card,
// and asked if the subsequent card will be greater or lower. If the user is correct,
// another card will show; if incorrect, the round ends, and the cards shown begins
// at 1 again. The user wins if he can guess 5 cards in a row; the user loses if
// he runs out of cards at any point in the game.

import java.util.Scanner;

public class HighLow
{
    private Scanner keyboard;
    private Deck cards;
    private CardHand hand;

    public HighLow()
    {
        keyboard = new Scanner (System.in);
        hand = new CardHand(5);
        cards = new Deck();
        cards.shuffle();
    }

    public static void main (String [] args)
    {
        HighLow game = new HighLow();
        game.welcome();
        game.playRounds();
    }

    //Prints out a welcome message to the user
    public void welcome()
    {
        System.out.print("\n\n\nWelcome to HighLow.java! Press enter to start the game!");
        keyboard.nextLine();
    }

    //Loops the playARound method that plays one round.
    //Also responsible for adding cards and checking if
    //there are cards left, and if the user won or
    // lost
    public void playRounds()
    {
        boolean checker = false;
		
        while(cards.hasNext())
        {
    		hand.addCardtoHand (cards.next());
    		hand.printASCIICardHand ();
	        if (playARound())
	        {
	        	checker = true;
	            break;
	        }

            if (!cards.hasNext())
            {
                System.out.println("Sorry, you ran out of cards!\n\n");
                return;
            }
            else
            {
                System.out.println ("\nSorry, you lost that round. Try Again!");	  
            }
            hand.reset();               	
        }
        if(checker)
            System.out.println("\nCongratulations, you won!\n");
   }

    //Plays 1 round of the game. Prompts the user
    //to ask if the next card is higher or lower,
    //then returns a boolean if the user is
    //correct or not. Also checks if there are any
    //cards left in the deck.
    public boolean playARound()
    {
        for (int i = 0; i < hand.length() - 1; i++)
        {
            String temp = "";
            System.out.println();
            do {
                System.out.print("\nEnter '1' if you think the next card will be higher");
                System.out.print("\nEnter '2' if you think the next card will be lower -> ");
                temp = keyboard.next();
            } while (temp.charAt(0) - 48 != 1 && temp.charAt(0) - 48 != 2);
            temp = temp.substring(0,1);
            int choice = Integer.parseInt(temp);     

            if (!cards.hasNext())
            	return false;
          
            Card next = cards.next();
	        hand.addCardtoHand(next);
	        hand.printASCIICardHand();
	        if (!(hand.getCard(i).compareTo(next) < 0 && choice == 1 || hand.getCard(i).compareTo(next) > 0 && choice == 2))
	            return false;
        }
        return true;
    }
}