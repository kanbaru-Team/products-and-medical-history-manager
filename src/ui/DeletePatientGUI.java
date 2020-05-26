package ui;

import java.io.IOException;

import customException.PatientNotFoundException;
import customException.ProductNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Veterinary;

public class DeletePatientGUI {
	
	private Veterinary veterinary;
	private VeterinaryMenuGUI veterinaryMenu;
	private MainMenuGUI mainMenu;
	
    @FXML
    private TextField patiendID;
    
    public DeletePatientGUI(MainMenuGUI mm,VeterinaryMenuGUI vm,Veterinary v) {
    	mainMenu = mm;
    	veterinaryMenu = vm;
    	veterinary = v;
    }

    @FXML
    void deletePatient(ActionEvent event) {
    	if(!patiendID.getText().isEmpty()) {
    		try {
    			Integer.parseInt(patiendID.getText());
    			veterinary.deletePatient(patiendID.getText());
    			
       			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText("patient deleted");
    			alert.showAndWait();
    			
    		}catch(NumberFormatException e) {
       			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText("value given must be numeric");
    			alert.showAndWait();
    		}catch (PatientNotFoundException e) {
       			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText(e.toString());
    			alert.showAndWait();
			}
    		
    	}else {
   			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Alert");
			alert.setContentText("field for reference number is empty");
			alert.showAndWait();
    	}
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VeterinaryMenu.fxml"));
    	fxmlLoader.setController(veterinaryMenu);
    	
    	Parent VeterinaryMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(VeterinaryMenuPane);
    	
    }

}
