import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class Hail
{
	private File outname;
	private PrintWriter out;
	private int number, counter;

	public Hail ( )
	{
		outname = new File("hail.txt");
		out = null;
		number = counter = 0;
	}

	public static void main (String [] args)
	{
		Hail runit = new Hail();
		runit.GetNumber();
		runit.PrintSequence();
	}
	
	public void GetNumber ( )
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print("\n\nEnter a positive integer ( 1 - 10000 ) :   ");
		number = keyboard.nextInt();
		System.out.println("\n");
	}

	public void PrintSequence ( )
	{
		try
		{
			out = new PrintWriter(outname);
		} 
		catch (IOException e)
		{
			System.out.println("Cannot create file to be written to.");
			System.exit(1);
		}

		out.println();
		if (number > 0 && number <= 10000)
		{
			while (number != 1)
			{
				System.out.printf("%7d", number);
				out.printf("%7d", number);
				counter++;
				if (number % 2 == 0)
					number /= 2;
				else
					number = number * 3 + 1;
				if (counter % 10 == 0)
				{
					System.out.println("\n");
					out.println();
					out.println();
				}
			}
			System.out.printf("%7d", number);
			out.printf("%7d", number);
		}
		PrintCount(out);
		out.close();
	}

	public void PrintCount (PrintWriter t)
	{
		System.out.println("\n\nThe loop executed " + (counter+1) + " times\n\n\n");
		t.println();
		t.println();
		t.println("The loop executed " + (counter+1) + " times");
		t.println();
		t.println();
	}
}