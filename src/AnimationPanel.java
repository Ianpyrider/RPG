import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener
{
	private Timer t;
	//change/add instance variables as needed
	int frameNum;
	BufferedImage img;

	public AnimationPanel()
	{
		frameNum = 0;
		
		try {
			img = ImageIO.read(new File("frame_0" + frameNum + "_delay-0.13s.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t = new Timer(20,this);
		t.start();
	}

	//Overrides the paint method to draw whatever you want.
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.RED);

		try {
			img = ImageIO.read(new File("frame_0" + frameNum + "_delay-0.13s.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(img,100,140,this); //img link, upper left corner coor, this
	}

	//Modify this method as needed.
	public void actionPerformed(ActionEvent e)
	{
		frameNum++;
		if (frameNum>9) {
			frameNum = 0;
		}
		repaint();
	}
}
