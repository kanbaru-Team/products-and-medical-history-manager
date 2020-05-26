package ui;

import java.io.IOException;

import customException.ProductNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Product;
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
    private TextArea txtToShowProduct;

    @FXML
    private TextField unitstoAdd;

    @FXML
    public void increaseStock(ActionEvent event) {
    	if(!RefNum.getText().isEmpty() && !unitstoAdd.getText().isEmpty()) {
    		try {
    			Integer.parseInt(RefNum.getText());
    			int units = Integer.parseInt(unitstoAdd.getText());
    			
    			vet.increaseStock(RefNum.getText(), units);
    			
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText("stock aumentado correctamente");
    			alert.showAndWait();
    			
    		}catch(NumberFormatException e) {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText("en ambos campos se deben ingresar solo numeros");
    			alert.showAndWait();
    		} catch (ProductNotFoundException e) {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText(e.toString());
    			alert.showAndWait();
			}
    	}else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Alert");
			alert.setContentText("el campo para el numero de referencia"
					+ "\n o para la cantidad de unidades a añadir esta vacio");
			alert.showAndWait();
    	}
    }

    @FXML
    public void searchProduct(ActionEvent event) {
    	
    	if(!RefNum.getText().isEmpty()) {
    		String ref = RefNum.getText();
    		Product p;
			try {
				p = vet.lookForProduct(ref);
				txtToShowProduct.setText(p.toString());
			} catch (ProductNotFoundException e) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText("Error");
    			alert.setTitle("Alert");
    			alert.setContentText(e.toString());
    			alert.showAndWait();
			}  		
    	}else {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Error");
			alert.setTitle("Alert");
			alert.setContentText("Please enter a reference to search a ");
			alert.showAndWait();
    	}
    	
    			
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
