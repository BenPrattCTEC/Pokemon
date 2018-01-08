package pokemon.model.pokemon;

import pokemon.model.*;

public class Molar extends Pokemon implements EarthType{
	public Molar(int number, String name){
		super(number, name);
	}
	public Molar(String name){
		super(0, name);
	}
	public Molar(){
		super(0, "Molar");
	}
	
	public Pokemon shake(Pokemon target){
		return Attacks.shake(target);
	}
	
	public Pokemon smash(Pokemon target){
		return Attacks.smash(target);
	}
	
	public Pokemon stomp(Pokemon target){
		return Attacks.stomp(target);
	}
	
	public Pokemon undermine(Pokemon target){
		return Attacks.undermine(target);
	}
}
