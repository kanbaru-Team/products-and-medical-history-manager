package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
