package ui;

import java.io.IOException;

import customException.ProductNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Veterinary;

public class DeleteProductGUI {
	
	private  Veterinary veterinary;
	private StoreMenuGUI storeMenu;
	private MainMenuGUI mainMenu;
	
	public DeleteProductGUI(Veterinary v,StoreMenuGUI sm,MainMenuGUI mm) {
		veterinary = v;
		storeMenu=sm;
		mainMenu=mm;
	}
	
    @FXML
    private TextField productTxt;

    @FXML
    void deleteProduct(ActionEvent event) {
    	if(!productTxt.getText().isEmpty()) {
    		try {
    			Integer.parseInt(productTxt.getText());
    			veterinary.deleteProduct(productTxt.getText());
    			
       			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText("product deleted");
    			alert.showAndWait();
    			
    		}catch(NumberFormatException e) {
       			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Alert");
    			alert.setContentText("value given must be numeric");
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
			alert.setContentText("field for reference number is empty");
			alert.showAndWait();
    	}
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storeMenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(StoreMenuPane);
    	storeMenu.initializeComboBox();
    }

}
