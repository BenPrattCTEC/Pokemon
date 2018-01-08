package pokemon.model.pokemon;

import pokemon.model.*;

public class Drago extends Pokemon implements FireType {
	public Drago(int number, String name){
		super(number, name);
	}
	public Drago(String name){
		super(0, name);
	}
	public Drago(){
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
