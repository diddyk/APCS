//WordCount.java

public class WordCount 
{
	private String word;
	private int count;
	
	public WordCount(String w, int c)
	{
		word = w;
		count = c;
	}
	public void setWord(String w)
	{
		word = w;
	}
	
	public void setCount(int c)
	{
		count = c;	
	}
	
	public String getWord()
	{
		return word;
	}
	
	public int getCount()
	{
		return count;
	}
}