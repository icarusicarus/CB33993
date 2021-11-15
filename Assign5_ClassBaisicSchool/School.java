import java.util.Arrays;
import java.util.Objects;

public class School {
	private String name;
	private int limit;
	
	private Student[] students;
	private int studentCount = 0;
	
	public School(final String name, final int limit) {
		this.name = name;
		this.limit = limit;
		students = new Student[this.limit];
	}
	
	public int getStudentCount() {
		return studentCount;
	}
	
	public String toString() {
		String msg = "School Name: " + name + " Student Count: " + studentCount + "\n";
		
		for(int i = 0; i < studentCount; i++) {
			msg += "\t" + students[i] + "\n";
		}
		return msg;
	}
	
	public void addStudent(Student newStudent) {
		if (studentCount < limit) {
			students[studentCount] = newStudent;
			studentCount++;			
		}
	}
	
	public Student findStudent(String studentName, int schoolYear) {
		for (final Student student : students) {
			if (student == null) return null;
			if (student.match(studentName, schoolYear))
				return student;
		}
		return null;
	}
	
	public void removeAllStudent() {
		for (int i = 0; i < studentCount; i++) {
			students[i] = null;
		}
		studentCount = 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, limit, students, studentCount);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		School other = (School) obj;
		
		return Objects.equals(name, other.name) && limit == other.limit && studentCount == other.studentCount && Arrays.equals(students, other.students);
	}
}
