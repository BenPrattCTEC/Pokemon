package pokemon.controller;

import java.util.List;
import java.util.ArrayList;
import pokemon.model.*;
import pokemon.model.pokemon.*;
import pokemon.view.*;

public class PokemonController {
	private List<Pokemon> pokedex;
	
	PokemonFrame frame;
	
	public PokemonController() {
		pokedex = new ArrayList<Pokemon>();
		// build pokedex
		pokedex.add(new BurnySparkydo());
		pokedex.add(new Drago());
		pokedex.add(new FishFace());
		pokedex.add(new Lizzle());
		pokedex.add(new Molar());
		pokedex.add(new Sparkydo());
		
	}
	
	public void start() {
		// start program
		frame = new PokemonFrame(this);
	}
	
	public String[] convertPokedex() {
		String[] names = new String[pokedex.size()];
		
		for (int i = 0; i < pokedex.size(); i++) {
			names[i] = pokedex.get(i).getName();
		}
		return names;
	}
	
	public List<Pokemon> getPokedex() {
		return pokedex;
	}
	
	public boolean isValidInt(String sample) {
		try {
			Integer.parseInt(sample);
		}
		catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidDouble(String sample) {
		try {
			Double.parseDouble(sample);
		}
		catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
}
