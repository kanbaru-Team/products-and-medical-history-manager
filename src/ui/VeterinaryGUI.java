package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import model.Veterinary;

public class VeterinaryGUI {

    @FXML
    private BorderPane mainPane;//panel principal
    
    Veterinary veterinary;
    
    public VeterinaryGUI(Veterinary v) {
		veterinary = v;
	}
    
    //metodo para mostrar el menu de la tienda en la pantalla principal
    @FXML
    public void showMedicalHistoryMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VeterinaryMenu.fxml"));
    	fxmlLoader.setController(this);
    	
    	BorderPane medicalHistoryPane = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setCenter(medicalHistoryPane);
    }

    //metodo para mostrar el menu del historial medico en la pantalla principal
    @FXML
    public void showStoreMenu(ActionEvent event) {

    }
    
    //metodo para mostrar el menu de buscar un paciente 
    @FXML
    public void showLookPatientMenu(ActionEvent event) {

    }
    
    //metodo para mostrar el menu de añadir un nuevo paciente
    @FXML
    public void showAddPatientMenu(ActionEvent event) {

    }
    
    //metodo para mostrar el menu de ver los pacientes hospitalizados
    @FXML
    public void showHospitalizedPatientsMenu(ActionEvent event) {

    }
	
    //metodo para mostrar el menu de ver los pacientes registrados
    @FXML
    void showRegisteredPatientsMenu(ActionEvent event) {

    }
	
}
