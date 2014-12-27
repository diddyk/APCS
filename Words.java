// David Kong		11/30/11
// Words.java
//
// This program will prompt the user to select a text file, then scan
// the corresponding file. It will then arrange all the words in the
// text file alphabetically, removing any non-words [TODO] or 
// duplicates. It will then print out the frequencies of the words.
// The unique word count and total word count will also be printer
// at the end. 

// TODO 
// [X]1. To Lower case
// [X]2. Get rid of punctuation marks -> . ? , " ! : ; ( )     NOT - ' 
// [X]3. Hyphenated are allowed, such as "run-time"
// [X]4. A word must have at least 1 letter in it																				
//       | |
//       | '-> BUT 19th, @fred, and 2B are words
//	     '-> Not 16, #@!&, and 298!

// magi.txt           
// 'em, 'merry        
// 1-118 the
// 5-36 it
// 30-10 all
// unique words = 760
// total words = 2077
//
// lottery.txt
// 'lottery, 27th, 2th
// 1-226 the
// 5-71 mr
// 30-18 one
// unique words = 828
// total words = 3371
//
// gettysburg.txt
// a above
// 1-13 that
// 5-8 here
// unique words = 138
// total words = 271

//5794, 1162

import java.util.*;
import java.io.*;

public class Words
{
	private ArrayList <WordCount> words;
	private ArrayList<String> word;
	private ArrayList<String> list;
	private File file;
	private char [] array;
	private int counter;
	
	public Words()		//constructor
	{
		words = new ArrayList <WordCount>();
		word = new ArrayList <String>();
		list = new ArrayList <String>();
		array = new char [30];
		file = new File("lottery.txt");
		counter = 0;
	}
	
	public static void main (String [] args)
	{
		//System.out.print(5995 - 5794);
		Words paragraph = new Words();
		paragraph.prompt();
		paragraph.order();
		paragraph.print();
		paragraph.calculateFrequency();
		paragraph.printFrequency();
	}
	
	//prompts the user for a selection
	public void prompt()
	{
		Scanner keyboard = new Scanner (System.in);
		System.out.print("\n\nEnter a text file to be scanned -> ");
		String temp = keyboard.next();
		file = new File (temp + ".txt");

		Scanner in = null;
		try 
		{
			in = new Scanner(file);
		}
		catch (FileNotFoundException e)
		{
			System.out.println ("\nError: Unable to find " + file + ".");
			System.out.print("\n\n");
			System.exit(1);
		}
		in.useDelimiter("(--)|\\s");
		
		//scans in words
		while (in.hasNext())
		{
			String aline = in.next();
			aline = remove(aline);
			addToArray(aline);
		}
	}
	
	//adds a single word to the array
	public void addToArray (String s)
	{
		word.add (s);
	}
	
	//prints out the arraylist in alphabetical order
	public void print()
	{
		int counter = 0;
	
		for (int i = 0; i < word.size(); i++)
			list.add (word.get(i));

		for (int i = 0; i < word.size() - 1; i++)
			for (int j = 0; j < word.size() - 1; j++)
				if (word.get(j).equals(word.get(j + 1)))
					word.remove(j);
		
		for (int i = 1; i < word.size(); i++)
		{
			if (counter > 220)
			{
				counter = 0;
				System.out.println();
			}
			System.out.print (word.get(i) + " ");
			counter += (word.get(i).length() + 1);
		}
		System.out.println ("\n\n");
	}
	
	//removes extra spaces, non-words, and extra punctuation
	public String remove(String s)
	{
		boolean isword = false;
		for (int i = 0; i < s.length(); i++)
		{
			if ((int)s.charAt(i) < 97 || (int)s.charAt(i) > 122)
				isword = false;
			else
			{
				isword = true;
				i = s.length();
			}
		}
		if (!isword)
		{
			for (int i = 0; i < s.length(); i++)
				array[i] = s.charAt(i);
			for (int j = 0; j < s.length(); j++)
				s = s.replace (array[j], ' ');
		}
		if (s.length() == 1)
		{
			if ((int)s.charAt(0) < 97 || (int)s.charAt(0) > 122)
			{
				char temp1 = s.charAt(0);
				s = s.replace (temp1, ' ');
			}
		}
		s = removePunctuation(s);
		return s;
	}
	
	//removes extra punctuation
	public String removePunctuation(String s)
	{
		s = s.replace('.', ' ');
		s = s.replace('?', ' ');
		s = s.replace(',', ' ');
		s = s.replace('"', ' ');
		s = s.replace('!', ' ');
		s = s.replace(':', ' ');
		s = s.replace(';', ' ');
		s = s.replace('(', ' ');
		s = s.replace(')', ' ');
		s = s.replaceAll(" ", "");
		s = s.toLowerCase();
		s = s.trim();
		return s;
	}
	
	//Orders the ArrayList alphabetically
	public void order()
	{
		for (int outer = 0; outer < word.size() - 1; outer++)
		{
			for (int inner = 0; inner < word.size()-outer-1; inner++)
			{
				if ((word.get(inner).compareTo (word.get(inner + 1))) > 0)
				{
					String temp = word.get(inner);
					word.set(inner, word.get(inner + 1));
					word.set(inner + 1, temp);
				}
			}
		}
	}
	
	//Calculates the number of occurences per unique word
	public void calculateFrequency()
	{
		int temp3 = 201;
		int [] count = new int [word.size()];
		int timer = 0;
		
		for (int i = 0; i < count.length; i++)
			count[i]++;
		
		for (int i = 0; i < list.size() - 1; i++)
			if (list.get(i).equals(list.get(i + 1)))
				count[timer]++;
			else
				timer++;
				
		counter = list.size();
		counter = counter - temp3;
		
		for (int i = 1; i < word.size(); i++)
		{
			WordCount ward = new WordCount(" ", 0);
			ward.setWord(word.get(i));
			words.add (new WordCount (ward.getWord(), count[i]));
		}
		
		for (int outer = 0; outer < words.size() - 1; outer++)
		{
			for (int inner = 0; inner < words.size()-outer-1; inner++)
			{
				if (words.get(inner).getCount() < words.get(inner + 1).getCount())
				{
					WordCount temp = words.get(inner);
					words.set(inner, words.get(inner + 1));
					words.set(inner + 1, temp);
				}
			}
		}
	}
	
	//Prints out the frequencies of unique words, and the
	//total and unique word count
	public void printFrequency()
	{
		System.out.println("-----------------------------------------------------------\n");
		for (int i = 0; i < 30; i++)
		{
			System.out.printf ("%-4d %-13s %-4d \n", (i + 1), words.get(i).getWord(),words.get(i).getCount());
			if (i % 5 == 4)
				System.out.println();
		}	
		System.out.println("TOTAL NUMBER OF WORDS: " + counter);
		System.out.println("TOTAL NUMBER OF UNIQUE WORDS: " + (word.size() + 1));
		System.out.println("\n\n");
	}
}