import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
enum OperationKind {ADDL, ADDC, LIST, SORTA, SORTD, CLEAR, QUIT, INVALID};
enum SortKind {ASCENDING, DESCENDING};

public class SortInterfaceTest {
	private static Scanner scanner = new Scanner(System.in);
	private static List<MyComparable> comparableList = new ArrayList<>();
	
	public static void main(String[] args) {
		while (true) {
			final OperationKind op = getOperation(scanner);
			if (op == OperationKind.QUIT) {
				System.out.println("Bye");
				break;
			}
			if (op == OperationKind.INVALID) {
				System.out.println("Invalid Opeation!");
				continue;
			}
			switch (op) {
			case ADDL : {
				final Line newLine = createLine(scanner);
				comparableList.add(newLine);
				System.out.println(newLine);
				break;
			}
			case ADDC : {
				final Circle newCircle = createCircle(scanner);
				comparableList.add(newCircle);
				System.out.println(newCircle);
				break;
			}
			case SORTA : {
				sortList(comparableList, SortKind.ASCENDING);
				break;
			}
			case SORTD : {
				sortList(comparableList, SortKind.DESCENDING);
				break;
			}
			case CLEAR :
				comparableList.clear();
				break;
			case LIST :
				System.out.println(comparableList);
				break;
			default : break;
			}
		}
	}
	
	private static OperationKind getOperation(final Scanner scanner) {
		System.out.print("Enter Operation String!");
		final String operation = scanner.next();
		
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		}
		catch (IllegalArgumentException e) {
			kind = OperationKind.INVALID;
		}
		return kind;
	}
	
	private static Circle createCircle(final Scanner scanner) {
		final int x = scanner.nextInt();
		final int y = scanner.nextInt();
		final int radius = scanner.nextInt();
		
		final Circle newCircle = new Circle(new Point(x, y), radius);
		return newCircle;
	}
	
	private static Line createLine(final Scanner scanner) {
		final int x1 = scanner.nextInt();
		final int y1 = scanner.nextInt();
		final int x2 = scanner.nextInt();
		final int y2 = scanner.nextInt();
		
		final Line newLine = new Line(new Point(x1, y1), new Point(x2, y2));
		return newLine;
	}
	
	private static void sortList(final List<MyComparable> comparableList, final SortKind sortKind) {
		if(sortKind == SortKind.ASCENDING) {
			for(int i = 0; i < comparableList.size(); i++) {
				for(int j = i; j > 0; j--) {
					if(comparableList.get(j-1).getSize() > comparableList.get(j).getSize())
						swap(comparableList, j);
				}
			}
		}
		else {
			for(int i = 0; i < comparableList.size(); i++) {
				for(int j = i; j > 0; j--) {
					if(comparableList.get(j).getSize() > comparableList.get(j-1).getSize())
						swap(comparableList,j);
				}
			}
		}
	}
	
	private static void swap(List<MyComparable> comparableList, int j) {
			 MyComparable tmp = comparableList.get(j - 1);
			 comparableList.set(j - 1, comparableList.get(j));
			 comparableList.set(j, tmp);
	}
}
