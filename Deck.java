import java.util.Iterator;

public class Deck implements Iterator
{
	private Card [] deck;
	private int cardsUsed;
	
	public Deck ()
	{
		deck = new Card [52];
		int counter = 0;
		cardsUsed = 0;
		
		//for-each loop
		for (Suit s : Suit.values())
		{
			for (Rank r : Rank.values())
			{
				deck[counter] = new Card(r,s);
				counter++;
			}
		}
	}
	
	public static void main (String [] args)
	{
		Deck d = new Deck();
		d.shuffle();
		for (int i = 0; i < 52; i++)
		{
			System.out.println(d.deck[i]);	
		}	
	}
	
	public void shuffle()
	{
		for (int i = deck.length - 1; i > 0; i--)
		{
			int rand = (int)(Math.random() * (i + 1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck [rand] = temp;
		}
	}
	
	public boolean hasNext()
	{
		if (cardsUsed >= deck.length)
			return false;	
		return true;
	}
	
	public Card next()
	{
		if (!hasNext())
		{
			throw new IllegalStateException("No cards left in the deck!");
		}
		cardsUsed++;
		return deck[cardsUsed - 1];			
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}