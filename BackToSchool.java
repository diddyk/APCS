// David Kong		10/31/11
// BackToSchool.java
// Tester method; creatres instances of Person, Student, Teacher, and Collegestudent
// Then passes in parameters to each class.


public class BackToSchool
{
	public static void main (String [] args)
	{
		System.out.print("\n\n\n");
		Person bob = new Person("Coach Bob", 27, "M");
		System.out.println(bob);

		Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
		System.out.println(lynne);

		Teacher mrJava = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
		System.out.println(mrJava);

		CollegeStudent ima = new CollegeStudent("Ima Frosh", 18, "F", "UCB123", 4.0, 1, "English");
		System.out.println(ima);
		System.out.print("\n\n\n");
	}
}