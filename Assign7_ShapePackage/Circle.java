
public class Circle {
	private Point center;
	private int radius;
	public Circle(Point center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "[ Circle " + this.center.toString() + " " + radius + " " + radius*radius*Math.PI + " ]";
	}
}
