import java.util.Scanner;

enum Command {
	ADD,
	LIST,
	SUM,
	INVALID,
	QUIT
};
public class ArrayEnum {
	public static void main(String[] args) {
		int index = 0;
		int[] values = new int[100];
		
		
		final Scanner scanner = new Scanner(System.in);
		
		while ( true ) {
			final Command command = getCommand(scanner);
			if ( command == Command.QUIT ) {
				System.out.println("Bye!");
				break;
			}
			switch ( command ) {
			case ADD:
				final int newValue = getValue(scanner);
				values[index] = newValue;
				index++;
				break;
			case LIST:
				printList(values, index);
				break;
			case SUM:
				System.out.println(getSum(values, index));
				break;
			case INVALID:
				System.out.println("Ivalid Command");
				default: break;
			}
		}
		scanner.close();
	}
	
	// Input
	public static Command getCommand(Scanner scan) {
		String cmd = scan.next();
		cmd = cmd.toUpperCase();
		
		Command command;
		switch (cmd) {
		case "ADD":
			command = Command.ADD;
			break;
		case "LIST":
			command = Command.LIST;
			break;
		case "SUM":
			command = Command.SUM;
			break;
		case "QUIT":
			command = Command.QUIT;
			break;
		default:
			command = Command.INVALID;
			break;
		}
		return command;
	}
	
	// LIST
	public static void printList(int[] pList, int pIndex) {
		for(int i = 0; i < pIndex; i++) {
			if (i == (pIndex - 1)) {
				System.out.printf("%d\n", pList[i]);
			}
			else {
				System.out.printf("%d ", pList[i]);				
			}
		}
	}
	
	// ADD 
	public static int getValue(Scanner scan) {
		int val = scan.nextInt();
		
		return val;
	}

	// SUM
	public static int getSum(int[] pList, int pIndex) {
		int sum = 0;
		for(int i = 0; i < pIndex; i++) {
			sum += pList[i];
		}
		
		return sum;
	}
	
	// Your code here
}
