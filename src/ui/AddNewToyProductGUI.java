package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import model.Veterinary;

public class AddNewToyProductGUI {
	private Veterinary vet;
	private StoreMenuGUI sm;
	private MainMenuGUI mainmenu;
	
    public AddNewToyProductGUI(Veterinary vet, StoreMenuGUI sm, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.sm = sm;
		this.mainmenu = mainmenu;
	}

	@FXML
    private TextField newProductSize;

    @FXML
    private TextField newProductPrice;

    @FXML
    private TextField newProductID;

    @FXML
    private TextField newProductColor;

    @FXML
    private TextField newProductName;

    @FXML
    private TextField newProductCost;

    @FXML
    private TextField newProductQuantity;

    @FXML
    void createNewToyProduct(ActionEvent event) {

    }

    @FXML
    void showMedicalHistoryMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(sm);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainmenu.getMainPane().getChildren().clear();
    	mainmenu.getMainPane().setCenter(StoreMenuPane);
    }

}
