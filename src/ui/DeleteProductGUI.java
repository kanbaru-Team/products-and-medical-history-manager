package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import model.Veterinary;

public class DeleteProductGUI {
	
	private  Veterinary veterinary;
	private StoreMenuGUI storeMenu;
	private MainMenuGUI mainMenu;
	
	public DeleteProductGUI(Veterinary v,StoreMenuGUI sm,MainMenuGUI mm) {
		veterinary = v;
		storeMenu=sm;
		mainMenu=mm;
	}
	
    @FXML
    private TextField productTxt;

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storeMenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(StoreMenuPane);
    	storeMenu.initializeComboBox();
    }

}
