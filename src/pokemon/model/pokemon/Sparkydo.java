package pokemon.model.pokemon;

import pokemon.model.*;

public class Sparkydo extends Pokemon implements ElectricType {
	Sparkydo(int number, String name){
		super(number, name);
	}
	Sparkydo(String name){
		super(0, name);
	}
	Sparkydo(){
		super(0, "Sparkydo");
	}
	
	public Pokemon spark(Pokemon target){
		return Attacks.spark(target);
	}
	
	public Pokemon zap(Pokemon target){
		return Attacks.zap(target);
	}
	
	public Pokemon shock(Pokemon target){
		return Attacks.shock(target);
	}
	
	public Pokemon electrocute(Pokemon target){
		return Attacks.electrocute(target);
	}
	
}
