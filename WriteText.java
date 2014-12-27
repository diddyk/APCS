import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteText
{
	public static void main (String [] args)
	{
		try
		{
			File outFile = new File("myoutput.txt");
			PrintWriter out = new PrintWriter(outFile);
		
			// Write text to file
			out.println("This is line 1");
			out.println("This is line 2");
			out.print("This is line3 part 1, ");
			out.println("this is line 3 part 2");
			out.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}