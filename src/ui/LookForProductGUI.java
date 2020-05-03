package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import model.Veterinary;

public class LookForProductGUI {
	
	private Veterinary vet;
	private StoreMenuGUI storeMenu;
	private MainMenuGUI mainMenu;
	
    public LookForProductGUI(Veterinary vet, StoreMenuGUI storemenu, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storeMenu = storemenu;
		this.mainMenu = mainmenu;
	}

	@FXML
    private TextField RefNum;

    @FXML
    private TextField txtToShowProduct;

    @FXML
    private TextField unitstoAdd;

    @FXML
    void increaseStock(ActionEvent event) {

    }

    @FXML
    void searchProduct(ActionEvent event) {

    }
    @FXML
    public void goBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storeMenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(StoreMenuPane);
    	storeMenu.initializeComboBox();
    }

}
