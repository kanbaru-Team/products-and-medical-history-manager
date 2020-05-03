package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Veterinary;

public class RegisteredProductsGUI	{
	
	private Veterinary vet;
	private StoreMenuGUI storemenu;
	private MainMenuGUI mainmenu;
	
    public RegisteredProductsGUI(Veterinary vet, StoreMenuGUI storemenu, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storemenu = storemenu;
		this.mainmenu = mainmenu;
	}

	@FXML
    private TableView<?> productsList;

    @FXML
    private TableColumn<?, ?> nameTc;

    @FXML
    private TableColumn<?, ?> refTc;

    @FXML
    private TableColumn<?, ?> priceTc;

    @FXML
    private TableColumn<?, ?> typeTc;

    @FXML
    private TableColumn<?, ?> soldUnitsTc;

    @FXML
    private TableColumn<?, ?> profitsTc;
    
    @FXML
    private ComboBox<?> comboSortBy;

    @FXML
    void goBack(ActionEvent event) {

    }

}
