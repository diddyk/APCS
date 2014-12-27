// David Kong		1/20/12
// Pupil.java
// Holds the information of one student. Loads scores into an array,
// also able to print out to a screen. Also calculates the weighted
// average of the student.

import java.util.ArrayList;
import java.io.PrintWriter;

public class Pupil
{
	private String firstname, lastname;
	private ArrayList<Double> score;
	
	//  Constructor
	public Pupil (String f, String l)
	{
		firstname = f;
		lastname = l;
		score = new ArrayList<Double>();
	}
	
	//  Load a score into the ArrayList of Double (score)
	public void loadScore (double value)
	{
		score.add(value);
	}
	
	//  Print the Student to the command line
	public void print (int index)
	{
		System.out.printf("%-6d%-12s%-14s",(index+1),firstname,lastname);
		for (int i = 0; i < score.size(); i++)
		{
			System.out.printf("%7.2f",(double)score.get(i));
		}
		System.out.println();
	}
	// Second print method for printing WITH the average score.
	public void print2 (int index, Category [] c, ArrayList<Assignment> a)
	{
		System.out.printf("%-6d%-12s%-14s",(index+1),firstname,lastname);
		double average = (percentGrade(c, a));
		System.out.printf("%.2f", average);
		for (int i = 0; i < score.size(); i++)
		{
			System.out.printf("%7.2f",(double)score.get(i));
		}
		System.out.println();
	}
	
	//  Print the Student to the given file
	public void fileprint (int index, PrintWriter out)
	{
		out.printf("%-6d%-12s%-14s",(index+1),firstname,lastname);
		for (int i = 0; i < score.size(); i++)
		{
			out.printf("%7.2f",(double)score.get(i));
		}
		out.println();
	}
	
	//  Remove a score from the ArrayList of Double (score)
	public void removeScore (int i)
	{
		score.remove(i);
	}
	
	//  Return the last name of the Student (for sorting)
	public String getLast ( )
	{
		return lastname;
	}
	
	public void changeScore(int location, double value)
	{
		score.remove(location);
		score.add(location, value);
	}
	
	//  Return the weighted percent grade for the Student (for sorting
	//  and display)  This one is tough!
	public double percentGrade (Category [] c, ArrayList<Assignment> a)
	{
		double weight = 0.0;
		double multiplier = 1.0;
		double totalMissing = 0.0;
		for (int k = 0; k < c.length; k++)
		{
			int count = 0;
			for(int b = 0; b < a.size(); b++)
			{
				if(c[k].getName().equals(a.get(b).getCategory()))
				{
					count++;
				}		
			}
			if(count == 0)
			{
				totalMissing+= c[k].getWeight();	
			}			
		}
		multiplier = 100.0/(100-totalMissing);
		for(int i = 0; i < c.length; i++)
		{
			double thisCatScore = 0.0;
			double thisCatMax = 0.0;
			for(int j = 0; j < a.size(); j++)
			{
				if(a.get(j).getCategory().equals(c[i].getName()))
				{
					thisCatScore += score.get(j);
					thisCatMax += a.get(j).getPossible();
				}
			}
			if(thisCatMax!= 0.0)
				weight = weight + c[i].getWeight()*thisCatScore*multiplier/thisCatMax;
		}
		return weight;
	}
}
