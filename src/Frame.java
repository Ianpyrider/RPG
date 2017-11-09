import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame implements ActionListener  {
	private JFrame frame;
	private  JButton attack;
	private  JButton item;
	private  JButton magic;
	private  JButton b4;
	private AnimationPanel screen;
	private  JButton healthp;
	private JButton manap;
	private JButton monsterSelect;
	private  JTextField text;
	private int battleIndex = 0;
	private Battle battle;
	private boolean gameOver;

	public Frame()
	{
		battle = new Battle();
		frame = new JFrame("One Buttons");
		attack = new JButton("Attack");
		item = new JButton("Items");
		magic = new JButton("Magic");
		b4 = new JButton("Give up");
		screen = new AnimationPanel();
		healthp = new JButton("HP Potion (" + battle.playerHPotions() + ")");
		monsterSelect = new JButton("Monster 1");
		text = new JTextField("       Choose an action");

		attack.addActionListener(this);//assign thef action to this button
		attack.setBounds(100,725,278,150);//set x,y,width,height of button
		attack.setFont(new Font("Ariel", 50, 50));

		healthp.addActionListener(this);//assign thef action to this button
		healthp.setBounds(100,725,278,150);//set x,y,width,height of button
		healthp.setFont(new Font("Ariel", 50, 50));

		//manap.addActionListener(this);//assign thef action to this button
		//manap.setBounds(100,725,278,150);//set x,y,width,height of button
		//manap.setFont(new Font("Ariel", 50, 50));

		item.addActionListener(this);//assign thef action to this button
		item.setBounds(424,725,278,150);//set x,y,width,height of button
		item.setFont(new Font("Ariel", 50, 50));

		magic.addActionListener(this);//assign thef action to this button
		magic.setBounds(748,725,278,150);//set x,y,width,height of button
		magic.setFont(new Font("Ariel", 50, 50));

		b4.addActionListener(this);//assign thef action to this button
		b4.setBounds(1072,725,278,150);//set x,y,width,height of button
		b4.setFont(new Font("Ariel", 50, 50));

		monsterSelect.setBounds(150,425,200,100);//set x,y,width,height of button
		monsterSelect.setFont(new Font("Ariel", 30, 30));

		text.setEditable(false);
		text.setBounds(100, 600, 1250, 100);
		text.setFont(new Font("Ariel", 40, 40));

		frame.add(screen);
		screen.setSize(1250, 500);
		screen.setLocation(100,60);

		frame.setSize(1500,1000);
		frame.getContentPane().setBackground(Color.RED);
		frame.setLayout(null);//using no layout managers 
		frame.add(attack);//add b1 to the frame
		frame.add(text);
		frame.add(item);
		frame.add(magic);
		frame.add(b4);
		frame.add(healthp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program when window closes
		frame.setVisible(true);//make the frame visible
		healthp.setVisible(false);
	}

	public void win() {
		text.setText("      You win!");
		attack.setVisible(false);
	}

	public boolean playerAttack() {
		return battle.playerAttack();
	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == attack)
		{	

			screen.attack(text, attack, item, magic, b4);

			if (battle.newBattle(0)) {

				if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					screen.gameOver();
					text.setText("      Game over!");
					attack.setVisible(false);
					item.setVisible(false);
					magic.setVisible(false);
					b4.setVisible(false);
					gameOver = true;
				}
			}
		}
		if(evt.getSource() == item) {
			attack.setVisible(false);
			item.setVisible(false);
			magic.setVisible(false);
			b4.setVisible(false);
			healthp.setVisible(true);
			text.setText("Choose an item");
		}
		if (evt.getSource() == healthp) {
			if (battle.newBattle(1)) {
				if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					text.setText("      Game over!");
					attack.setVisible(false);
					item.setVisible(false);
					magic.setVisible(false);
					b4.setVisible(false);
				}
			}
			text.setText("Choose an action");
			attack.setVisible(true);
			item.setVisible(true);
			magic.setVisible(true);
			b4.setVisible(true);
			healthp.setText("HP Potion (" + battle.playerHPotions() + ")");
			healthp.setVisible(false);
		}
		if (evt.getSource() == magic) {
			if (battle.newBattle(3)) {
				System.out.println(battle.win());
				if (battle.win()) {
					text.setText("       You win!");
					attack.setVisible(false);
					item.setVisible(false);
					magic.setVisible(false);
					b4.setVisible(false);
				} else if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					text.setText("      Game over!");
					attack.setVisible(false);
					item.setVisible(false);
					magic.setVisible(false);
					b4.setVisible(false);
				}
			}
		}
	}
}