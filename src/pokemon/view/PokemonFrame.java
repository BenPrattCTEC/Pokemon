package pokemon.view;

import java.awt.*;
import javax.swing.JFrame;
import pokemon.controller.PokemonController;
import pokemon.view.PokemonPanel;

public class PokemonFrame extends JFrame {
	private PokemonController controller;
	private PokemonPanel panel;
	
	public PokemonFrame(PokemonController controller){
		super();
		
		this.controller = controller;
		this.panel = new PokemonPanel(controller);
		
		setupFrame();
		
	}
	
	/**
	 * Initializes JFrame
	 */
	private void setupFrame(){
		
		this.setContentPane(panel);
		this.setSize(900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	/**
	 * gets the instance of ChatbotController
	 * @return instance of ChatbotController
	 */
	public PokemonController getBaseController(){
		return controller;
	}
	
	/**
	 * gets the instance of ChatbotController
	 * @return instance of ChatbotController
	 */

	public PokemonPanel getContentPane(){
		return panel;
	}
	
}
