package pokemon.model.pokemon;

import pokemon.model.*;

public class Turtleio extends Pokemon implements WaterType, EarthType {
	Turtleio(int number, String name){
		super(number, name);	
	}
	Turtleio(String name){
		super(0, name);	
	}
	Turtleio(){
		super(0, "Turtleio");	
	}
	
	public Pokemon splash(Pokemon target){
		return Attacks.splash(target);
	}
	
	public Pokemon spray(Pokemon target){
		return Attacks.spray(target);
	}
	
	public Pokemon squirt(Pokemon target){
		return Attacks.squirt(target);
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
}
