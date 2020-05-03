package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import model.Veterinary;

public class MainMenuGUI {

	@FXML
	private BorderPane mainPane;
	private Veterinary veterinary;
	private VeterinaryMenuGUI veterinaryMenu;
	
	public MainMenuGUI(Veterinary v) {
		veterinary = v;
		if(veterinaryMenu==null) {
			veterinaryMenu = new VeterinaryMenuGUI(this,veterinary);
		}
	}

	@FXML
	public void showMedicalHistoryMenu(ActionEvent event) throws IOException {
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VeterinaryMenu.fxml"));
    	fxmlLoader.setController(veterinaryMenu);
    	
    	Parent veterinaryMenuPain = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setCenter(veterinaryMenuPain);
		
	}

    @FXML
    public void showStoreMenu(ActionEvent event) {

    } 
	
    public BorderPane getMainPane() {
    	return mainPane;
    }
    
}