import java.util.Objects;

public class Student {
	private final String name;
	private int year;
	private final School theSchool;

	// generator
	public Student(School theSchool, String name, int year) {
		this.name = name;
		this.year = year;
		this.theSchool = theSchool;
	}
	
	// method
	public boolean match(School schoolName, String studentName, int schoolYear) {
		return Objects.equals(theSchool, schoolName) && Objects.equals(name, studentName) && year == schoolYear;
	}
	
	@Override
	public String toString() {
		return "[ Name: " + name + ", School: " + theSchool.getName() + ", " + year +"ÇÐ³â ]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		Student other = (Student) otherObject;
		
		return Objects.equals(theSchool, other.theSchool) && Objects.equals(name, other.name) && year == other.year;
	}
	
}
