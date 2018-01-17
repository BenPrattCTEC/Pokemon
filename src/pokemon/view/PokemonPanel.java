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
		String path = "pokemon/assets/";
		String defaultName = "default";
		String name = pokedexDropdown.getSelectedItem().toString();
		String extention = ".png";
		ImageIcon pokemonIcon;
		
		try{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extention));
		}
		catch(NullPointerException e){
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extention));
		}
		iconLabel.setIcon(pokemonIcon);
	}

	
	private void updatePokedexInfo(int index) {
		nameField.setText(controller.getPokedex().get(index).getName());
		evolvableBox.setSelected(controller.getPokedex().get(index).isCanEvolve());
		numberField.setText(controller.getPokedex().get(index).getNumber() + "");
		attackField.setText(controller.getPokedex().get(index).getAttackPoints() + "");
		modifierField.setText(controller.getPokedex().get(index).getEnhancementModifier() + "");
		
		descriptionArea.setText(controller.getPokedex().get(index).toString());
		typeArea.setText("");
		
		for(String current: controller.getPokedex().get(index).getPokemonTypes()){
			typeArea.append(current + "\n");
		}
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
		layout.putConstraint(SpringLayout.WEST, iconLabel, 2, SpringLayout.EAST, evolvableBox);
		layout.putConstraint(SpringLayout.WEST, modifierLabel, 54, SpringLayout.EAST, evolvableBox);
		layout.putConstraint(SpringLayout.EAST, modifierLabel, 110, SpringLayout.EAST, evolvableBox);
		layout.putConstraint(SpringLayout.NORTH, evolvableBox, 0, SpringLayout.NORTH, evolvableLabel);
		layout.putConstraint(SpringLayout.WEST, evolvableBox, 22, SpringLayout.EAST, evolvableLabel);
		nameField = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, nameField, -2, SpringLayout.NORTH, healthLabel);
		layout.putConstraint(SpringLayout.WEST, nameField, 285, SpringLayout.WEST, this);
		numberField = new JTextField();
		attackField = new JTextField();
		healthField = new JTextField();
		modifierField = new JTextField();
		
		descriptionArea = new JTextArea(5, 10);
		layout.putConstraint(SpringLayout.WEST, descriptionArea, 21, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, descriptionArea, 0, SpringLayout.SOUTH, this);
		typeArea = new JTextArea(4, 15);
		layout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, typeArea);
		layout.putConstraint(SpringLayout.NORTH, typeArea, 0, SpringLayout.NORTH, descriptionArea);
		
		saveButton = new JButton("Save");
		layout.putConstraint(SpringLayout.EAST, typeArea, -23, SpringLayout.WEST, saveButton);
		layout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, saveButton, -10, SpringLayout.EAST, this);
		clearButton = new JButton("Clear");
		layout.putConstraint(SpringLayout.WEST, clearButton, 0, SpringLayout.WEST, saveButton);
		layout.putConstraint(SpringLayout.SOUTH, clearButton, -6, SpringLayout.NORTH, saveButton);
		pokedexDropdown = new JComboBox();
		layout.putConstraint(SpringLayout.NORTH, iconLabel, 5, SpringLayout.NORTH, pokedexDropdown);
		layout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, pokedexDropdown, -10, SpringLayout.EAST, this);
		
		firstType = new JPanel();
		layout.putConstraint(SpringLayout.WEST, firstType, 0, SpringLayout.WEST, evolvableLabel);
		layout.putConstraint(SpringLayout.SOUTH, firstType, -70, SpringLayout.NORTH, evolvableLabel);
		secondType = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, secondType, 0, SpringLayout.NORTH, firstType);
		layout.putConstraint(SpringLayout.WEST, secondType, 0, SpringLayout.WEST, healthLabel);
		thirdType = new JPanel();
		layout.putConstraint(SpringLayout.SOUTH, thirdType, 0, SpringLayout.SOUTH, firstType);
		fourthType = new JPanel();
		layout.putConstraint(SpringLayout.EAST, thirdType, -11, SpringLayout.WEST, fourthType);
		layout.putConstraint(SpringLayout.NORTH, fourthType, 0, SpringLayout.NORTH, firstType);
		layout.putConstraint(SpringLayout.WEST, fourthType, 38, SpringLayout.EAST, secondType);
		
		this.add(healthLabel);
		this.add(attackLabel);
		this.add(nameLabel);
		this.add(numberLabel);
		this.add(evolvableLabel);
		this.add(modifierLabel);
//		this.add(iconLabel);
		
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
	
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click){
				System.out.println("Save Clicked");
				if(controller.isValidInt(attackField.getText()) && controller.isValidInt(healthField.getText()) && controller.isValidDouble(modifierField.getText())){
					int selected = pokedexDropdown.getSelectedIndex();
					int health = Integer.parseInt(healthField.getText());
					int attack = Integer.parseInt(attackField.getText());
					double modifier = Double.parseDouble(modifierField.getText());
					String name = nameField.getText();
					boolean evolvable = evolvableBox.isSelected();
					
					controller.updateSelected(selected, health, attack, evolvable, modifier, name);
				}
				else {
					System.out.println("one or more fields are invalid");
				}
			}
		});
	}
}
