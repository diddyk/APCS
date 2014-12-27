// David Kong		10/12/11
// Stats.java
// This program will read in a list of ints from "numbers.txt", 
// then store the values in an array. It will then find the average,
// standard deviation, and mode of the set of numbers. It will
// then print out those values.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Stats
{
	//instance variables
	private int amount, mode;
	private double average, sd;
	
	//constructor
	public Stats()
	{	
		amount = mode = 0;
		average = sd = 0.0;
	}
	
	public static void main (String [] args)
	{
		Stats calculate = new Stats();
		calculate.readFromFile();
	} 
	
	// Reads in the ints from numbers.txt, thens stores them into an array
	public void readFromFile()
	{
		Scanner fromfile = null;
		File afile = new File("numbers.txt");
		int num = 0;
		int c = 0;
		int [] numbers = new int [1000];
		
		try
		{
			fromfile = new Scanner(afile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\nFile not found!\n");
			System.exit(1);
		}
		while(fromfile.hasNext())			
		{	
			num = fromfile.nextInt();	
			numbers[c] = num;		
			c++;
		}
		amount = c;						//stores the number of values into "amount"
		calculateAverage(numbers);
		calculateSD(numbers);
		calculateMode(numbers);
		printNumbers();
	}
	
	// Calculates the average of the numbers
	public void calculateAverage (int [] nums)
	{
		double sum = 0.0;
		
		for (int i = 0; i < amount; i++)	//use "amount" opposed to array length
		{
			sum += nums[i];
		}	
		average = sum/amount;		
	}
	
	// Calculates the standard deviation of the numbers
	public void calculateSD (int [] nums)
	{
		double total = 0.0;
		
		for (int i = 0; i < amount; i++)		//use "amount" opposed to array length
		{
			total += Math.pow(nums[i] - average, 2);
		}
		total = total / (amount - 1);
		sd = Math.sqrt(total);
	}
	
	// Calculates the mode of the numbers
	public void calculateMode(int [] nums)
	{
		int count1 = 0;
		int count2 = 0;
		
		for (int i = 0; i < 101; i++)
		{
			count2 = 0;					//reassign counter to 0 to reset when tallying
			for (int j = 0; j < amount; j++)
			{
				if (nums[j] == i)
					count2++;
				if (count2 >= count1)
				{
					count1 = count2;
					mode = i;
				}
			}
		}	
	}
	
	// Prints out the values of the average, standard deviation, and mode
	public void printNumbers()
	{
		System.out.printf("\n\nAverage: %5.2f", average);
		System.out.printf("\nStandrad Deviation: %5.2f", sd);
		System.out.print("\nMode: " + mode);
		System.out.print("\n\n\n");
	}
}