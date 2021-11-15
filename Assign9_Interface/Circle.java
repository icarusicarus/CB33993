
public class Circle implements MyComparable {
	private final Point center;
	private final int radius;
	private int size = 0;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
		this.size = (int) (this.radius * this.radius * Math.PI);
	}
	
	public String toString() {
		return "[" + center.toString() + " " + radius + " "+ size + "]";
	}
	
	public int compareTo(final MyComparable other) {
		if(this.getSize() > other.getSize()) return 1;
		else if(this.getSize() == other.getSize()) return 0; 
		else return -1;
	}
	
	public long getSize() {
		return size;
	}
}
