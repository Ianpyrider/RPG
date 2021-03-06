import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Your extension may require you to modify this class.
//Otherwise, nothing in here needs to change.
public class DrawingFrame extends JFrame
{
	private AnimationPanel panel;

	public DrawingFrame()
	{
		setSize(600,400);
		panel = new AnimationPanel();
		add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		panel.requestFocus(true);
	}
}