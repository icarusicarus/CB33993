import java.util.ArrayList;
import java.util.List;

public class Editor {
	private static ArrayList<Shape> ShapeList = new ArrayList<>(); 
	private static int shapeCount = 0;
	
	public static void add(Shape newShape) {
		ShapeList.add(newShape);
		shapeCount++;
	}
	
	public static void printall() {
		if(ShapeList.size()==0)
			System.out.println("NONE");
		for(int i=0; i<ShapeList.size();i++) {
			System.out.println(ShapeList.get(i));
		}
	}
	
	public static void printR() {
		for(int i=0; i<ShapeList.size(); i++) {
			if(ShapeList.get(i) instanceof Rectangle) { 
				System.out.println(ShapeList.get(i));
			}
			else System.out.println("NONE");
		}
	}
	
	public static void printC() {
		for(int i=0; i<ShapeList.size(); i++) {
			if(ShapeList.get(i) instanceof Circle) { 
				System.out.println(ShapeList.get(i));
			}
			else System.out.println("NONE");
		}
	}
	
	public static void printT() {
		for(int i=0; i<ShapeList.size(); i++) {
			if(ShapeList.get(i) instanceof Triangle) { 
				System.out.println(ShapeList.get(i));
			}
			else System.out.println("NONE");
		}
	}

	
	public static void removeall() {
		System.out.println(ShapeList.size());
		ShapeList.clear();
		shapeCount = 0;
	}

	
	public static void totalarea() {
		float sum = 0;
		int intsum = 0;
		
		for(int i =0; i<ShapeList.size(); i++) {
			sum = sum + ShapeList.get(i).getSize();
		}
		if(sum == (int)sum) {
			intsum = (int)sum;
			System.out.println(intsum);
		}
		else
			System.out.println(sum);
	}	
}
