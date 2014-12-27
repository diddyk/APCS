
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardHand
{
	private Card [] myhand;
	private int cardindex;
	
	public CardHand(int n)
	{
		myhand = new Card [n];
		cardindex = 0;
	}
	
	public static void main (String [] args)
	{
		Deck cachecreek = new Deck();
		cachecreek.shuffle();
		
		CardHand hand = new CardHand(5);
		
		for (int i = 0; i < 5; i++)
		{
			hand.addCardtoHand(cachecreek.next());
			hand.printASCIICardHand();
		}
	}
	
	public void addCardtoHand(Card c)
	{
		if (cardindex < myhand.length)
		{
			myhand[cardindex] = c;
			cardindex++;
		}
		else
		{
			System.out.println("Sorry, the hand has reached its maximum size, and mo more cards may be added.");
		}
	}
	
	public Card getCard(int i)
	{
		return myhand[i];
	}
	
	public int getcardIndex()
	{
		return cardindex;
	}
	
	public void printASCIICardHand()
	{
		String [] cardpiece = new String [468];
		
		cardpiece = loadCards();
		printCardPictures(cardpiece);
		printCardNames();
	}
	
	public String [] loadCards()
	{
		String line = new String("");
		String [] cardstring = new String [468];
		File file = new File("cards.txt");
		Scanner infile = null;
		try
		{
			infile = new Scanner (file);
		}
		catch (FileNotFoundException e)
		{
			System.out.println ("Error: Unable to find " + file + ".");
		}
		for (int i = 0; i < cardstring.length; i++)
		{
			cardstring[i] = infile.nextLine();
		}
		infile.close();
		return cardstring;
	}
	
	public void printCardPictures(String [] cardpiece)
	{
		System.out.println();
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < cardindex; j++)
			{
				int cardlinenumber = ((myhand[j].getSuit().ordinal()) * 9 * 13) + 
						((myhand[j].getRank().ordinal()) * 9) + i;
				System.out.print(cardpiece[cardlinenumber] + "     ");
			}
			System.out.println();
		}
	}
	
	public void printCardNames()
	{
		System.out.println();
		for (int i = 0; i < cardindex; i++)
		{
			System.out.printf("%-18s",myhand[i]);
		}
		System.out.println();
	}
	
	//returns the length of myhand, or the number of cards in the hand.
	public int length()
	{
		return myhand.length;
	}
	
	//resets a hand, sets number of cards to hand to 0
	public void reset()
	{
		cardindex = 0;
	}
}