import java.util.List;
import java.util.ArrayList;

public class SchoolManager {
	private List<School> schools = new ArrayList<>();
	private int schoolCount = 0;
	
	// method
	public int getCount() {
		return schoolCount;
	}
	
	public School findSchool(String schoolName) {
		for (final School school : schools) {
			if (school == null) return null;
			if (school.match(schoolName))
				return school;
		}
		return null;
	}
	
	public School createSchool(String schoolName) {
		School newSchool = new School(schoolName);
		schools.add(newSchool);
		schoolCount++;
		return newSchool;
	}
	
	public void removeAllSchools() {
		schools.clear();
		schoolCount = 0;
	}
	
	public List<Student> findStudent(String studentName, int schoolYear) {
		List<Student> foundStudent = new ArrayList<>();
		for (final School school : schools) {
			List<Student> tmp = school.getStudents();
			for (final Student student : tmp) {
				if (student.match(school, studentName, schoolYear)) {
					foundStudent.add(student);
				}
			}
		}
		
		return foundStudent;
	}
	
	@Override
	public String toString() {
		String msg = "Total School Count: " + this.getCount() + "\n";
		for (final School school : schools) {
			String schoolMsg = "School Name: " + school.getName() + " Student Count: " + school.getStudentCount() + "\n";
			msg += schoolMsg;
			
			List<Student> stringStudent = school.getStudents();
			for (final Student student : stringStudent) {
				String tmp = student.toString() + "\n";
				msg += tmp;
			}
			msg += "\n";
		}
		return msg;
	}
}
