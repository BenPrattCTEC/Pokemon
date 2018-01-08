package pokemon.model.pokemon;

import pokemon.model.*;

public class Lizzle extends Pokemon implements FireType {
	public Lizzle(int number, String name){
		super(number, name);
	}
	public Lizzle(String name){
		super(0, name);
	}
	public Lizzle(){
		super(0, "Lizzle");
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
	
	public Pokemon bite(Pokemon target){
		return Attacks.bite(target);
	}
	
}
