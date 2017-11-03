public class Battle {
	
	static PartyMember player1 = new PartyMember(10, 1, 0);
	static Monster orc = new Monster(7, 1, 0);
	
	public static void resetBattle() {
		orc = new Monster(7, 1, 0);
		player1 = new PartyMember(10,1,0);
	}
	
	public static boolean newBattle() {

		
		int playerDamage = player1.attack();
		
		System.out.println("\nPlayer attacks!");
		System.out.println(playerDamage + " damage done.");
		
		if (playerDamage >= orc.getHealth()) {
			System.out.println("The orc is dead!");
			orc.damaged(playerDamage);
			return true;
		} else {
			if (player1.getHealth() > 0) {
				orc.damaged(playerDamage);
				System.out.println("Orc has " + orc.getHealth() + " health remaining.");
				System.out.println("The orc attacks!");
			} else {
				return true;
			}
			int orcDamage = orc.attack();
			
			System.out.println(orcDamage + " damage done.");
			
			if (orcDamage >= player1.getHealth()) {
				System.out.println("The player is dead!");
				player1.damaged(orcDamage);
				return true;
			} else {
				player1.damaged(orcDamage);
				System.out.println("Player has " + player1.getHealth() + " health remaining.");
			}
		}
		return false;
	}
	
}
