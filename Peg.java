// David Kong			10/20/11
// Peg.java 
// Manages operations involving one peg like setting
// and returning a specific peg value

public class Peg
{
	private char letter;  //instance variables

	public Peg() //constructor
	{
		letter = 'X';
	}
	
	public Peg (char let)  //assigns letter
	{
		letter = let;
	}
	
	public char getLetter()  //returns letter
	{
		return letter;
	}
	
	public void putLetter(char let) //takes in letter
	{
		if (let >= 'A' && let <= 'F')
		{
			letter = let;
		}
		else
		{
			letter = 'X';
		}
	}
}