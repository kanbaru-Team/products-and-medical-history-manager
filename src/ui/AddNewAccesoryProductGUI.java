package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Veterinary;

public class AddNewAccesoryProductGUI {
	private  Veterinary vet;
	private StoreMenuGUI storeMenu;
	private MainMenuGUI mainMenu;
	
    public AddNewAccesoryProductGUI(Veterinary vet, StoreMenuGUI storemenu, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storeMenu = storemenu;
		this.mainMenu = mainmenu;
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
       	if(!newProductName.getText().isEmpty() && !newProductColor.getText().isEmpty() && !newProductQuantity.getText().isEmpty()  && !newProductID.getText().isEmpty()  &&  !newProductPrice.getText().isEmpty() && !newProductCost.getText().isEmpty()) {
    		try {
	    		String name = newProductName.getText();
	        	String color = newProductColor.getText();
	        	int stockUnits = Integer.parseInt(newProductQuantity.getText());
	        	int refNumber = Integer.parseInt(newProductID.getText());
	        	int price = Integer.parseInt(newProductPrice.getText());
	        	int cost = Integer.parseInt(newProductCost.getText());
	    		
	        	vet.addProduct(name,  price,  refNumber,  stockUnits,  0,cost,  "Accessory", color);
	        	
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Alert");
        	    alert.setContentText("el producto fue agregado con exito");
        	    alert.showAndWait();
	        	
    		} catch(NumberFormatException e) {
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Alert");
        	    alert.setContentText("en cantidad, precio, numero de referencia \n y costo se debe ingresar un valor numerico");
        	    alert.showAndWait();
    		}
    	}else {
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	    alert.setHeaderText(null);
     	    alert.setTitle("Alert");
     	    alert.setContentText("algunos campos estan vacios, se deben llenar todos");
     	    alert.showAndWait();
    	}
    }

    @FXML
    void showMedicalHistoryMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storeMenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(StoreMenuPane);
    	storeMenu.initializeComboBox();
    }

}
