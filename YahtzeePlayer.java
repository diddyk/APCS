// David Kong		9/26/11
// YahtzeePlayer.java
// Handles many functions involving objects, including
// the players and scorecard.

public class YahtzeePlayer
{
	private int [] scoreArray;
	private String name;
	private int totalScore;
	
	public YahtzeePlayer()				//constructor
	{
		totalScore = 0;
		name = new String("Steve Jobs");
		scoreArray = new int [13];
		for (int i = 0; i <scoreArray.length; i++)
		{
			scoreArray[i] = -1;
		}
	}
	
	// Sets name for the players
	public void setName(String n)
	{
		name = new String(n);
	}
	
	// Retrieves names for the players
	public String getName()
	{
		return name;
	}
	
	// Sets values in the array of scores
	public void setScoreArrayElement (int i, int value)
	{
		scoreArray[i] = value;
	}
	
	// Gets value of a category in the array of scores
	public int getScoreArrayElement(int i)
	{
		return scoreArray[i];
	}
	
	// Calculates the total score of the two players
	public int calculateScore()
	{
		for (int i = 0; i < scoreArray.length; i++)
		{
			totalScore += scoreArray[i];
		} 
		return totalScore ;	
	}
}