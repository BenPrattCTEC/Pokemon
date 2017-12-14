package pokemon.model.pokemon;

import pokemon.model.Pokemon;
import pokemon.model.WaterType;

public class FishFace extends Pokemon implements WaterType{
	public FishFace(int number, String name){
		super(number, name);
	}
	
	public Pokemon splash(Pokemon target){
		return target;
	}
	
	public Pokemon spray(Pokemon target){
		return target;
	}
	
	public Pokemon squirt(Pokemon target){
		return target;
	}
	
	public Pokemon slap(Pokemon target){
		return target;
	}
	
	public Pokemon flood(Pokemon target){
		return target;
	}
}
