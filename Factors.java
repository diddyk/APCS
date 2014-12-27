//  David Kong        8/29/11
//  Factors.java
//  This program will first prompt the user for the start number in a range from 2-100.
//  It will then prompt the user for the ending number, in a range from the minimum number to 999.
//  The program will then print out all the prime factorizations of all the numbers
//  within the range. After printing out the prime factorization of the ending
//  number, the program ends.

public class Factors
{
	private int start, end;

	//  Constructor
	public Factors()
	{
		start = end = 0;
	}

	public static void main (String [] args)
	{
		Factors findfactors = new Factors();
		findfactors.getRange();
		findfactors.listPrimeFactorizations();
	}

	//  Prompt the user for input.  Save the input with the
	//  appropriate variables.
	public void getRange ( )
	{	
		start = Prompt.getValue("\n\nPlease enter a starting integer, ", 2, 100);
		end = Prompt.getValue("\nPlease enter an ending integer, ", start, 999);
		System.out.print("\n\n");
	}

	//  List the integers, form start to end.  Show the
	//  prime factorization for each integer in the list.
	//  Call printFactorization for each integer in the list.
	public void listPrimeFactorizations ( )
	{
		while (start <= end)				//exits loop after hitting the max. number
		{
			printFactorization(start);
			start++;
		}
		System.out.print("\n");
	}
	
	//  Print the prime factorization for the positive
	//  integer passed in the parameter list.
	public void printFactorization (int num)
	{	
		int c = 2;							//sets counter to 2
		System.out.print(num + " = ");		//prints out equal sign
		while (c < num)
		{
			if (num % c == 0)				//if a factor, print out the factor, divide, and reset the counter
			{
				System.out.print(c + " * ");
				num /= c;
				c = 2;
			}
			else
				c++;						//if not a factor, increment counter
		}
		System.out.println(c + "\n");
	}
}