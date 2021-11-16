import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingButton extends JButton {
	public SwingButton(Action act) {
		super(act);
		this.setBackground(Color.PINK);
	}
	
	public SwingButton(String name) {
		super(name);
		this.setBackground(Color.PINK);
	}
}
