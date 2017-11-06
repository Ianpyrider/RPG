public class PartyMember {
	private int health;
	private int damage;
	private Weapon weapon;
	private int level = 1;
	
	//Slot one is health potions and slot 2 is mana potions
	private int[] items = new int[] {3, 1};
	
	
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
	
	public void heal() {
		health += 5;
		items[0]--;
	}
	
	public int getHPotions() {
		return items[0];
	}
}