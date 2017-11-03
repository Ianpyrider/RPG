public class PartyMember {
	//gittest
	private int health;
	private int damage;
	private Weapon weapon;
	
	public PartyMember (int phealth, int pdamage, int weaponid) {
		health = phealth;
		damage = pdamage;
		weapon = new Weapon(weaponid);
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