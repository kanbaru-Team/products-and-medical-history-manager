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
	private StoreMenuGUI storemenu;
	private MainMenuGUI mainmenu;
	
	public DeleteProductGUI(Veterinary v,StoreMenuGUI sm,MainMenuGUI mm) {
		veterinary = v;
		storemenu=sm;
		mainmenu=mm;
	}
	
    @FXML
    private TextField productTxt;

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storemenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainmenu.getMainPane().getChildren().clear();
    	mainmenu.getMainPane().setCenter(StoreMenuPane);
    }

}
