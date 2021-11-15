import java.util.Scanner;

enum StringCommand {
	ADD,
	REMOVE,
	CLEAN,
	QUIT,
	INVALID
};

public class StringSetManager {
	static int index = 0;
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		String[] stringSet = new String[100];
		while (true) {
			final StringCommand command = getCommand(scanner);
			if (command == StringCommand.QUIT) {
				System.out.println("BYE!"); break;
			}
			switch (command) {
			case ADD: {
				final String str = getString(scanner);
				executeAdd(stringSet, str);
				break;
			}
			case REMOVE: {
				final String str = getString(scanner);
				executeRemove(stringSet, str);
				break;
			}
			case CLEAN: {
				executeClear(stringSet);
				break;
			}
			default:
				System.out.println("Unknown Command!");
				break;
			}
			executePrint(stringSet);
		}
	}
	
	// getCommand
	public static StringCommand getCommand(Scanner scan) {
		String cmd = scan.next();
		cmd = cmd.toUpperCase();
		
		StringCommand command;
		switch (cmd) {
		case "ADD":
			command = StringCommand.ADD;
			break;
		case "REMOVE":
			command = StringCommand.REMOVE;
			break;
		case "CLEAN":
			command = StringCommand.CLEAN;
			break;
		case "QUIT":
			command = StringCommand.QUIT;
			break;
		default:
			command = StringCommand.INVALID;
			break;
		}
		return command;
	}
	
	// getString
	public static String getString(Scanner scan) {
		String str = scan.next();
		return str;
	}
	
	// execute add
	public static void executeAdd(String[] stringSet, String str) {
		stringSet[index] = str;
		index++;
	}
	
	// execute remove
	public static void executeRemove(String[] stringSet, String str) {
		for (int i = 0; i < index; i++) {
			if (stringSet[i].equals(str)) {
				index--;
				for (int j = i; j < index; j++) {
					stringSet[j] = stringSet[j+1];
				}
				break;
			}
		}
	}
	
	// execute clear
	public static void executeClear(String[] stringSet) {
		for (int i = 0; i < index; i++) {
			stringSet[i] = null;
		}
		index = 0;
	}
	
	// execute print
	public static void executePrint(String[] stringSet) {
		System.out.printf("Element Size: %d, Values = ", index);
		if (index != 0) {
			for (int i = 0; i < index; i++) {
				if (i == index - 1) {
					System.out.printf("%s\n", stringSet[i]);
				}
				else {
					System.out.printf("%s, ", stringSet[i]);					
				}
			}
		}
		else {
			System.out.printf("\n");
		}
	}
}
