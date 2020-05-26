package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Veterinary;

public class AddNewToyProductGUI {
	private Veterinary vet;
	private StoreMenuGUI storeMenu;
	private MainMenuGUI mainMenu;
	
    public AddNewToyProductGUI(Veterinary vet, StoreMenuGUI sm, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storeMenu = sm;
		this.mainMenu = mainmenu;
	}

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
    private ChoiceBox<String> newProductSize;

    @FXML
    public void createNewToyProduct(ActionEvent event) {

    	if(!newProductName.getText().isEmpty() && !newProductColor.getText().isEmpty() && newProductSize.getValue()!="none" && !newProductQuantity.getText().isEmpty()  && !newProductID.getText().isEmpty()  &&  !newProductPrice.getText().isEmpty() && !newProductCost.getText().isEmpty()) {
    		try {
	    		String name = newProductName.getText();
	        	String color = newProductColor.getText();
	        	String size = newProductSize.getValue();
	        	int stockUnits = Integer.parseInt(newProductQuantity.getText());
	        	String refNumber = newProductID.getText();
	        	int price = Integer.parseInt(newProductPrice.getText());
	        	int cost = Integer.parseInt(newProductCost.getText());
	    		
	        	vet.addProduct(name,  price,  refNumber,  stockUnits,  0,  cost,"Toy", color, size);
	        	
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Success");
        	    alert.setContentText("The product was added sucessfully!");
        	    alert.showAndWait();
	        	
    		} catch(NumberFormatException e) {
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setHeaderText(null);
        	    alert.setTitle("Alert");
        	    alert.setContentText("Error: Remember that fields like price, reference number and quantity must be numbers");
        	    alert.showAndWait();
    		}
    	}else {
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	    alert.setHeaderText(null);
     	    alert.setTitle("Alert");
     	    alert.setContentText("Some fields are empty, please fill all the fields");
     	    alert.showAndWait();
    	}
    	
    	
    }

    @FXML
    public void showMedicalHistoryMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storeMenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(StoreMenuPane);
    	storeMenu.initializeComboBox();
    }
    
    public void initializeChoiceBox() {
    	newProductSize.getItems().addAll("pequeño","mediano","grande");
    	
    }

}
