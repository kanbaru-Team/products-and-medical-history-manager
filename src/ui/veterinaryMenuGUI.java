package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.Veterinary;

public class VeterinaryMenuGUI {
	
	private MainMenuGUI mainMenu;
	private Veterinary veterinary;
	private AddOwnerAndPatientGUI addOwnerAndPatient;
	private RegisteredPatientsGUI registeredPatient;
	
	public VeterinaryMenuGUI(MainMenuGUI mm,Veterinary v) {
		mainMenu = mm;
		veterinary = v;
		if(addOwnerAndPatient==null) {
			addOwnerAndPatient = new AddOwnerAndPatientGUI(mainMenu, this, veterinary);
		}
		if(registeredPatient==null){
			
		}
	}
	
    @FXML
    public void showAddPatientMenu(ActionEvent event) throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/AddPacient.fxml"));
    	fxmlLoader.setController(addOwnerAndPatient);
    	
    	Parent addPatientPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(addPatientPane);
    	
    }

    @FXML
    public void showHospitalizedPatientsMenu(ActionEvent event) {

    }

    @FXML
    public void showRegisteredPatientsMenu(ActionEvent event) throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/AddPacient.fxml"));
    	fxmlLoader.setController(registeredPatient);
    	
    	Parent addPatientPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(addPatientPane);
    	
    }

    @FXML
    public void showSearchPatientMenu(ActionEvent event) {

    }

    @FXML
    void showAddOwnerMenu(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/AddOwner.fxml"));
    	fxmlLoader.setController(addOwnerAndPatient);
    	
    	Parent addPatientPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(addPatientPane);
    }
}
