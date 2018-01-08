package pokemon.model.pokemon;

import pokemon.model.*;

public class FishFace extends Pokemon implements WaterType{
	public FishFace(int number, String name){
		super(number, name);
	}
	public FishFace(String name){
		super(0, name);
	}
	public FishFace(){
		super(0, "FishFace");
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
	
	public Pokemon slap(Pokemon target){
		return Attacks.slap(target);
	}
	
	public Pokemon flood(Pokemon target){
		return Attacks.flood(target);
	}
}
