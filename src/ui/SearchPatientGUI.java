package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Veterinary;

public class SearchPatientGUI {
	
	private MainMenuGUI mainMenu;
	private VeterinaryMenuGUI veterinaryMenu;
	private Veterinary veterinary;

    @FXML
    private TextField id;

    @FXML
    private Label message;

    @FXML
    private TextField information;

    public SearchPatientGUI(MainMenuGUI mm,VeterinaryMenuGUI vm,Veterinary v) {
    	mainMenu = mm;
    	veterinaryMenu = vm;
    	veterinary = v;
    }
    
    @FXML
    public void returnToPrevScreen(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VeterinaryMenu.fxml"));
    	fxmlLoader.setController(veterinaryMenu);
    	
    	Parent VeterinaryMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(VeterinaryMenuPane);
    	
    }

    @FXML
    public void searchPatient(ActionEvent event) {

    }
    
	
}
