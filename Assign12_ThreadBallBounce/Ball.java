import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class Ball {
	public void move(Rectangle2D bounds) {
		x += dx; y += dy;
		if (x < bounds.getMinX()) {x = bounds.getMinX(); dx = -dx;}
		if (x + XSIZE >= bounds.getMaxX()) {x = bounds.getMaxX() - XSIZE; dx = -dx;}
		if (y < bounds.getMinY()) {y = bounds.getMinY(); dy = -dy;}
		if (y + YSIZE >= bounds.getMaxY()) {y = bounds.getMaxY() - YSIZE; dy = -dy;}
	}
	
	public Ellipse2D getShape() {return new Ellipse2D.Double(x, y, XSIZE, YSIZE);}
	
	public void speedModify(int speed) {
		this.dx += speed;
		this.dy += speed;
	}
	
	public String getSpeed() {
		return Double.toString(dx);
	}
	
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
}
