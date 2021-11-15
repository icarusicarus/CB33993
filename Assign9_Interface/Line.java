
public class Line implements MyComparable {
	private final Point point1, point2;
	private int size = 0;


	public Line(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		int xx = (int) Math.pow(point2.x - point1.x, 2);
		int yy = (int) Math.pow(point2.y - point1.y, 2);
		size = (int )Math.sqrt(xx+yy); 
	}
	
	public String toString() {
		return "[" + point1.toString() + " " + point2.toString() + " "+ size + "]";
	}
	
	public int compareTo(final MyComparable other) {
		if(this.getSize() > other.getSize()) return 1;
		else if(this.getSize() == other.getSize()) return 0; 
		else return -1;
	}
	
	public long getSize() {
		return (long) size; 
	}
}
