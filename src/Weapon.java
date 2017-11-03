
public class Weapon {
	private int strength;
	private int id;
	private int level = 1;
	
	public Weapon(int weaponid) {
		id = weaponid;
		if (id == 0) {
			//Fists
			strength = 0;
		} else if (id == 1) {
			//Short sword
			strength = 6;
		} else if (id == 2) {
			//Asgoroth's sword
			strength = 100;
		} else if (id==3) {
			//Battle Hammer
			strength = 8
		}
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getId() {
		return id;
	}
}
