// David Kong		1/18/12
// Squeeze.java
// This program reads in a text file at "Squeeze.txt"
// It then determines the number of spaces, not tabs,
// at the front of each line. It then modifies the
// original text file by removing the spaces at the
// beginning, and printing a number representing the
// number of spaces that were there.

import java.io.*;
import java.util.*;

public class Squeeze
{
	//instance variables
	private Scanner in;
	private File filename;
	private ArrayList<String> list;
	
	public Squeeze()	//constructor
	{
		Scanner in = null;
		filename = new File ("sq.txt");
		list = new ArrayList<String>();
	}
	
	public static void main (String [] args)
	{
		Squeeze sqz = new Squeeze();
		sqz.openFile();
		sqz.writeFile();
		System.out.println("\n\n\n");
		System.out.println("File successfully squeezed");
		System.out.println("\n\n\n");
	}
	
	//Opens the file, algorithm for removing spaces + adding a number
	//for number of spaces, saves each line into a string ArrayList
	public void openFile()
	{
		try 
		{
			in = new Scanner(filename);
		}
		catch (FileNotFoundException e)
		{
			System.out.println ("\nError: Unable to find m.txt!");
			System.out.print("\n\n");
			System.exit(1);
		}
		int spacenum = 0;
		while (in.hasNext())
		{
			String aline = in.nextLine();
			int counter = 0;
			for (int i = 0; i < aline.length(); i++)
			{
				char temp = aline.charAt(i);
				if (temp != ' ')
					break;
				else if (temp == ' ')
					spacenum++;
				counter++;
			}
			aline = aline.substring(counter);		
			aline = spacenum + "  " + aline;
			spacenum = 0;
			list.add(aline);
		}
		in.close();
	}
	
	//Re-opens the original text file, uses Strings from the ArrayList
	//and prints it out into the original text file.
	public void writeFile()
	{
		try
		{
			PrintWriter out = new PrintWriter(filename);
			for (int i = 0; i < list.size(); i++)
			{
				out.println(list.get(i));
			}
			out.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}