// David Kong		1/20/12
// Category.java
// Contains contents for one category; contains accesor, print methods.

import java.io.PrintWriter;

public class Category
{
	private String name;
	private double weight;
	
	//  Constructor
	public Category (String n, double w)
	{
		name = n;
		weight = w;
	}
	
	//  Print the Category to the command line
	public void print ( )
	{
		System.out.printf("%-15s%7.2f%n",name,weight);
	}
	
	//  Print the Category to the given file
	public void fileprint (PrintWriter out)
	{
		out.printf("%-12s%7.2f%n",name,weight);
	}
	
	//  Return the name of the Category
	public String getName ( )
	{
		return name;
	}
	
	//  Return the weight for the Category
	public double getWeight ( )
	{
		return weight;
	}
}