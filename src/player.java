
public class player {
	private String Name;
	private long LifePoints;
	private short GodPower;
	private String[] Rolls;
	private String GodFavorSelected;
	private byte GodFavorLevel;
	

	// Constructor
	public player(String name, long lifePoints, short godPower) {
		super();
		Name = name;
		LifePoints = lifePoints;
		GodPower = godPower;
	}
	
	// Getter and Setters
	public String getGodFavorSelected() {
		return GodFavorSelected;
	}
	
	public void setGodFavorSelected(String godFavorSelected) {
		GodFavorSelected = godFavorSelected;
	}
	
	public byte getGodFavorLevel() {
		return GodFavorLevel;
	}
	
	public void setGodFavorLevel(byte godFavorLevel) {
		GodFavorLevel = godFavorLevel;
	}
	public String getName() {
		return Name;
	}
	public String[] getRolls() {
		return Rolls;
	}

	public void setRolls(String[] rolls) {
		Rolls = rolls;
	}

	public void setName(String name) {
		Name = name;
	}
	public long getLifePoints() {
		return LifePoints;
	}
	public void setLifePoints(long lifePoints) {
		LifePoints = lifePoints;
	}
	public short getGodPower() {
		return GodPower;
	}
	public void setGodPower(short godPower) {
		GodPower = godPower;
	}
	
	// other functions
	public String show() {
		return this.Name+";"+this.LifePoints+";"+this.GodPower;
	}
}
