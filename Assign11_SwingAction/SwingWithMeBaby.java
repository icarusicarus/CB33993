import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingWithMeBaby {
	public static void main(String[] args) {
		ActionFrame frame = new ActionFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ActionFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 100;
	
	public ActionFrame() {
		setTitle("Swing with me, Baby.");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		ActionPanel panel = new ActionPanel();
		panel.setBackground(Color.PINK);
		add(panel);
	}
}