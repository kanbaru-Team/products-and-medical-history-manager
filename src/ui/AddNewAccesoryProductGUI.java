package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Veterinary;

public class AddNewAccesoryProductGUI {
	private  Veterinary vet;
	private StoreMenuGUI storemenu;
	private MainMenuGUI mainmenu;
	
    public AddNewAccesoryProductGUI(Veterinary vet, StoreMenuGUI storemenu, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storemenu = storemenu;
		this.mainmenu = mainmenu;
	}

	@FXML
    private TextField newProductQuantity;

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
    void createNewAccessoryProduct(ActionEvent event) {

    }

    @FXML
    void showMedicalHistoryMenu(ActionEvent event) {

    }

}
