package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Veterinary;

public class AddNewFoodProductGUI {

	private Veterinary vet;
	private StoreMenuGUI storemenu;
	private MainMenuGUI mainmenu;
	
    public AddNewFoodProductGUI(Veterinary vet, StoreMenuGUI storemenu, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storemenu = storemenu;
		this.mainmenu = mainmenu;
	}

	@FXML
    private TextField newProductWeight;

    @FXML
    private TextField newProductPrice;

    @FXML
    private TextField newProductID;

    @FXML
    private TextField newProductName;

    @FXML
    private ChoiceBox<?> newProductSpecies;

    @FXML
    private TextField newProductQuantity;

    @FXML
    private TextField newProductCost;

    @FXML
    void createNewFoodProduct(ActionEvent event) {

    }

    @FXML
    void showMedicalHistoryMenu(ActionEvent event) {

    }

}
