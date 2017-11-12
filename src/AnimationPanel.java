import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	BufferedImage hpBar;
	BufferedImage hpBarFull;
	BufferedImage background;
	BufferedImage startScreen;
	boolean attack = false;
	int warX = 275;
	int warY = 325;
	int orcX = 625;
	int orcY = 0;
	JTextField text;
	boolean gameOver = false;
	JButton attackB;
	JButton itemB;
	JButton magicB;
	JButton runB;
	int damage;
	int monsterDamage;
	boolean start = false;
	int health = 0;

	public AnimationPanel()
	{
		try {
			startScreen = ImageIO.read(new File("Start Screen.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		try {
			hpBar = ImageIO.read(new File("hpBar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			hpBarFull = ImageIO.read(new File("hpBarFull.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			background = ImageIO.read(new File("Fight_Background_Test.png"));
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
		g.setColor(Color.LIGHT_GRAY);
		
		if (start) {
			try {
				if (frameNum < 10) {
					warrior = ImageIO.read(new File("frame_0" + frameNum + "_delay-0.13s.gif"));
				} else {
					warrior = ImageIO.read(new File("frame_" + frameNum + "_delay-0.13s.gif"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		g.fillRect(0, 0, 1500, 600);
		g.drawImage(background, 200, 40, this);
		g.drawImage(warrior,warX,warY,this); //img link, upper left corner coor, this
		g.drawImage(orc, 625, 25, this);
		g.drawImage(hpBar, 200, 200, this);
		g.drawImage(hpBarFull.getSubimage(0, 0, hpBarFull.getWidth()-(22*health), hpBarFull.getHeight()), 200, 200, this);
		if (!start) {
			g.drawImage(startScreen.getScaledInstance(1500, 650, Image.SCALE_SMOOTH), 0, 0, this);
		}
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
							text.setFont(new Font("Ariel", 36, 36));
							text.setText("       The hero dealt " + damage + " damage. Hero received " + monsterDamage + " damage. Choose an action");
							attackB.setVisible(true);
							itemB.setVisible(true);
							magicB.setVisible(true);
							runB.setVisible(true);
						}
					} 
				}
				repaint();
			} else if (warX>275) {
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
			health = 19;
			repaint();
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
	
	public void start() {
		start = true;
	}

	public void gameOver() {
		gameOver = true;
	}
	
	public void getDamage(int dmg) {
		damage = dmg;
	}
	
	public void getMonsterDamage(int dmg) {
		monsterDamage = dmg;
	}
	
	public void getHealth(int phealth) {
		if (phealth == 0) {
			health = (428/22);
		} else {
			health = (20-phealth);
		}
	}
}
