import java.util.Scanner;

enum OperationKind{
	ADD,
	FIND,
	CLEAR,
	LIST,
	INVALID,
	QUIT
};

public class SchoolTest {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		School pnu = new School("PNU", 100);
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
			
			switch(op) {
			case ADD: {
				Student newStudent = createStudent();
				pnu.addStudent(newStudent);
				break;
			}
			case FIND: findStudent(pnu); break;
			case CLEAR: pnu.removeAllStudent(); break;
			case LIST: System.out.println(pnu); break;
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
	
	// createStudent
	public static Student createStudent() {
		final String studenntName = scanner.next();
		final int schoolYear = scanner.nextInt();
		
		return  new Student(studenntName, schoolYear);
	}
	
	// findStudent
	public static void findStudent(final School school) {
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();
		final Student foundStudent = school.findStudent(studentName, schoolYear);
		
		if(foundStudent != null)
			System.out.println(foundStudent);
		else
			System.out.println("Student Not Found with name " + studentName + " and year " + schoolYear);
	}
}
