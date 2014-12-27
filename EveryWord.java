// David Kong		9/7/11
// EveryWord.java
// Prompt the user to enter a String of letters, no spaces, from 3 characters to 7 characters long.
// Find all possible permutations from length 3 to 7 characters for the letters in the given String.
// Save these permutations in an array. Open a text file of English words and find all matches  for
// the given array of permutations. Save these matches in another array. Print the resulting list
// of English word matches to the terminal window.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EveryWord
{
	private File afile;
	private String letters;
	private String [] possible;
	private String [] match;
	private int totalmatches;
	
	public EveryWord ( )
	{
		afile = new File("words.txt");
		letters = new String("");
		totalmatches = 0;
		possible = new String[13650];
		match = new String [200];
		
		for (int i = 0; i < possible.length; i++)
		{
			possible[i] = new String("-------");
		}
		
		for (int i = 0; i < match.length; i++)
		{
			match[i] = new String("-------");
		}
	}
	
	public static void main (String [] args)
	{
		EveryWord word = new EveryWord();		
		word.getLetters();
		word.createPermutations();
		//word.printPermutations();
		word.openAndFindMatches();
		word.printMatches();
	}
	
	public void getLetters ()
	{
		letters = Prompt.getString("\n\n\nPlease enter a String of letters, no spaces ",3,7);	
		letters = letters.toLowerCase();	
	}
	public void createPermutations ()
	{
		System.out.println("\n\n\nCreating All Permuations . . .\n");
		int counter = 0;
		for (int i = 0; i < 7 && i < letters.length(); i++)
		{
			String word = new String("");
			word += letters.charAt(i);
			for (int j = 0; j < 7 && j < letters.length(); j++)
			{
				if (i != j)
				{
					word += letters.charAt(j);
					for (int k = 0; k < 7 && k < letters.length(); k++)
					{
						if (i != k && j != k)
						{
							word += letters.charAt(k);
							possible[counter] = word;
							counter++;
							for (int m = 0; m < 7 && m < letters.length(); m++)
							{
								if (i != m && j != m && k != m)
								{
									word += letters.charAt(m);
									possible[counter] = word;
									counter++;
									for (int n = 0; n < 7 && n < letters.length(); n++)
									{
										if (i != n && j != n && k != n && m != n)
										{
											word += letters.charAt(n);
											possible[counter] = word;
											counter++;
											for (int p = 0; p < 7 && p < letters.length(); p++)
											{
												if (i != p && j != p && k != p && m != p && n != p)
												{
													word += letters.charAt(p);
													possible[counter] = word;
													counter++;
													for (int q = 0; q < 7 && q < letters.length(); q++)
													{
														if (i != q && j != q && k != q && m != q && n != q && p != q)
														{
															word += letters.charAt(q);
															possible[counter] = word;
															counter++;
															//System.out.println(counter);
															word = word.substring(0,6);
														}
													}
													word = word.substring(0,5);
												}
											}
											word = word.substring(0,4);
										}
									}
									word = word.substring(0,3);
								}
							}
							word = word.substring(0,2);
						}
					}
					word = word.substring(0,1);
				}
			}
		}

	}
	public void printPermutations ()
	{
		System.out.print("\n\nPrinting all permutations . . ."); 
		for (int i = 0; i < possible.length; i++)
		{
			if (i % 8 == 0)
				System.out.print("\n");
			System.out.printf("%9s", possible[i]);
		}
		System.out.print("\n\n");
	}
	public void openAndFindMatches ()
	{
		Scanner fromfile = null;
		String aline = null;
		int count = 0;
		try
		{
			fromfile = new Scanner(afile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n\nFile Not Found.\n\n");
			System.exit(1);
		}
		
		while (fromfile.hasNext())
		{
			aline = fromfile.nextLine().toLowerCase();
			count++;
			if (count % 10000 == 0)
				System.out.printf("\nReading from the text file, at line %7d of 172774 lines", count);
			for (int i = 0; i < possible.length; i++)
			{
				if(aline.equals(possible[i]))
				{
					match[totalmatches] = possible[i];
					totalmatches++;
					i = possible.length;
				}
			}		
		}
		System.out.print("\n\n\n\n");
	}
	public void printMatches ()
	{
		System.out.print("\n\nPrinting all matches . . .\n"); 
		for (int i = 0; i < totalmatches; i++)
		{
			if (i % 8 == 0)
				System.out.print("\n");
			System.out.printf("%9s", match[i]);
		}
		System.out.print("\n\n");		
	}
}