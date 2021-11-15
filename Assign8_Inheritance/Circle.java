
public class Circle extends Shape {
	private Point center;
	private int radius = 0;
	private float size = 0;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
		this.size = (float)(this.radius * this.radius * Math.PI);
	}
	
	@Override
	public String toString() {
		return "Circle " + center.x + " " + center.y + " " + size;
	}
	
	@Override
	public float getSize() {
		return size;
	}
}
