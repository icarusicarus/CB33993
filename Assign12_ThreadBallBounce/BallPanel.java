import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class BallPanel extends JPanel {
	public void add(Ball b) {
		balls.add(b);
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Ball b : balls) {g2.fill(b.getShape());}
	}
	private List<Ball> balls = new ArrayList<>();
}
