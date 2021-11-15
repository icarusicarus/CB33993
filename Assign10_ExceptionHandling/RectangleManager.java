import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RectangleManager {
	private List<Rectangle> rectangles = new ArrayList<>();
	private Scanner scannerObject;

	public RectangleManager(Scanner scannerObject) {
		this.scannerObject = scannerObject; 
	}
	
	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in);
		RectangleManager manager = new RectangleManager(scannerObject);
		while (true) {
			System.out.println("Enter a command: [create width height, zoom id ratio or quit]");
			final String command = scannerObject.next();
			if (command.equalsIgnoreCase("create")) {
				try {
					manager.create();					
				}
				catch (InvalidRectangleException e) {
					System.out.println("사각형의 넓이와 높이는 양수이어야 합니다. " + e.getWidth() + " " + e.getHeight());
				}
				catch(InputMismatchException e) {
					System.out.println("입력된 인자의 형식이 맞지 않습니다."); 
				}
			}
			else if (command.equalsIgnoreCase("zoom")) {manager.zoom();}
			else if (command.equalsIgnoreCase("showAll")) {manager.showAll();}
			else if (command.equalsIgnoreCase("quit")) {System.out.println("Bye"); break;}
		}
		scannerObject.close();
	}

	private void create() throws InvalidRectangleException {
		int width = scannerObject.nextInt();
		int height = scannerObject.nextInt();
		
		if (width <= 0 || height <= 0) {
			InvalidRectangleException e = new InvalidRectangleException(width, height); 
			throw e; 
		}
		
		Rectangle newRectangle = new Rectangle(width, height);
		rectangles.add(newRectangle);
		
		System.out.println(newRectangle + " is added at " + (rectangles.size() - 1));
	}
	
	private void zoom() {
		try {
			int idx = scannerObject.nextInt();
			int ratio = scannerObject.nextInt();
			
			System.out.println("Before: " + rectangles.get(idx));
			rectangles.get(idx).scailSize(ratio);
			System.out.println("After: " + rectangles.get(idx));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 배열의 원소를 접근했습니다." + e);
		}
	}
	
	private void showAll() {
		for (Rectangle r : rectangles) System.out.println(r);
	}
}
