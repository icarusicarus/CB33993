import java.util.List;
import java.util.ArrayList;

public class Editor {
	private List<Object> shapes = new ArrayList<>();
	
	// method
	public void add(Object newObject) {
		shapes.add(newObject);
	}
	
	public void clear() {
		shapes.clear();
	}
	
	public void list() {
		String msg = "[";
		for (final Object shapeOne: shapes) {
			msg += shapeOne.toString();
			msg += ", ";
		}
		msg += "]";
		
		System.out.println(msg);
	}
}
