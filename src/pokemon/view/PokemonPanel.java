package pokemon.view;

import pokemon.controller.PokemonController;
import pokemon.model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class PokemonPanel extends JPanel {
	
	private PokemonController controller;
	private SpringLayout layout;
	
	private JLabel healthLabel;
	private JLabel attackLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel evolvableLabel;
	private JLabel modifierLabel;
	private JLabel iconLabel;
	
	private JCheckBox evolvableBox;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField attackField;
	private JTextField healthField;
	private JTextField modifierField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox<String> pokedexDropdown;
	
	private JPanel firstType;
	private JPanel secondType;
	private JPanel thirdType;
	private JPanel fourthType;
	
	public PokemonPanel(PokemonController controller) {
		super();
		this.controller = controller;
		
		layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupComboBox();
		setupListeners();
	}
	
	private void updateImage(){
		
	}

	
	private void updatePokedexInfo(int index) {
		nameField.setText(controller.getPokedex().get(index).getName());
		evolvableBox.setSelected(controller.getPokedex().get(index).isCanEvolve());
		numberField.setText(controller.getPokedex().get(index).getNumber() + "");
		attackField.setText(controller.getPokedex().get(index).getAttackPoints() + "");
		modifierField.setText(controller.getPokedex().get(index).getEnhancementModifier() + "");
	}
	
	private void setupComboBox() {
		DefaultComboBoxModel pokemonModel = new DefaultComboBoxModel(controller.convertPokedex());
		pokedexDropdown.setModel(pokemonModel);
	}
	
	private void updateTypePanels() {
		String[] types = controller.getPokedex().get(pokedexDropdown.getSelectedIndex()).getPokemonTypes();
		firstType.setBackground(Color.LIGHT_GRAY);
		secondType.setBackground(Color.LIGHT_GRAY);
		thirdType.setBackground(Color.LIGHT_GRAY);
		fourthType.setBackground(Color.LIGHT_GRAY);
		try {
			switch (types[0]) {
				case "EarthType":
					firstType.setBackground(Color.BLACK);
					break;
				case "ElectricType":
					firstType.setBackground(Color.YELLOW);
					break;
				case "FireType":
					firstType.setBackground(Color.RED);
					break;
				case "WaterType":
					firstType.setBackground(Color.BLUE);
					break;
			}
			switch (types[1]) {
				case "EarthType":
					secondType.setBackground(Color.BLACK);
					break;
				case "ElectricType":
					secondType.setBackground(Color.YELLOW);
					break;
				case "FireType":
					secondType.setBackground(Color.RED);
					break;
				case "WaterType":
					secondType.setBackground(Color.BLUE);
					break;
				default:
			}
			switch (types[2]) {
				case "EarthType":
					thirdType.setBackground(Color.BLACK);
					break;
				case "ElectricType":
					thirdType.setBackground(Color.YELLOW);
					break;
				case "FireType":
					thirdType.setBackground(Color.RED);
					break;
				case "WaterType":
					thirdType.setBackground(Color.BLUE);
					break;
			}
			switch (types[3]) {
				case "EarthType":
					fourthType.setBackground(Color.BLACK);
					break;
				case "ElectricType":
					fourthType.setBackground(Color.YELLOW);
					break;
				case "FireType":
					fourthType.setBackground(Color.RED);
					break;
				case "WaterType":
					fourthType.setBackground(Color.BLUE);
					break;
			}
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	/**
	 * Sets up the Panel
	 */
	private void setupPanel() {
		this.setBackground(Color.GRAY);
		
		this.setLayout(layout);
		
		healthLabel = new JLabel("Health");
		layout.putConstraint(SpringLayout.WEST, healthLabel, 57, SpringLayout.WEST, this);
		attackLabel = new JLabel("Attack");
		nameLabel = new JLabel("Name");
		layout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, healthLabel);
		layout.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, attackLabel);
		numberLabel = new JLabel("Number");
		layout.putConstraint(SpringLayout.NORTH, attackLabel, 0, SpringLayout.NORTH, numberLabel);
		layout.putConstraint(SpringLayout.WEST, attackLabel, 109, SpringLayout.EAST, numberLabel);
		layout.putConstraint(SpringLayout.NORTH, numberLabel, 167, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, healthLabel, -12, SpringLayout.NORTH, numberLabel);
		layout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, healthLabel);
		evolvableLabel = new JLabel("Evolvable");
		layout.putConstraint(SpringLayout.NORTH, evolvableLabel, 16, SpringLayout.SOUTH, numberLabel);
		layout.putConstraint(SpringLayout.EAST, evolvableLabel, 0, SpringLayout.EAST, healthLabel);
		modifierLabel = new JLabel("Modifier");
		layout.putConstraint(SpringLayout.NORTH, modifierLabel, 0, SpringLayout.NORTH, evolvableLabel);
		
		// iconLabel = new JLabel("");
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/assets/default.png")), JLabel.CENTER);
		
		evolvableBox = new JCheckBox();
		layout.putConstraint(SpringLayout.WEST, modifierLabel, 54, SpringLayout.EAST, evolvableBox);
		layout.putConstraint(SpringLayout.EAST, modifierLabel, 110, SpringLayout.EAST, evolvableBox);
		layout.putConstraint(SpringLayout.NORTH, evolvableBox, 0, SpringLayout.NORTH, evolvableLabel);
		layout.putConstraint(SpringLayout.WEST, evolvableBox, 22, SpringLayout.EAST, evolvableLabel);
		nameField = new JTextField();
		layout.putConstraint(SpringLayout.WEST, iconLabel, 143, SpringLayout.EAST, nameField);
		numberField = new JTextField();
		attackField = new JTextField();
		healthField = new JTextField();
		modifierField = new JTextField();
		
		descriptionArea = new JTextArea(5, 10);
		typeArea = new JTextArea(4, 15);
		
		saveButton = new JButton("Save");
		layout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, saveButton, -31, SpringLayout.EAST, this);
		clearButton = new JButton("Clear");
		layout.putConstraint(SpringLayout.SOUTH, clearButton, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, clearButton, -6, SpringLayout.WEST, saveButton);
		pokedexDropdown = new JComboBox();
		layout.putConstraint(SpringLayout.NORTH, iconLabel, 5, SpringLayout.NORTH, pokedexDropdown);
		layout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, pokedexDropdown, -10, SpringLayout.EAST, this);
		
		firstType = new JPanel();
		secondType = new JPanel();
		thirdType = new JPanel();
		fourthType = new JPanel();
		
		this.add(healthLabel);
		this.add(attackLabel);
		this.add(nameLabel);
		this.add(numberLabel);
		this.add(evolvableLabel);
		this.add(modifierLabel);
		this.add(iconLabel);
		
		this.add(evolvableBox);
		this.add(nameField);
		this.add(numberField);
		this.add(attackField);
		this.add(healthField);
		this.add(modifierField);
		
		this.add(descriptionArea);
		this.add(typeArea);
		
		this.add(saveButton);
		this.add(clearButton);
		this.add(pokedexDropdown);
		
		this.add(firstType);
		this.add(secondType);
		this.add(thirdType);
		this.add(fourthType);
	}
	
	/**
	 * sets up the Layout
	 */
	private void setupLayout() {
		
	}
	
	/**
	 * sets up all of the listeners
	 */
	private void setupListeners() {
		
		pokedexDropdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent selection) {
				updatePokedexInfo(pokedexDropdown.getSelectedIndex());
				updateImage();
				updateTypePanels();
				repaint();
			}
		});
	}
}
