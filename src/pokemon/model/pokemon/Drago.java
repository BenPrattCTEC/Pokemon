package pokemon.model.pokemon;

import pokemon.model.*;

public class Drago extends Pokemon implements FireType {
	Drago(int number, String name){
		super(number, name);
	}
	Drago(String name){
		super(0, name);
	}
	Drago(){
		super(0, "Drago");
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
	
	public Pokemon fireball(Pokemon target){
		return Attacks.fireball(target);
	}
	
}
