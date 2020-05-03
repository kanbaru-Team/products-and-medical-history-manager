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
	private SearchPatientGUI searchPatient;
	private DeletePatientGUI deletePatient;
	
	public VeterinaryMenuGUI(MainMenuGUI mm,Veterinary v) {
		mainMenu = mm;
		veterinary = v;
		if(addOwnerAndPatient==null) {
			addOwnerAndPatient = new AddOwnerAndPatientGUI(mainMenu, this, veterinary);
		}
		if(registeredPatient==null){
			registeredPatient = new RegisteredPatientsGUI(mainMenu, this, veterinary);
		}
		if(searchPatient==null) {
			searchPatient = new SearchPatientGUI(mainMenu,this,veterinary);
		}
		if(deletePatient==null) {
			deletePatient = new DeletePatientGUI(mainMenu, this, veterinary);
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
    public void showHospitalizedPatientsMenu(ActionEvent event) throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/RegisteredPatients.fxml"));
    	fxmlLoader.setController(registeredPatient);
    	
    	Parent registeredPatientsPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(registeredPatientsPane);
    	registeredPatient.initializeTableView();
    	registeredPatient.showAllOptions(false);
    	
    }

    @FXML
    public void showRegisteredPatientsMenu(ActionEvent event) throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/RegisteredPatients.fxml"));
    	fxmlLoader.setController(registeredPatient);
    	
    	Parent registeredPatientsPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(registeredPatientsPane);
    	registeredPatient.initializeTableView();
    	registeredPatient.showAllOptions(true);
    	
    }

    @FXML
    public void showSearchPatientMenu(ActionEvent event) throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/SearchPatient.fxml"));
    	fxmlLoader.setController(searchPatient);
    	
    	Parent searchPatientsPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(searchPatientsPane);
    	registeredPatient.initializeTableView();
    	
    }

    @FXML
    void showAddOwnerMenu(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/AddOwner.fxml"));
    	fxmlLoader.setController(addOwnerAndPatient);
    	
    	Parent addOwnerPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(addOwnerPane);
    }
    
    @FXML
    void showDeletePatientMenu(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/DeletePatient.fxml"));
    	fxmlLoader.setController(deletePatient);
    	
    	Parent addOwnerPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(addOwnerPane);
    }
}
