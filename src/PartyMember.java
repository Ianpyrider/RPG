public class PartyMember {
	
	private int health;
	private int damage;
	private Weapon weapon;
	
	public PartyMember (int phealth, int pdamage) {
		health = phealth;
		damage = pdamage;
		weapon = new Weapon(0,0,0);
	}
	
	public int attack() {
		return (int)(Math.random()*weapon.getStrength() + damage);
	}
	
	public int damaged(int damaged) {
		health -= damaged;
		return health;
	}
	
	public int getHealth() {
		return health;
	}
}