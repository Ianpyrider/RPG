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
	private JButton attack;
	private JButton item;
	private JButton magic;
	private JButton b4;
	private AnimationPanel screen;
	private JButton healthp;
	private JButton manap;
	private JButton monsterSelect;
	private JButton healspell;
	private JButton smite;
	private JButton back;
	private JTextField text;
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
		manap = new JButton("MP Potion (" + battle.playerMPotions() + ")");
		monsterSelect = new JButton("Monster 1");
		healspell = new JButton("Heal");
		smite = new JButton("Smite");
		back = new JButton("Back");
		text = new JTextField("       Choose an action");

		attack.addActionListener(this);//assign thef action to this button
		attack.setBounds(100,725,278,150);//set x,y,width,height of button
		attack.setFont(new Font("Ariel", 50, 50));

		healthp.addActionListener(this);//assign thef action to this button
		healthp.setBounds(100,725,278,150);//set x,y,width,height of button
		healthp.setFont(new Font("Ariel", 40, 40));

		manap.addActionListener(this);//assign thef action to this button
		manap.setBounds(424,725,278,150);//set x,y,width,height of button
		manap.setFont(new Font("Ariel", 40, 40));

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

		healspell.addActionListener(this);//assign thef action to this button
		healspell.setBounds(100,725,278,150);//set x,y,width,height of button
		healspell.setFont(new Font("Ariel", 40, 40));

		smite.addActionListener(this);//assign thef action to this button
		smite.setBounds(424,725,278,150);//set x,y,width,height of button
		smite.setFont(new Font("Ariel", 40, 40));
		
		back.addActionListener(this);//assign thef action to this button
		back.setBounds(1072,725,278,150);//set x,y,width,height of button
		back.setFont(new Font("Ariel", 40, 40));

		text.setEditable(false);
		text.setBounds(100, 600, 1250, 100);
		text.setFont(new Font("Ariel", 40, 40));

		frame.add(screen);
		screen.setSize(1500, 550);
		screen.setLocation(0, 0);

		frame.setSize(1500,1000);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setLayout(null);//using no layout managers 
		frame.add(attack);//add b1 to the frame
		frame.add(text);
		frame.add(item);
		frame.add(magic);
		frame.add(b4);
		frame.add(healthp);
		frame.add(manap);
		frame.add(healspell);
		frame.add(smite);
		frame.add(back);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program when window closes
		frame.setVisible(true);//make the frame visible
		healthp.setVisible(false);
		manap.setVisible(false);
		healspell.setVisible(false);
		smite.setVisible(false);
		back.setVisible(false);
	}

	public boolean playerAttack() {
		return battle.playerAttack();
	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == attack)
		{	

			screen.attack(text, attack, item, magic, b4);

			int[] result = battle.newBattle(0);

			screen.getDamage(result[1]);
			
			screen.getMonsterDamage(result[2]);

			if (result[0] == 1) {

				if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					screen.gameOver();
					text.setText("      Game over!");
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
			manap.setVisible(true);
			back.setVisible(true);
			text.setText("       Choose an item");
		}
		if (evt.getSource() == healthp) {
			if (battle.newBattle(1)[0] == 1) {
				if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					screen.gameOver();
					text.setText("      Game over!");
					healthp.setVisible(false);
					manap.setVisible(false);
					back.setVisible(false);
					gameOver = true;
				}
			} else {
				text.setText("       Drank a health potion! Choose an action");
				attack.setVisible(true);
				item.setVisible(true);
				magic.setVisible(true);
				b4.setVisible(true);
				healthp.setText("HP Potion (" + battle.playerHPotions() + ")");
				healthp.setVisible(false);
				manap.setVisible(false);
				back.setVisible(false);
			}
		}
		if (evt.getSource() == magic) {
			attack.setVisible(false);
			item.setVisible(false);
			magic.setVisible(false);
			b4.setVisible(false);
			healspell.setVisible(true);
			smite.setVisible(true);
			back.setVisible(true);
			text.setText("       Cast a spell");
		}
		if (evt.getSource() == b4) {
			screen.gameOver();
			screen.attack(text, attack, item, magic, b4);
			text.setText("       With no more fight left in him, our noble hero fell on his sword. Game over!");
			text.setFont(new Font("Ariel", 35, 35));
			System.out.println("With no more fight left in him, our noble hero fell on his sword.");
		}
		if (evt.getSource() == manap) {
			if (battle.newBattle(4)[0] == 1) {
				if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					screen.gameOver();
					attack.setVisible(false);
					item.setVisible(false);
					magic.setVisible(false);
					b4.setVisible(false);
					text.setText("      Game over!");
					gameOver = true;
				}
			}
			text.setText("       Mana restored! Choose an action");
			attack.setVisible(true);
			item.setVisible(true);
			magic.setVisible(true);
			b4.setVisible(true);
			healthp.setVisible(false);
			manap.setVisible(false);
			back.setVisible(false);
		}

		if (evt.getSource() == smite) {
			if (battle.newBattle(3)[0] == 1) {
				if (battle.win()) {
					text.setFont(new Font("Ariel", 35, 35));
					text.setText("       A storm rumbles overhead... ASGOROTH IS SMITED DOWN. Game over!");
					smite.setVisible(false);
					healspell.setVisible(false);
					back.setVisible(false);
				} else if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					screen.gameOver();
					screen.attack(text, attack, item, magic, b4);
					smite.setVisible(false);
					healspell.setVisible(false);
					back.setVisible(false);
					text.setFont(new Font("Ariel", 35, 35));
					text.setText("       A storm rumbles overhead... YOU ARE SMITED DOWN. Game over!");
				}
			}
		}

		if (evt.getSource() == healspell) {
			if (battle.newBattle(2)[0] == 1) {
				if (!(battle.playerDead())) {
					battleIndex++;
					battle.resetBattle(battleIndex);
				} else {
					screen.gameOver();
					attack.setVisible(false);
					item.setVisible(false);
					magic.setVisible(false);
					b4.setVisible(false);
					text.setText("      Game over!");
					gameOver = true;
				}
			}
			text.setText("       Healing spell cast! Choose an action");
			attack.setVisible(true);
			item.setVisible(true);
			magic.setVisible(true);
			b4.setVisible(true);
			healspell.setVisible(false);
			smite.setVisible(false);
			back.setVisible(false);
		}
		
		if (evt.getSource() == back) {
			healthp.setVisible(false);
			manap.setVisible(false);
			healspell.setVisible(false);
			smite.setVisible(false);
			back.setVisible(false);
			attack.setVisible(true);
			item.setVisible(true);
			magic.setVisible(true);
			b4.setVisible(true);
			text.setText("       Choose an action");
		}
	}
}