package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Veterinary;

public class AddOwnerAndPatientGUI {

	private MainMenuGUI mainMenu;
	private Veterinary veterinary;
	private VeterinaryMenuGUI veterinaryMenu;
	
    @FXML
    private TextField patientName;

    @FXML
    private TextField patientID;

    @FXML
    private TextField patientRace;

    @FXML
    private TextField patientAge;

    @FXML
    private ComboBox<String> patientOwner;

    @FXML
    private ComboBox<String> patientSpecie;

    @FXML
    private TextArea PatientDescription;

    @FXML
    private ComboBox<String> PatientStatus;
    
    @FXML
    private TextField ownerName;

    @FXML
    private TextField ownerLastName;

    @FXML
    private TextField ownerAddress;

    @FXML
    private TextField ownerNumber;
    
    public AddOwnerAndPatientGUI(MainMenuGUI mm,VeterinaryMenuGUI vm,Veterinary v) {
    	mainMenu = mm;
    	veterinaryMenu = vm;
    	veterinary = v;
    }
    
    @FXML
    public void addPatient(ActionEvent event) {
    	try {
			returnToPrevScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void addOwner(ActionEvent event) {
    	try {
			returnToPrevScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void returnToPrevScreen() throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VeterinaryMenu.fxml"));
    	fxmlLoader.setController(veterinaryMenu);
    	
    	Parent VeterinaryMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(VeterinaryMenuPane);
    	
    }
	
}
