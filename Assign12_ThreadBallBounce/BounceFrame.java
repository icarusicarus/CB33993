import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class BounceFrame extends JFrame {
	public BounceFrame() {
		setTitle("BounceThread");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenu speedMenu = new JMenu("Speed");
		
		JMenuItem fasterMenu = speedMenu.add(new SpeedAction("Faster"));
		JMenuItem slowerMenu = speedMenu.add(new SpeedAction("Slower"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(speedMenu);
		
		ballPanel = new BallPanel(); add(ballPanel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Add 1", new ActionListener() {
			public void actionPerformed(ActionEvent event) {addBall(1);}
		});
		addButton(buttonPanel, "Add 2", new ActionListener() {
			public void actionPerformed(ActionEvent event) {addBall(2);}
		});
		addButton(buttonPanel, "Close", new ActionListener() {
			public void actionPerformed(ActionEvent event) {System.exit(0);}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		
		Ball test = new Ball();
		JLabel label = new JLabel(test.getSpeed());
		add(label, BorderLayout.EAST);
	}
	
	private void addButton(Container container, String title, ActionListener listener ) {
		JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall(int num) {
		try {
			for(int i = 0; i < num; i++) {
				Ball b = new Ball();
				b.speedModify(addBallSpeed);
				ballPanel.add(b);
				Runnable r = new BallRunnable(b, ballPanel);
				Thread t = new Thread(r);
				if (i != 0) Thread.sleep(i*100);
				t.start();			
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	class SpeedAction extends AbstractAction {
		private int type;
		
		public SpeedAction(String type) {
			super(type);
			if (type == "Faster") this.type = 1;
			else if (type == "Slower") this.type = -1;
			else this.type = 0;
		}
		
		public void actionPerformed(ActionEvent event) {
			addBallSpeed += type;	
		}
	}
	
	private BallPanel ballPanel;
	public static int addBallSpeed = 0;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
}

