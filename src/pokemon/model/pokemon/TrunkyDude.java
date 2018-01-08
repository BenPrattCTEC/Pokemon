package pokemon.model.pokemon;

import pokemon.model.*;

public class TrunkyDude extends Pokemon implements EarthType{
	public TrunkyDude(int number, String name){
		super(number, name);	
	}
	public TrunkyDude(String name){
		super(0, name);	
	}
	public TrunkyDude(){
		super(0, "TrunkyDude");	
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
	
	public Pokemon crush(Pokemon target){
		return Attacks.stomp(target);
	}
}
