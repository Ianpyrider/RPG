import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame implements ActionListener  {
	private JFrame frame;
	private JButton attack;
	private JButton monsterSelect;
	private JTextField text;
	
	PartyMember player1 = new PartyMember(10, 6);
	Monster orc = new Monster(7, 6, 1);
	
	public Frame()
	{
		frame = new JFrame("One Buttons");
		attack = new JButton("Attack");
		monsterSelect = new JButton("Monster 1");
		text = new JTextField(" Choose an action");

		attack.addActionListener(this);//assign thef action to this button
		attack.setBounds(100,700,300,150);//set x,y,width,height of button
		attack.setFont(new Font("Ariel", 50, 50));
		
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program when window closes
		frame.setVisible(true);//make the frame visible
	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == attack)
		{
			int playerDamage = player1.attack();
			
			text.setText("\nPlayer attacks!");
			text.setText(playerDamage + " damage done.");
			
			if (playerDamage >= orc.getHealth()) {
				text.setText("The orc is dead!");
				orc.damaged(playerDamage);
			} else {
				orc.damaged(playerDamage);
				text.setText("Orc has " + orc.getHealth() + " health remaining.");
				text.setText("The orc attacks!");
				
				int orcDamage = orc.attack();
				
				text.setText(orcDamage + " damage done.");
				
				if (playerDamage >= player1.getHealth()) {
					text.setText("The player is dead!");
					player1.damaged(orcDamage);
				} else {
					player1.damaged(orcDamage);
					text.setText("Player has " + player1.getHealth() + " health remaining.");
				}
			}
		}
	}
}