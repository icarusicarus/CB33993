import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionPanel extends JPanel{
	class TooltipAction extends AbstractAction {
		public TooltipAction(String name, String desc) {
			putValue(Action.NAME, name);
			putValue(Action.SHORT_DESCRIPTION, desc);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public ActionPanel() {
		Action addAction = new TooltipAction("Add", "This is Add button.");
		Action remnoveFAction = new TooltipAction("Remove First", "This is Remove First button.");
		Action remnoveLAction = new TooltipAction("Remove Last", "This is Remove Last button.");
		Action remnoveAAction = new TooltipAction("Remove All", "This is Remove All button.");

		add(new SwingButton(addAction));
		add(new SwingButton(remnoveFAction));
		add(new SwingButton(remnoveLAction));
		add(new SwingButton(remnoveAAction));

		SwingButton quitButton = new SwingButton("Quit");
		QuitAction quitAction = new QuitAction();
		quitButton.addActionListener(quitAction);
		add(quitButton);
	}
	
	class QuitAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
