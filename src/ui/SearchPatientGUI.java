package ui;

import java.io.IOException;

import customException.PatientNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Animal;
import model.Veterinary;

public class SearchPatientGUI {
	
	private MainMenuGUI mainMenu;
	private VeterinaryMenuGUI veterinaryMenu;
	private Veterinary veterinary;
	private ProfilePatientGUI profile;
	 public SearchPatientGUI(MainMenuGUI mm,VeterinaryMenuGUI vm,Veterinary v) {
	    	mainMenu = mm;
	    	veterinaryMenu = vm;
	    	veterinary = v;
	    }
    @FXML
    private TextField id;

    @FXML
    private Label message;

    @FXML
    private TextField information;

   
    
    @FXML
    public void returnToPrevScreen(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VeterinaryMenu.fxml"));
    	fxmlLoader.setController(veterinaryMenu);
    	
    	Parent VeterinaryMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(VeterinaryMenuPane);
    	
    }

    @FXML
    public void searchPatient(ActionEvent event) throws IOException {
    	try {
    		if(id.getText().isEmpty()) {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText("Error");
    			alert.setTitle("Alert");
    			alert.setContentText("Algunos campos estan vacios. Por favor llene todos los campos");
    			alert.showAndWait();
    		}else {
    			String identification = id.getText();
    			Animal a = veterinary.lookForPatient(identification);
    			showProfile(a);
    		}
    	}catch(NumberFormatException e) {
    		
    	} catch (PatientNotFoundException e) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Error");
			alert.setTitle("Alert");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
    }
    
    public void showProfile(Animal a) throws IOException {
    	profile = new ProfilePatientGUI(mainMenu, veterinary,a,this);
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/ProfilePatient.fxml"));
    	fxmlLoader.setController(profile);
    	
    	Parent ProfilePatient = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(ProfilePatient);
    }
	
}
