
public class Point {
	private int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[ " + this.x + ", " + this.y + " ]";
	}
}
