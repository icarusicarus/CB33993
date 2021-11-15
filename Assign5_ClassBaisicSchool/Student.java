import java.util.Objects;

public class Student {
	private final String name;
	private int year;
	
	public Student(String studentName, int schoolYear) {
		assert studentName != null;
		assert schoolYear >= 1 && schoolYear <= 4;
		
		name = studentName;
		year = schoolYear;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean match(String studentName, int schoolYear) {
		return Objects.equals(name, studentName) && year == schoolYear;
	}
	
	@Override
	public String toString() {
		return "Student [ name=" + name + ", year=" + year + "ÇÐ³â ]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		Student other = (Student) otherObject;
		
		return Objects.equals(name, other.name) && year == other.year;
	}
}
