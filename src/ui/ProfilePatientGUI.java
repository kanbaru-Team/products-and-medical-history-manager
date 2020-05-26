package ui;

import java.io.IOException;

import customException.MedicalRecordDontExistYet;
import customException.PatientNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
    public void changeStatus(ActionEvent event) throws IOException, PatientNotFoundException, MedicalRecordDontExistYet {
    	if(newStatus.getValue().equalsIgnoreCase(Animal.HOSPITALIZED) || newStatus.getValue().equalsIgnoreCase(Animal.TREATMENT) ) {
    		if(patient.getMedicalRecord()!=null) {
    			veterinary.clearMedicalRecord(patient.getId());
    		}
    		patientStatus.setText(newStatus.getValue());
    		if(newStatus.getValue().equalsIgnoreCase(Animal.HOSPITALIZED)) {
    			veterinary.ChangePatientStatus(patient.getId(), Animal.HOSPITALIZED);
    		}else if(newStatus.getValue().equalsIgnoreCase(Animal.TREATMENT)) {
    			veterinary.ChangePatientStatus(patient.getId(), Animal.TREATMENT);
    		}  		
    		veterinary.createMedicalRecord(patient.getId(), " ", " ");
    		medRecord = new CreateMedicalRecordGUI(veterinary, this, mainMenu, patient.getId());
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/CreateMedicalRecord.fxml"));
        	fxmlLoader.setController(medRecord);
        	
        	Parent MedicalRecord = fxmlLoader.load();
        	mainMenu.getMainPane().getChildren().clear();
        	mainMenu.getMainPane().setCenter(MedicalRecord);
    	}else if(newStatus.getValue().equalsIgnoreCase(Animal.HEALTHY)) {
    		veterinary.clearMedicalRecord(patient.getId());
    		veterinary.ChangePatientStatus(patient.getId(), Animal.HEALTHY);
    		patientStatus.setText(Animal.HEALTHY);
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Exito");
			alert.setTitle("Alert");
			alert.setContentText("El estado del paciente ha sido actualizado");
			alert.showAndWait();
    	}
    }

    @FXML
    public void generateReport(ActionEvent event) {
    	
			try {
				veterinary.printMedicalHistory(patient.getId());
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Exito");
				alert.setTitle("Alert");
				alert.setContentText("El reporte ha sido generado");
				alert.showAndWait();
			} catch (IOException e) {
				System.out.println("entra a IOException");
			} catch (PatientNotFoundException e) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Error");
				alert.setTitle("Alert");
				alert.setContentText("El reporte no ha podido ser generado.");
				alert.showAndWait();
			}
		
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
    public void initializeComboBox()  {
    	newStatus.getItems().addAll(Animal.HOSPITALIZED,Animal.HEALTHY,Animal.TREATMENT);
    }
    

}