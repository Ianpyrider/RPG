import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame implements ActionListener  {
	private JFrame frame;
	private static JButton attack;
	private static JButton item;
	private static JButton b2;
	private static JButton b4;
	private static JButton healthp;
	private JButton monsterSelect;
	private static JTextField text;
	private int battleIndex = 0;
	
	public Frame()
	{
		frame = new JFrame("One Buttons");
		attack = new JButton("Attack");
		item = new JButton("Items");
		b2 = new JButton("Magic");
		b4 = new JButton("Give up");
		healthp = new JButton("HP Potion");
		monsterSelect = new JButton("Monster 1");
		text = new JTextField(" Choose an action");

		attack.addActionListener(this);//assign thef action to this button
		attack.setBounds(100,700,278,150);//set x,y,width,height of button
		attack.setFont(new Font("Ariel", 50, 50));
		
		healthp.addActionListener(this);//assign thef action to this button
		healthp.setBounds(100,700,278,150);//set x,y,width,height of button
		healthp.setFont(new Font("Ariel", 50, 50));
		
		item.addActionListener(this);//assign thef action to this button
		item.setBounds(424,700,278,150);//set x,y,width,height of button
		item.setFont(new Font("Ariel", 50, 50));
		
		b2.addActionListener(this);//assign thef action to this button
		b2.setBounds(748,700,278,150);//set x,y,width,height of button
		b2.setFont(new Font("Ariel", 50, 50));
		
		b4.addActionListener(this);//assign thef action to this button
		b4.setBounds(1072,700,278,150);//set x,y,width,height of button
		b4.setFont(new Font("Ariel", 50, 50));
		
		monsterSelect.setBounds(150,400,200,100);//set x,y,width,height of button
		monsterSelect.setFont(new Font("Ariel", 30, 30));
		
		text.setEditable(false);
		text.setBounds(100, 550, 1250, 100);
		text.setFont(new Font("Ariel", 40, 40));
		
		frame.setSize(1500,1000);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setLayout(null);//using no layout managers 
		frame.add(attack);//add b1 to the frame
		frame.add(text);
		frame.add(item);
		frame.add(b2);
		frame.add(b4);
		frame.add(healthp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program when window closes
		frame.setVisible(true);//make the frame visible
		healthp.setVisible(false);
		Battle.resetBattle(battleIndex);
	}
	
	public static void win() {
		text.setText("      You win!");
		attack.setVisible(false);
	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == attack)
		{	
			if (Battle.newBattle(false)) {
				if (!(Battle.playerDead())) {
					battleIndex++;
					Battle.resetBattle(battleIndex);
				} else {
					text.setText("      Game over!");
					attack.setVisible(false);
					item.setVisible(false);
					b2.setVisible(false);
					b4.setVisible(false);
				}
			}
		}
		if(evt.getSource() == item) {
			attack.setVisible(false);
			item.setVisible(false);
			b2.setVisible(false);
			b4.setVisible(false);
			healthp.setVisible(true);
		}
		if (evt.getSource() == healthp) {
			if (Battle.newBattle(true)) {
				if (!(Battle.playerDead())) {
					battleIndex++;
					Battle.resetBattle(battleIndex);
				} else {
					text.setText("      Game over!");
					attack.setVisible(false);
					item.setVisible(false);
					b2.setVisible(false);
					b4.setVisible(false);
				}
			}
			attack.setVisible(true);
			item.setVisible(true);
			b2.setVisible(true);
			b4.setVisible(true);
			healthp.setVisible(false);
		}
	}
}