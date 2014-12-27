// David Kong		1/20/12
// Assignment.java
// Holds information for assignments, contains accesor, print methods.

import java.io.PrintWriter;

public class Assignment
{
	private String assignment;
	private String category;
	private double possible;
	
	//  Constructor
	public Assignment (String a, String c, double p)
	{
		assignment = a;
		category = c;
		possible = p;
	}
	
	//  Print the Assignment to the command line
	public void print (int i)
	{
		System.out.printf("%-6d%-18s%-26s%7.2f%n",(i+1),category,assignment,possible);
	}
	
	//  Print the Assignment to the given file
	public void fileprint (int i, PrintWriter out)
	{
		out.printf("%-6d %-12s %-26s %7.2f %n",(i+1),category,assignment,possible);
	}
	
	//  Return the Assignment name
	public String getAssignment ( )
	{
		return assignment;
	}
	
	//  Return the category name of the Assignment
	public String getCategory ( )
	{
		return category;
	}
	
	//  Return the possible point total for the Assignment
	public double getPossible ( )
	{
		return possible;
	}
}



