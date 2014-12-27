// David Kong	1/20/12
// Grades.java
// TODO:
// 1) Enter name of text file to process
// 2) Spit data to screen
// 3) Prompt User with 10 options
//	[X] Display All
//	[X] Sort students by last name
//	[X] Sort students by grade rank
//	[X]* Show a Student, with grade summary
//	[X]* Add a student, enter scores
//	[X] Delete a student
//	[X]* Add an assignment
//	[X]* Delete an assignment
//	[X]* Change an assignment
//	[X] Save to file/exit
//  KNOWN PROBLEMS:
//  0Print out percent averages for option 3

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class Grades
{
	//instance variables
	private Category [] catlist;
	private ArrayList<Assignment> assignlist;
	private ArrayList<Pupil> studentlist;
	private Scanner keyboard;
	
	//  Constructor
	public Grades ( )
	{
		assignlist = new ArrayList<Assignment>();
		studentlist = new ArrayList<Pupil>();
		keyboard = new Scanner(System.in);
	}
	
	//  Main method.  Opens a file, runs processes on the grades file, then saves and exits
	public static void main (String [] args)
	{
		Grades run = new Grades();
		run.openAndReadFile();
		run.makeChoices();
		run.saveAndExit();
	}
	
	//  Open and read the grades file
	public void openAndReadFile ( )
	{
		String filename;
		File afile;
		Scanner keyboard = new Scanner(System.in);
		Scanner fromfile = null;
		
		System.out.println("\n\n\n+-------------------------------------------------------+");
		System.out.println("|             Welcome to the GRADES program.            |");
		System.out.println("+-------------------------------------------------------+");
		System.out.print("\nPlease enter the name of the grades file you would like to process: ");
		filename = keyboard.nextLine();
		
		try
		{
			afile = new File(filename);
			fromfile = new Scanner(afile);
		}
		catch (FileNotFoundException exc)
		{
			System.out.println("\n\nI'm sorry, but I can't find that file.\n" +
									"Please run the program again, using a valid grade file.\n\n");
			System.exit(1);
		}
		
		readCategories(fromfile);
		readAssignments(fromfile);
		readStudents(fromfile);
		printAll();
	}
	
	//  Read the Categories at the top of the file
	public void readCategories (Scanner file)
	{
		int catsize = file.nextInt();
		catlist = new Category[catsize];
		
		for (int i = 0; i < catlist.length; i++)
		{
			String name = file.next();
			double weight = file.nextDouble();
			catlist[i] = new Category(name,weight);
		}
	}
	
	//  Read the Assignments listed in the file
	public void readAssignments (Scanner file)
	{
		int assignsize = file.nextInt();
		
		for (int i = 0; i < assignsize; i++)
		{
			int value = file.nextInt();
			String category = file.next();
			String name = file.next();
			double possible = file.nextDouble();
			assignlist.add(new Assignment(name,category,possible));
		}
	}
	
	//  Read the Students listed in the file
	public void readStudents (Scanner file)
	{
		int studentsize = file.nextInt();
		
		for (int i = 0; i < studentsize; i++)
		{
			int value = file.nextInt();
			String firstname = file.next();
			String lastname = file.next();
			studentlist.add(new Pupil(firstname,lastname));
			
			for (int j = 0; j < assignlist.size(); j++)
			{
				double score = file.nextDouble();
				studentlist.get(i).loadScore(score);
			}
		}
		file.close();
	}
	
	//  Print all information to the command line
	public void printAll ( )
	{
		printCategories();
		printAssignments();
		printStudents();
	}
	
	//  Print the Categories to the command line
	public void printCategories ()
	{
		System.out.println("\n\n" + catlist.length);
		for (int i = 0; i < catlist.length; i++)
		{
			catlist[i].print();
		}
	}
	
	//  Print the Assignments to the command line
	public void printAssignments ()
	{
		System.out.println("\n" + assignlist.size());
		for (int i = 0; i < assignlist.size(); i++)
		{
			assignlist.get(i).print(i);
		}
	}
	
	//  Print the Students to the command line
	public void printStudents ( )
	{
		System.out.println("\n" + studentlist.size());
		for (int i = 0; i < studentlist.size(); i++)
		{
				studentlist.get(i).print(i);
		}
	}
	
	// Prints the Students to the command line, as well as their average
	public void printStudents2 ( )
	{
		System.out.println("\n" + studentlist.size());
		for (int i = 0; i < studentlist.size(); i++)
		{

				studentlist.get(i).print2(i,catlist, assignlist);
				
				//		System.out.printf("\nThe student's weighted average is: %.2f", studentlist.get(i-1).percentGrade(catlist, assignlist));

		}
	}
	
	//  Make a choice from the menu, until '0' is chosen to exit program run
	public void makeChoices ( )
	{
		char input;
		do
		{
			input = '0';
			System.out.println("\n");
			showMenu();
			System.out.print("\nPlease enter a choice from the menu above -> ");
			do
			{
				if (input < '0' || input > '9')
				{
					System.out.print("Bad input, please try again: ");
				}
				input = keyboard.next().charAt(0);
			}
			while (input < '0' || input > '9');
			executeRequest(input);
		}
		while (input != '0');
	}
	
	//  Menu to be printed to command line
	public void showMenu ( )
	{
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|  (1) Display All                                      |");
		System.out.println("|  (2) Sort Students by last name, display Students     |");
		System.out.println("|  (3) Sort Students by grade rank, display Students    |");
		System.out.println("|  (4) Show a Student, with grade summary               |");
		System.out.println("|  (5) Add a Student and enter scores                   |");
		System.out.println("|  (6) Delete a Student (and all related scores)        |");
		System.out.println("|  (7) Add an Assignment and enter scores               |");
		System.out.println("|  (8) Delete an Assignment (and all related scores)    |");
		System.out.println("|  (9) Change an Assignment score for a single Student  |");
		System.out.println("|  (0) Save to a file and Exit                          |");
		System.out.println("+-------------------------------------------------------+");
	}
	
	//  Execute the process chosen by the user
	public void executeRequest (char input)
	{
		switch (input)
		{
			case '1': printAll();           break;
			case '2': sortByLastName();     break;
			case '3': sortByGrade();        break;
			case '4': showStudent();        break;
			case '5': addStudent();         break;
			case '6': deleteStudent();      break;
			case '7': addAssignment();      break;
			case '8': deleteAssignment();   break;
			case '9': changeSingleScore();  break;
			case '0': default:              break;
		}
	}
		
	//  Sort the studentlist by last name, then print the studentlist to the command line
	public void sortByLastName ( )
	{
		for (int i = 0; i < studentlist.size() - 1; i++)
		{
			for (int j = 0; j < studentlist.size()-i-1; j++)
			{
     			if (studentlist.get(j).getLast().compareTo(studentlist.get(j + 1).getLast()) > 0)
     			{
	       			//swap list[inner] & list[inner+1]
	       			Pupil temp = studentlist.get(j);
	       			studentlist.set(j, studentlist.get(j + 1));
	       			studentlist.set(j + 1, temp);
     			}
			}
 		 }
 		 printStudents();
	}
	
	//  Sort the studentlist by overall grade, then print the studentlist to the command line
	public void sortByGrade ( )
	{
		for (int outer = 0; outer < studentlist.size() - 1; outer++)
		{
    	   for (int inner = 0; inner < studentlist.size()-outer-1; inner++)
    	   {
			 if (studentlist.get(inner).percentGrade(catlist, assignlist)<(studentlist.get(inner + 1).percentGrade(catlist,assignlist)))	//swap list[inner] & list[inner+1]
			 {
				Pupil temp = studentlist.get(inner);
				studentlist.set(inner, studentlist.get(inner + 1));
				studentlist.set(inner + 1, temp);
			 }
		   }
		}
		
			printStudents2();
			//studentlist.get(i).print(i);
			//System.out.print(studentlist.get(i).percentGrade(catlist, assignlist) + "%");
		
	}
	
	//  Prompt the user for an integer value, 1 to studentlist size, then print the corresponding Student in the list
	public void showStudent ( )
	{
		int i = 0;
		do
		{
			System.out.print("Please enter a student number -> ");
			i = keyboard.nextInt();
		}while(i > studentlist.size() || i < 1);
		System.out.println();
		studentlist.get(i-1).print(i-1);
		System.out.printf("\nThe student's weighted average is: %.2f", studentlist.get(i-1).percentGrade(catlist, assignlist));
	}
	
	//  Prompt the user for first name, last name, and scores, then add the new Student to the end of the studentlist
	public void addStudent ( )
	{
		System.out.print("Please enter the first name of the student you would like to add -> ");
		String first = keyboard.next();
		System.out.print("Please enter the last name of the student you would like to add -> ");
		String last = keyboard.next();
		System.out.println("\n");
		Pupil temp = new Pupil(first, last);
		for (int i = 0; i< assignlist.size(); i++)
		{
			assignlist.get(i).print(i);
			System.out.println();
			System.out.print("Student score for this assignment -> ");
			double score = keyboard.nextDouble();
			temp.loadScore(score);
			System.out.println();
		}
		studentlist.add(temp);
		System.out.println("This student has been added to the end of studentlist");
	}
	
	//  Prompt the user for an integer value, 1 to studentlist size, then delete the corresponding Student from the studentlist
	public void deleteStudent ( )
	{
		System.out.print("Please enter the number of the student to be removed -> ");
		int studentnumber = keyboard.nextInt();
		studentnumber--;
		
		studentlist.remove(studentnumber);
		
		System.out.println("Student " + (studentnumber + 1) + " has been deleted!");
		
	}
	
	//  Prompt the user for Assignment category, Assignment name, and possible point total, then add the new Assignment to the end of the assignlist
	public void addAssignment ( )
	{
		System.out.print("Enter the name of the new assignment -> ");
		String assignmentname = keyboard.next();
		System.out.print("Enter the category of the new assignment -> ");
		String categoryname = keyboard.next();
		System.out.print("Enter the possible points of the new assignment -> ");
		double total = keyboard.nextInt();
		
		//creates a temp assignment, then loads scores for every student
		Assignment temp = new Assignment(assignmentname, categoryname, total);
		assignlist.add(temp);
		
		for (int i = 0; i < studentlist.size(); i++)
		{
			System.out.println();
			studentlist.get(i).print(i);
			System.out.print("\nEnter the score for this student -> ");
			double score = keyboard.nextInt();
			studentlist.get(i).loadScore(score);
		}
		
	}
	
	//  Prompt the user for an integer value, 1 to assignlist size, then delete the corresponding Assignment from the assignlist
	public void deleteAssignment ( )
	{
		System.out.print("Please enter an assignment number to delete -> ");
		int num = keyboard.nextInt();
		num--;
		assignlist.remove(num);
		
		for (int i = 0; i < studentlist.size(); i++)
		{
			studentlist.get(i).removeScore(num);
		}
		System.out.println("Assignment " + (num + 1) + " has been deleted!");
		
	}
	
	//  Prompt the user for an integer value, 1 to studentlist size, then prompt the user for an integer value, 1 to assignlist size
	//  Then print information for the chosen Student and chosen Assignment.  Prompt the user for a new score, and change the score
	public void changeSingleScore ( )
	{
		System.out.print("Please enter the number of the student you would like to change -> ");
		int studentnumber = keyboard.nextInt();
		studentnumber--;
		System.out.print("Please enter the assignment number you would like to change -> ");
		int assignmentnumber = keyboard.nextInt();
		assignmentnumber--;
		System.out.print("Please enter the new score of the selected assignment -> ");
		int score = keyboard.nextInt();
		System.out.println();
		
		studentlist.get(studentnumber).changeScore(assignmentnumber, score);
	}
	
	//  Prompt the user for the name of a text file, then save all information to this text file
	public void saveAndExit ( )
	{
		System.out.print("Please enter the name of the text file you would like to save to -> ");
		String filename = keyboard.next();
		try
		{
			PrintWriter out = new PrintWriter(filename);
			printCategoriesToFile(out);
			printAssignmentsToFile(out);
			printStudentsToFile(out);
					out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("\n\nContents successfully saved!");
		System.out.println("\n\n");
	}
	
	//  Print the Categories to the given text file.  To be used in saveAndExit()
	public void printCategoriesToFile (PrintWriter out)
	{
		out.println("" + catlist.length);
		for (int i = 0; i < catlist.length; i++)
		{
			catlist[i].fileprint(out);
		}
	}
	
	//  Print the Assignments to the given text file.  To be used in saveAndExit()
	public void printAssignmentsToFile (PrintWriter out)
	{
		out.println("\n" + assignlist.size());
		for (int i = 0; i < assignlist.size(); i++)
		{
			assignlist.get(i).fileprint(i,out);
		}
	}
	
	//  Print the Students to the given text file.  To be used in saveAndExit()
	public void printStudentsToFile (PrintWriter out)
	{
		out.println("\n" + studentlist.size());
		for (int i = 0; i < studentlist.size(); i++)
		{
			studentlist.get(i).fileprint(i,out);
		}
	}
}