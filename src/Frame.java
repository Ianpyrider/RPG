import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JPanel controls;
	private  JButton healthp;
	private JButton monsterSelect;
	private  JTextField text;
	private int battleIndex = 0;
	private Battle battle;
	
	
	public Frame()
	{
		battle = new Battle();
		frame = new JFrame("One Buttons");
		attack = new JButton("Attack");
		item = new JButton("Items");
		magic = new JButton("Magic");
		b4 = new JButton("Give up");
		controls = new JPanel();
		screen = new AnimationPanel();
		healthp = new JButton("HP Potion (" + battle.playerHPotions() + ")");
		monsterSelect = new JButton("Monster 1");
		text = new JTextField(" Choose an action");

		attack.addActionListener(this);//assign thef action to this button
		//attack.setBounds(100,700,278,150);//set x,y,width,height of button
		//attack.setFont(new Font("Ariel", 50, 50));
		
		healthp.addActionListener(this);//assign thef action to this button
		//healthp.setBounds(100,700,278,150);//set x,y,width,height of button
		//healthp.setFont(new Font("Ariel", 50, 50));
		
		item.addActionListener(this);//assign thef action to this button
		//item.setBounds(424,700,278,150);//set x,y,width,height of button
		item.setFont(new Font("Ariel", 50, 50));
		
		magic.addActionListener(this);//assign thef action to this button
		//b2.setBounds(748,700,278,150);//set x,y,width,height of button
		magic.setFont(new Font("Ariel", 50, 50));
		
		b4.addActionListener(this);//assign thef action to this button
		//b4.setBounds(1072,700,278,150);//set x,y,width,height of button
		b4.setFont(new Font("Ariel", 50, 50));
		
		//monsterSelect.setBounds(150,400,200,100);//set x,y,width,height of button
		monsterSelect.setFont(new Font("Ariel", 30, 30));
		
		text.setEditable(false);
		//text.setBounds(100, 550, 1250, 100);
		text.setFont(new Font("Ariel", 40, 40));
		
		frame.setSize(1500,1000);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setLayout(new FlowLayout());//using no layout managers 
		controls.setLayout(new FlowLayout());
		controls.add(attack);//add b1 to the frame
		controls.add(text);
		controls.add(item);
		controls.add(magic);
		controls.add(b4);
		controls.add(healthp);
		frame.add(controls);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program when window closes
		frame.setVisible(true);//make the frame visible
		healthp.setVisible(false);
	}
	
	public void win() {
		text.setText("      You win!");
		attack.setVisible(false);
	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == attack)
		{	
			if (battle.newBattle(0)) {
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
			if (battle.newBattle(2)) {
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
		}
	}
}