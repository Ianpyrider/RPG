public class PartyMember {
	
	private int health;
	private int damage;
	
	public PartyMember (int phealth, int pdamage) {
		health = phealth;
		damage = pdamage;
	}
	
	public int attack() {
		return (int)(Math.random()*damage+1);
	}
	
	public int damaged(int damaged) {
		health -= damaged;
		return health;
	}
	
	public int getHealth() {
		return health;
	}
}
