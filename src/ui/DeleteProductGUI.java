package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void goBack(ActionEvent event) {

    }

}
