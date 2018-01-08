package pokemon.model;

public abstract class Pokemon {
	
	private int healthPoints = 1;
	private int attackPoints = 1; 
	private double enhancementModifier = 1;
	private int number;
	private String name;
	private boolean canEvolve = false;
	
	public Pokemon(int number, String name){
		this.name = name;
		this.number = number;
	}
	public Pokemon(int number, String name, int healthPoints, int attackPoints, double enhancementModifier, boolean canEvolve){
		setup(number, name, healthPoints, attackPoints, enhancementModifier, canEvolve);
		
	}
	
	protected void setup(int number, String name, int healthPoints, int attackPoints, double enhancementModifier, boolean canEvolve){
		this.number = number;
		this.name = name;
		this.healthPoints = healthPoints;
		this.attackPoints = attackPoints;
		this.enhancementModifier = enhancementModifier;
		this.canEvolve = canEvolve;
	}
	
	public final String[] getPokemonTypes(){
		Class<?> [] types = getClass().getInterfaces();
		String[] pokeTypes = new String[types.length];
		
		for(int i = 0; i<types.length; i++){
			String currentInterface = types[i].getCanonicalName();
			currentInterface = currentInterface.replace(this.getClass().getPackage().getName() + ".", "");
			pokeTypes[i] = currentInterface;
		}
		return pokeTypes;
	}
	
	public String toString(){
		return "Hi, i am a " + name + " and my HP is " + healthPoints;
	}
	
	public String getPokemonInformation(){
		return "this Pokemon is of type" + this.getClass().getSimpleName();
	}
	
	/**
	 * @return the Number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param Number Number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * @return the healthPoints
	 */
	public int getHealthPoints() {
		return healthPoints;
	}

	/**
	 * @param healthPoints the healthPoints to set
	 */
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	/**
	 * @return the attackPoints
	 */
	public int getAttackPoints() {
		return attackPoints;
	}

	/**
	 * @param attackPoints the attackPoints to set
	 */
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	/**
	 * @return the enhancementModifier
	 */
	public double getEnhancementModifier() {
		return enhancementModifier;
	}

	/**
	 * @param enhancementModifier the enhancementModifier to set
	 */
	public void setEnhancementModifier(double enhancementModifier) {
		this.enhancementModifier = enhancementModifier;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the canEvolve
	 */
	public boolean isCanEvolve() {
		return canEvolve;
	}

	/**
	 * @param canEvolve the canEvolve to set
	 */
	public void setCanEvolve(boolean canEvolve) {
		this.canEvolve = canEvolve;
	}
	
}
