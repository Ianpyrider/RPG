
public class Monster {

	private int health;
	private int damage;
	
	public Monster (int mhealth, int mdamage) {
		health = mhealth;
		damage = mdamage;
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
