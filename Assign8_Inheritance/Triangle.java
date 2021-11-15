
public class Triangle extends Shape{
	private int width = 0; 
	private int height = 0;
	private float size = 0;
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
		this.size = (float) width * height / 2;
	}
	
	@Override
	public String toString() {
		return "Triangle " + width + " " + height + " " + size;
	}
	
	@Override
	public float getSize() {
		return size;
	}
}
