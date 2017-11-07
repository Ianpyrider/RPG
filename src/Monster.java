
public class Monster {

	private int health;
	private int damage;
	private Weapon weapon;
	private String name;
	
	public Monster (int mhealth, int mdamage, int weaponid, String mname) {
		health = mhealth;
		damage = mdamage;
		weapon = new Weapon(weaponid);
		name = mname;
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
	
	public String getName() {
		return name;
	}
}