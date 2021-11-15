import java.util.Scanner;
enum OperationKind {ADD, PRINT, PRINTALL, REMOVEALL, TOTALAREA, QUIT, INVALID};
enum ShapeType {R, C, T};

public class EditorTest {
	private static Editor editor = new Editor();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
			final OperationKind op = getOperation(scanner);
			if (op == OperationKind.QUIT) {
				System.out.println("Bye"); break;
			}
			if (op == OperationKind.INVALID) {
				System.out.println("Invalid Operation!"); continue;
			}
			switch (op) {
			case ADD : {
				ShapeType shapeOrder = getShapeType();
				if (shapeOrder == ShapeType.R) {
					final Rectangle newRectangle = createRectangle(scanner);
					System.out.println(newRectangle);
					editor.add(newRectangle); break;
				}
				else if (shapeOrder == ShapeType.C) {
					final Circle newCircle = createCircle(scanner);
					System.out.println(newCircle);
					editor.add(newCircle); break;
				}
				else if (shapeOrder == ShapeType.T) {
					final Triangle newTriangle = createTriangle(scanner);
					System.out.println(newTriangle);
					editor.add(newTriangle); break;
				}
				else break;
			}
			case PRINT : {
				ShapeType shapeOrder = getShapeType();
				if (shapeOrder == ShapeType.R) {
					editor.printR(); break;
				}
				else if (shapeOrder == ShapeType.C) {
					editor.printC(); break;
				}
				else if (shapeOrder == ShapeType.T) {
					editor.printT(); break;
				}
				else break;
			}
			case PRINTALL : editor.printall(); break;
			case REMOVEALL : editor.removeall(); break;
			case TOTALAREA : editor.totalarea(); break;
			default : break;
			}
		}
		scanner.close();
	}
	
	private static ShapeType getShapeType() {
		ShapeType shapeOrder;
		while(true){
			String shapeSearch = scanner.next(); 
			if(shapeSearch.equalsIgnoreCase("T")){
				shapeOrder = ShapeType.T; 
				break;
			}
			else if(shapeSearch.equalsIgnoreCase("C")){
				shapeOrder = ShapeType.C; 
				break;
			}
			else if(shapeSearch.equalsIgnoreCase("R")){
				shapeOrder = ShapeType.R;
				break;
			}
			else continue;
		}
		return shapeOrder;
	}
	
	private static Circle createCircle(final Scanner scanner) {
		final int x = scanner.nextInt();
		final int y = scanner.nextInt();
		final int radius = scanner.nextInt();
		
		final Circle newCircle = new Circle(new Point(x, y), radius);
		return newCircle;
	}
	
	private static Rectangle createRectangle(final Scanner scanner) {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();
		
		final Rectangle newRectangle = new Rectangle(width, height);
		return newRectangle;
	}
	
	private static Triangle createTriangle(final Scanner scanner) {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();
		
		final Triangle newTriangle = new Triangle(width, height);
		return newTriangle;
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
}
