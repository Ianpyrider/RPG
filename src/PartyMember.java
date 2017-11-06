public class PartyMember {
	private int health;
	private int damage;
	private Weapon weapon;
	private int mana;
	private int maxHP;
	private int level = 1;
	
	//Slot one is health potions and slot 2 is mana potions
	private int[] items = new int[] {3, 1};
	
	
	public PartyMember (int phealth, int pdamage, int weaponid, int pmana) {
		health = phealth;
		damage = pdamage;
		weapon = new Weapon(weaponid);
		mana = pmana;
		maxHP = phealth;
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
	
	public int getWeapon() {
		return weapon.getId();
	}
	
	public int getLevel() {
		return level;
	}
	
	public void levelUp() {
		level++;
		System.out.println("\nLevel up!\n");
	}
	
	public void heal(boolean isMagic) {
		health += 5;
		if (isMagic) {
			
		} else {
			items[0]--;
		}
	}
	
	public int getHPotions() {
		return items[0];
	}
	
	public int getMaxHP() {
		return maxHP;
	}
	
	public void setHealth(int newhealth) {
		health = newhealth;
	}
}