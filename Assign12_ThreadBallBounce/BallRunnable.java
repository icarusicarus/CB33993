import javax.swing.JPanel;

public class BallRunnable implements Runnable{
	public BallRunnable(Ball aBall, JPanel ballPanel) {
		ball = aBall; this.ballPanel = ballPanel;
	}
	public void run() {
		try {
			for (int i = 1; i <= STEPS; i++) {
				ball.move(ballPanel.getBounds());
				ballPanel.paint(ballPanel.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {}
	}
	private Ball ball;
	private JPanel ballPanel;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
}
