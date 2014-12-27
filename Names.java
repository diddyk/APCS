// David Kong
// 8/25/11
// Names.java
// This program will display the popularity of a user-inputted name 
// during 1900-2000, and display the popularity trend over a graph.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Names
{
	// Instance Variables
	private File afile;						
	private String name;
	private int [] numbers;
	private boolean found;
	
	// Constructor
	public Names()							
	{
		afile = new File("names.txt");	
		name = "";
		numbers = new int [11];	
		found = false;
	}
	
	public static void main (String [] args)
	{
		Names name = new Names();	
		name.findName();					
		name.drawGraph();					
	}
	
	// Asks the user for a name, then scans "names.txt" for the inputted name, ignoring case
	// Once the name is found, the ranking numbers are stored in the int array "numbers"
	public void findName()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\n\nPlease enter the name you're searching for : ");		
		name = keyboard.nextLine();
		
		Scanner fromfile = null;
		String aline;
		
		System.out.print("\n");
		try												
		{
			fromfile = new Scanner(afile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\nFile not found!\n");	//if file not found
			System.exit(1);
		}
		
		while(fromfile.hasNext())			
		{
			aline = fromfile.next();
			if (aline.equalsIgnoreCase(name))			//ignores case when searching
			{
				name = aline;
				for (int i = 0; i < numbers.length; i++)
				{
					int temp = fromfile.nextInt();
					numbers[i] = temp;
				}
				found = true;							
				break;									
			}		
		}
	}
	
	// Draws the graph displaying the ranks. The corresponding ranking number will
	// be printed in the corresponding space. Otherwise, blank spaces will be printed.
	// If a name was not found, a graph is not printed.
	public void drawGraph()
	{
		if (found == true)												
		{
			System.out.print("\n");
			System.out.printf("%10s" ,"");								
			for (int years = 1900; years < 2010 ; years+=10)				
				System.out.printf("%10d", years);						
			
			System.out.print("\n\n");
			
			for (int rank = 20; rank < 1020 ; rank+=20)
			{
				System.out.printf("%10d",rank);							
				for (int i = 0; i < numbers.length; i++)
				{
					if(numbers[i] <= rank && numbers[i] > rank - 20)	//prints rank # in corresponding "slot"
						System.out.printf("%10d",numbers[i]);
					else
						System.out.printf("%10s" ,"");					//else, print blank spaces
				}
				System.out.print("\n");
			}
		}
		else															//else, name not found
		{
			System.out.print("Name not found!");
		}
		System.out.print("\n\n");
	}
}