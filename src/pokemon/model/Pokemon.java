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
		return "Hi, i am a " + name + "and my HP is " + healthPoints;
	}
	
	public String getPokemonInformation(){
		return "this Pokemon is of type" + this.getClass().getSimpleName();
	}
}
