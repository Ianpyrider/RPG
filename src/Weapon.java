
public class Weapon {
	private int strength;
	private int tenacity;
	private int accuracy;
	private int index;
	
	public Weapon(int wstrength, int wtenacity, int waccuracy)
	{
		strength = wstrength;
		tenacity = wtenacity;
		accuracy = waccuracy;
	}
	
	public void used()
	{
		tenacity = tenacity-1;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getAccuracy()
	{
		return accuracy;
	}
}
