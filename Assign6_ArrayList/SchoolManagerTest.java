import java.util.Scanner;
import java.util.List;

enum OperationKind{
	ADD,
	FIND,
	CLEAR,
	LIST,
	INVALID,
	QUIT
};

public class SchoolManagerTest {
	private static Scanner scanner = new Scanner(System.in);
	private static SchoolManager schoolManager = new SchoolManager();
	
	public static void main(String[] args) {
		while (true) {
			final OperationKind op = getOperation();
			
			if (op == OperationKind.QUIT) {
				System.out.println("Bye");
				break;
			}
			if (op == OperationKind.INVALID) {
				System.out.println("Invalid Operaion!");
				break;
			}
			
			switch (op) {
			case ADD: {
				Student newStudent = createStudent();
				System.out.println(newStudent);
				break;
			}
			case FIND:
				findStudent(); break;
			case CLEAR:
				schoolManager.removeAllSchools(); break;
			case LIST:
				System.out.println(schoolManager); break;
			default: break;
			}
		}
	}
	
	// getOperation
	public static OperationKind getOperation() {
		System.out.print("Enter Command String! ");
		String cmd = scanner.next();
		cmd = cmd.toUpperCase();
		
		OperationKind command;
		switch (cmd) {
		case "ADD":
			command = OperationKind.ADD;
			break;
		case "FIND":
			command = OperationKind.FIND;
			break;
		case "CLEAR":
			command = OperationKind.CLEAR;
			break;
		case "LIST":
			command = OperationKind.LIST;
			break;
		case "QUIT":
			command = OperationKind.QUIT;
			break;
		default:
			command = OperationKind.INVALID;
			break;
		}
		return command;
	}
	
	private static Student createStudent() {
		final String schoolName = scanner.next();
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();
		
		School theSchool = schoolManager.findSchool(schoolName);
		if (theSchool == null)
			theSchool = schoolManager.createSchool(schoolName);
		final Student newStudent = new Student(theSchool, studentName, schoolYear);
		theSchool.addStudent(newStudent);
		
		return newStudent;
	}
	
	private static void findStudent() {
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();
		final List<Student> foundStudents = schoolManager.findStudent(studentName, schoolYear);
		
		if (foundStudents.size() > 0) {
			System.out.println(foundStudents.size() + " found");
			for (Student s : foundStudents) System.out.println(s);
		}
		else
			System.out.println("No Student Found with name " + studentName + " and year " + schoolYear);
	}
}
