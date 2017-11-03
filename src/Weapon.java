
public class Weapon {
	private int strength;
	private int id;
	
	public Weapon(int weaponid) {
		strength = 0;
		id = weaponid;
		if (id == 0) {
			//Short sword
			strength = 6;
		}
	}
	
	public int getStrength()
	{
		return strength;
	}
}
