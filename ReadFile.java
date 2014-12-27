// David Kong
// 8/25/11
// ReadFile.java
//

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile
{
	private File afile;
	
	public ReadFile()
	{
		afile = new File("text.txt");		
	}
	
	public static void main (String [] args)
	{
		ReadFile myfile = new ReadFile();
		
		myfile.openAndPrint();
	}
	
	public void openAndPrint()
	{
		Scanner fromfile = null;
		String aline;
		
		try
		{
			fromfile = new Scanner(afile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\nFile not found!\n");
			System.exit(1);
		}
		System.out.print("\n\n");
		while(fromfile.hasNext())			//if next element, enter loop. if not, exit
		{
			aline = fromfile.nextLine();
			System.out.println(aline);	
		}
		System.out.print("\n\n");
	}
}