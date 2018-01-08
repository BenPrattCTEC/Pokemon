package pokemon.model.pokemon;

import pokemon.model.*;

public class Sparkydo extends Pokemon implements ElectricType {
	public Sparkydo(int number, String name){
		super(number, name);
	}
	public Sparkydo(String name){
		super(0, name);
	}
	public Sparkydo(){
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
