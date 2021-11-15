import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class School {
	private String name;
	private List<Student> students = new ArrayList<>();

	// getter
	public String getName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public int getStudentCount() {
		return students.size();
	}

	// generator
	public School(final String name) {
		this.name = name;
	}

	// method
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}

	public boolean match(String schoolName) {
		return Objects.equals(name, schoolName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, students);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		School other = (School) obj;
		
		return Objects.equals(name, other.name) && students.equals(other.students);
	}
}
