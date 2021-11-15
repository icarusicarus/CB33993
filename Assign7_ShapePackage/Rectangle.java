
public class Rectangle {
	private int width, height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "[ Rectangle " + this.width + " " + this.height + " " + width*height + " ]";
	}
}
