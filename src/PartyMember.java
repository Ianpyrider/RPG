public class PartyMember {
	private int health;
	private int damage;
	private Weapon weapon;
	private int mana;
	private int maxHP;
	private int maxMP;
	private int level = 1;
	
	//Slot one is health potions and slot 2 is mana potions
	private int[] items = new int[] {3, 2};
	
	
	public PartyMember (int phealth, int pdamage, int weaponid, int pmana) {
		health = phealth;
		damage = pdamage;
		weapon = new Weapon(weaponid);
		mana = pmana;
		maxHP = phealth;
		maxMP = pmana;
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
			mana -= 5;
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
	
	public int getMaxMP() {
		return maxMP;
	}
	
	public void setHealth(int newhealth) {
		health = newhealth;
	}
	
	public int getMana() {
		return mana;
	}
	
	public int getMPotions() {
		return items[1];
	}
	
	public void restoreMana() {
		mana += 5;
		items[1]--;
	}
	
	public void setMana(int newmana) {
		mana = newmana;
	}
}