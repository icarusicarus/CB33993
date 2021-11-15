
public class Rectangle {
	private int width, height; 
	
	public Rectangle(int width,int height){
		this.width = width; this.height = height;
	}
	
	public String toString(){
		return "Rectangle: width " + width + ", height " + height;
	}

	public void scailSize(int zoomRatio) {
		height = zoomRatio * height; 
		width = zoomRatio * width; 
	}
}