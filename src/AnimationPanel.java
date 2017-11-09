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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener
{
	private Timer t;
	//change/add instance variables as needed
	int frameNum;
	BufferedImage warrior;
	BufferedImage orc;
	boolean attack = false;
	int warX = 175;
	int warY = 140;
	JTextField text;
	boolean gameOver = false;
	JButton attackB;
	JButton itemB;
	JButton magicB;
	JButton runB;
	

	public AnimationPanel()
	{
		frameNum = 0;

		try {
			warrior = ImageIO.read(new File("frame_0" + frameNum + "_delay-0.13s.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			orc = ImageIO.read(new File("orc.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t = new Timer(50,this);
		t.start();
	}

	//Overrides the paint method to draw whatever you want.
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.RED);

		try {
			if (frameNum < 10) {
				warrior = ImageIO.read(new File("frame_0" + frameNum + "_delay-0.13s.gif"));
			} else {
				warrior = ImageIO.read(new File("frame_" + frameNum + "_delay-0.13s.gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.drawImage(warrior,warX,warY,this); //img link, upper left corner coor, this
		g.drawImage(orc, 525, 140, this);
	}

	//Modify this method as needed.
	public void actionPerformed(ActionEvent e)
	{
		if (!gameOver) {
			if (attack) {
				frameNum++;	
				if (frameNum < 9) {
					frameNum++;
				} else {
					if (frameNum<14) {
						warX += 90;
					}
					if (frameNum>16) {
						frameNum = 0;
						attack = false;
						if (!gameOver) {
							text.setText("       Choose an action");
							attackB.setVisible(true);
							itemB.setVisible(true);
							magicB.setVisible(true);
							runB.setVisible(true);
						}
					} 
				}
				repaint();
			} else if (warX>175) {
				warX-=90;
				frameNum++;		
				if (frameNum>9) {
					frameNum = 0;
				} 
				repaint();
			} else {
				frameNum++;		
				if (frameNum>9) {
					frameNum = 0;
				} 
				repaint();
			}
		} else {
			t.stop();
		}
	}

	public void attack(JTextField intext, JButton b1, JButton b2, JButton b3, JButton b4) {
		attack = true;
		text = intext;
		text.setText("       Player attacks!");
		attackB = b1;
		itemB = b2;
		magicB = b3;
		runB = b4;
		attackB.setVisible(false);
		itemB.setVisible(false);
		magicB.setVisible(false);
		runB.setVisible(false);
	}

	public void gameOver() {
		gameOver = true;
	}
}
