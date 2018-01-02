package pokemon.model.pokemon;

import pokemon.model.*;

public class BurnySparkydo extends Sparkydo implements FireType {
	BurnySparkydo(int number, String name){
		super(number, name);
	}
	BurnySparkydo(String name){
		super(0, name);
	}
	BurnySparkydo(){
		super(0, "BurnySparkydo");
	}
	
	public Pokemon burn(Pokemon target){
		return Attacks.burn(target);
	}
	
	public Pokemon flame(Pokemon target){
		return Attacks.flame(target);
	}
	
	public Pokemon firebolt(Pokemon target){
		return Attacks.firebolt(target);
	}
	
}
