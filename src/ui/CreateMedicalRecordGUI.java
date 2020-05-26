package ui;

import java.io.IOException;

import customException.MedicalRecordDontExistYet;
import customException.PatientNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Veterinary;
	
public class CreateMedicalRecordGUI{
	
	private MainMenuGUI mainMenu;
	private Veterinary veterinary;
	private ProfilePatientGUI profilePatient;
	private String id;
	
	public CreateMedicalRecordGUI(Veterinary vet,ProfilePatientGUI pGUI,MainMenuGUI menu,String id) {
		veterinary=vet;
		profilePatient=pGUI;
		this.id=id;
		mainMenu=menu;
	}
	
	@FXML
	private TextField generalInformation;

	@FXML
	private TextField detailedInformation;

	@FXML
	void createMedicalRecord(ActionEvent event) {
		if(generalInformation.getText().isEmpty() || detailedInformation.getText().isEmpty() ) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Error");
			alert.setTitle("Alert");
			alert.setContentText("Algunos campos estan vacios. Por favor llene todos los campos");
			alert.showAndWait();
		}else {
			String genInfo = generalInformation.getText();
			String detInfo = detailedInformation.getText();
			try {
				veterinary.addGeneralInfo(id);
				veterinary.updateMedicalRecord(id, genInfo, detInfo);
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Exito");
				alert.setTitle("Enhorabuena");
				alert.setContentText("La ficha medica se ha creado exitosamente");
				alert.showAndWait();
				generalInformation.setText("");
				detailedInformation.setText("");
			} catch (PatientNotFoundException e) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Error Inesperado");
				alert.setTitle("Alert");
				alert.setContentText("No se ha podido crear la ficha medica. Intente de nuevo");
				alert.showAndWait();
			} catch (MedicalRecordDontExistYet e) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Error ");
				alert.setTitle("Alert");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}
		
	}
	
	@FXML
    void goBack(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/ProfilePatient.fxml"));
    	fxmlLoader.setController(profilePatient);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(StoreMenuPane);
    	profilePatient.initializeComboBox();
    }

}
