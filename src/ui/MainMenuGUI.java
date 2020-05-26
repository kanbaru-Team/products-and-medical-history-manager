package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.Veterinary;
import threads.ClockThread;

public class MainMenuGUI {

    @FXML
    private Label clock;
	
	@FXML
	private BorderPane mainPane;
	private Veterinary veterinary;
	private VeterinaryMenuGUI veterinaryMenu;
	private StoreMenuGUI storeMenu;
	
	public MainMenuGUI(Veterinary v) {
		veterinary = v;
		if(veterinaryMenu==null) {
			veterinaryMenu = new VeterinaryMenuGUI(this,veterinary);
		}
		if(storeMenu==null) {
			storeMenu = new StoreMenuGUI(v,this);
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
    public void showStoreMenu(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storeMenu);
    	
    	Parent storeMenuPane = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setCenter(storeMenuPane);
    	storeMenu.initializeComboBox();
    } 
    
    public void initialize() {
    	ClockThread clock = new ClockThread(this,veterinary);
    	clock.start();
    }
	
    public BorderPane getMainPane() {
    	return mainPane;
    }
    
    public void setChronometer(String time) {
    	clock.setText(time); 
    }
    
}