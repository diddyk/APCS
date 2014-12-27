public class Card implements Comparable
{
	private final Suit suit;
	private final Rank rank;
	
	public Card (Rank r, Suit s)
	{
		rank = r;
		suit = s;	
	}
	
	public int compareTo(Object obj)
	{
		Card other = (Card)obj;
		return(rank.ordinal() - other.getRank().ordinal());
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public Rank getRank()
	{
		return rank;
	}
	
	public String toString()
	{
		return rank + " of " + suit;
	}
	
	
}
				