package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Veterinary;

public class LookForProductGUI {
	
	private Veterinary vet;
	private StoreMenuGUI storemenu;
	private MainMenuGUI mainmenu;
	
    public LookForProductGUI(Veterinary vet, StoreMenuGUI storemenu, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storemenu = storemenu;
		this.mainmenu = mainmenu;
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

}
