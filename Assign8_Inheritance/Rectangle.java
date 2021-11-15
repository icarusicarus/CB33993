
public class Rectangle extends Shape{
	private int width = 0; 
	private int height = 0;
	private float size = 0;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		this.size = (float) width * height;
	}
	
	@Override
	public String toString() {
		return "Rectangle " + width + " " + height + " " + size;
	}
	
	@Override
	public float getSize() {
		return size;
	}
}
