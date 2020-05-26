package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Animal;
import model.Veterinary;

public class ProfilePatientGUI {

	private MainMenuGUI mainMenu;
	private Veterinary veterinary;
	private Animal patient;
	private CreateMedicalRecordGUI medRecord;
	private SearchPatientGUI searchPat;
	
	public ProfilePatientGUI(MainMenuGUI menu,Veterinary vet,Animal pat,SearchPatientGUI searchPat) {
		mainMenu=menu;
		veterinary=vet;
		patient=pat;
		this.searchPat=searchPat;
	}
    @FXML
    private Label patientName;

    @FXML
    private Label patientAge;

    @FXML
    private Label patientID;

    @FXML
    private Label patientSpecie;

    @FXML
    private Label patientRace;

    @FXML
    private Label patientStatus;

    @FXML
    private Label patientDescription;
    
    @FXML
    private ComboBox<String> newStatus;
    
    @FXML
    public void initialize() {
    	patientName.setText(patient.getName());
    	patientAge.setText(patient.getAge());
    	patientID.setText(patient.getId());
    	patientSpecie.setText(patient.getSpecie());
    	patientRace.setText(patient.getRace());
    	patientStatus.setText(patient.getStatus());
    	patientDescription.setText(patient.getDescription());
    }
    @FXML
    public void changeStatus(ActionEvent event) {
    	//hacer metthod
    }

    @FXML
    public void generateReport(ActionEvent event) {
    	
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/SearchPatient.fxml"));
    	fxmlLoader.setController(searchPat);
    	
    	Parent SearchPatient = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(SearchPatient);
    }

    @FXML
    public void updateMedicalRecord(ActionEvent event) throws IOException {
    	medRecord= new CreateMedicalRecordGUI(veterinary, this, mainMenu, patient.getId());
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/CreateMedicalRecord.fxml"));
    	fxmlLoader.setController(medRecord);
    	
    	Parent MedicalRecord = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(MedicalRecord);
    }
    @FXML
    public void initializeComboBox(ActionEvent event)  {
    	newStatus.getItems().addAll(Animal.HOSPITALIZED,Animal.HEALTHY,Animal.TREATMENT);
    }
    

}