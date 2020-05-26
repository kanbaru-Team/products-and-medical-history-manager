package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Animal;
import model.Bird;
import model.Cat;
import model.Dog;
import model.Owner;
import model.Rodent;
import model.Veterinary;

public class AddOwnerAndPatientGUI {

	private MainMenuGUI mainMenu;
	private Veterinary veterinary;
	private VeterinaryMenuGUI veterinaryMenu;
	
    @FXML
    private TextField patientName;

    @FXML
    private TextField patientID;

    @FXML
    private TextField patientRace;

    @FXML
    private TextField patientAge;

    @FXML
    private ComboBox<String> patientOwner;

    @FXML
    private ComboBox<String> patientSpecie;

    @FXML
    private TextArea PatientDescription;

    @FXML
    private ComboBox<String> PatientStatus;
    
    @FXML
    private TextField ownerName;

    @FXML
    private TextField ownerLastName;

    @FXML
    private TextField ownerAddress;

    @FXML
    private TextField ownerNumber;
    
    @FXML
    private Label other;

    @FXML
    private ComboBox<String> otherField;
    
    public AddOwnerAndPatientGUI(MainMenuGUI mm,VeterinaryMenuGUI vm,Veterinary v) {
    	mainMenu = mm;
    	veterinaryMenu = vm;
    	veterinary = v;
    }
    
    @FXML
    public void addPatient(ActionEvent event) {
    	
    	if(!patientName.getText().isEmpty() && !patientID.getText().isEmpty() && !patientRace.getText().isEmpty() && !patientAge.getText().isEmpty() && !PatientDescription.getText().isEmpty() && !patientOwner.getValue().equalsIgnoreCase("none") && !PatientStatus.getValue().equalsIgnoreCase("none") && !patientSpecie.getValue().equalsIgnoreCase("none") && !otherField.getValue().equalsIgnoreCase("none")) {

    		try{

    			String name = patientName.getText();
    			Long.parseLong(patientID.getText());
    			String id = patientID.getText();
    			String race = patientRace.getText();
    			int age = Integer.parseInt(patientAge.getText());
    			String description = PatientDescription.getText();
    			String state = PatientStatus.getValue();
    			String medicalHistory = "medical history: ";
    			Owner owner= veterinary.lookForOwner(Long.parseLong(patientOwner.getValue()));
    			String other = otherField.getValue();
    			String specie = patientSpecie.getValue();
    			int specieNum = -1;

    			if(specie.equalsIgnoreCase("Canino")) {
    				specieNum = 0;
    			}else if(specie.equalsIgnoreCase("Felino")) {
    				specieNum = 1;
    			}else if(specie.equalsIgnoreCase("Ave")) {
    				specieNum = 2;
    			}else if(specie.equalsIgnoreCase("Roedor")) {
    				specieNum = 3;
    			}
    			
    			veterinary.addPatient(name, id, race, age, description, state, medicalHistory, owner, other, specieNum);
    			
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Alert");
        	    alert.setContentText("patiente added successfully");
        	    alert.showAndWait();

    		}catch(NumberFormatException e) {
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Alert");
        	    alert.setContentText("age and id must be numeric");
        	    alert.showAndWait();
    		}
    			
    	}else {
    	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Alert");
    	    alert.setContentText("some fiels are empty");
    	    alert.showAndWait();
    	}
    	
    	try {
			returnToPrevScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void addOwner(ActionEvent event) {
	
    	if(!ownerName.getText().isEmpty() && !ownerLastName.getText().isEmpty() && !ownerAddress.getText().isEmpty() && !ownerNumber.getText().isEmpty()) {
    	
    		try {
    			String name = ownerName.getText();
    			long id = Long.parseLong(ownerLastName.getText());
    			String address = ownerAddress.getText();
    			String number = ownerAddress.getText();
    			
    			veterinary.addOwner(id, name, address, number);
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Alert");
        	    alert.setContentText("el dueño fue agregado con exito");
        	    alert.showAndWait();
    		}catch(NumberFormatException e) {
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Alert");
        	    alert.setContentText("id must be numeric");
        	    alert.showAndWait();
    		}
    	}else {
    	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Alert");
    	    alert.setContentText("some fiels are empty");
    	    alert.showAndWait();
    	}
    	
    	try {
			returnToPrevScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void returnToPrevScreen() throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VeterinaryMenu.fxml"));
    	fxmlLoader.setController(veterinaryMenu);
    	
    	Parent VeterinaryMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(VeterinaryMenuPane);
    	
    }
    
    public void initializateStatus() {
    	PatientStatus.setValue("none");
    	PatientStatus.getItems().addAll( Animal.HEALTHY,Animal.HOSPITALIZED,Animal.TREATMENT );
    }
	
    public void initializeSpecie() {
    	patientSpecie.setValue("none");
    	patientSpecie.getItems().addAll("Canino","Felino","Ave","Roedor");
    }
    
    public void initializeOwner() {
    	patientOwner.setValue("none");
    	patientOwner.getItems().addAll(veterinary.showAllOwner());
    	patientOwner.setVisibleRowCount(8);
    }
    
    public void initiaLizeOther() {
    	other.setVisible(false);
    	otherField.setVisible(false);
    }
    
    public void putVisibleOther() {
    	other.setVisible(true);
    	otherField.setVisible(true);
    }
    
    
    public void showOther() {
    	putVisibleOther();
    	
   		otherField.getItems().clear();
   		otherField.setValue("none");
    	if(patientSpecie.getValue().equalsIgnoreCase("Canino")) {
    		other.setText("talla: ");
    		otherField.getItems().addAll(Dog.PUPPY,Dog.ADULT_LITTLE_RACE,Dog.ADULT_BIG_RACE);
    	}else if(patientSpecie.getValue().equalsIgnoreCase("Felino")) {
    		other.setText("comportamiento: ");
    		otherField.getItems().addAll(Cat.HOMELIKE,Cat.HUNTER,Cat.RESTLESS,Cat.SEDENTARY);
    	}else if(patientSpecie.getValue().equalsIgnoreCase("Ave")) {
    		other.setText("color: ");
    		otherField.getItems().addAll(Bird.YELLOW,Bird.GREEN,Bird.BLUE,Bird.RED);
    	}else if(patientSpecie.getValue().equalsIgnoreCase("Roedor")) {
    		other.setText("tipo de cola: ");
    		otherField.getItems().addAll(Rodent.LARGE_TAIL,Rodent.SHORT_TAIL);
    	}
    }
}
