// David Kong		10/31/11
// CollegeStudent.java

public class CollegeStudent extends Student
{
	private String myMajor; // major
    private int myYear; // grade point average

      // constructor
    public CollegeStudent(String name, int age, String gender, String idNum, double gpa, int year, String major)
    {
        // use the super class' constructor
		super(name, age, gender, idNum, gpa);

        // initialize what's new to Student
        myMajor = major;
        myYear = year;
    }

    public String getMajor()
    {
        return myMajor;
    }

    public int getYear()
    {
        return myYear;
    }

    public void setMajor(String major)
    {
        myMajor = major;
    }

    public void setYear(int year)
    {
        myYear = year;
    }

      // overrides the toString method in the parent class
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}