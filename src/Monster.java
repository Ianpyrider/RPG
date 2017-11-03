
public class Monster {

	private int health;
	private int damage;
	private Weapon weapon;
	
	public Monster (int mhealth, int mdamage, int index) {
		health = mhealth;
		damage = mdamage;
		weapon = new Weapon(0,0,0);
	}
	
	public int attack() {
		return (int)(damage + weapon.getStrength());
	}
	
	public int damaged(int damaged) {
		health -= damaged;
		return health;
	}

	public int getHealth() {
		return health;
	}
}