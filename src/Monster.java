
public class Monster {

	private int health;
	private int damage;
	private Weapon weapon;
	
	public Monster (int mhealth, int mdamage, int weaponid) {
		health = mhealth;
		damage = mdamage;
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