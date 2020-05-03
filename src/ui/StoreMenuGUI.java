package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import model.Veterinary;

public class StoreMenuGUI {
	
	private Veterinary veterinary;
	private MainMenuGUI menumain;
	private DeleteProductGUI deleteProduct;
	private AddNewAccesoryProductGUI addAccesory;
	private AddNewFoodProductGUI addFood;
	private AddNewToyProductGUI addToy;
	private LookForProductGUI searchProduct;
	private RegisteredProductsGUI registeredProducts;
	
    @FXML
    private ChoiceBox<String> addProducts;

	public StoreMenuGUI(Veterinary v,MainMenuGUI mm) {
		veterinary=v;
		menumain=mm;
		if(deleteProduct==null) {
			deleteProduct = new DeleteProductGUI(v,this,mm);
		}
		if(addToy==null) {
			addToy = new AddNewToyProductGUI(v,this,mm);
		}
		if(addAccesory==null) {
			//addAccesory = new AddNewAccesoryProductGUI(v,this,mm);
		}
		if(addFood==null) {
			addFood = new AddNewFoodProductGUI(v,this,mm);
		}
		if(searchProduct==null) {
			searchProduct=new LookForProductGUI(v,this,mm);
		}
		if(registeredProducts==null) {
			registeredProducts = new RegisteredProductsGUI(v,this,mm);
		}
		
	}

    @FXML
    public void addProduct(ActionEvent event) throws IOException {
    	
    	String value = addProducts.getValue();
    	switch(value) {
    	case "Add a new accessory":
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/AddNewAccesoryProduct.fxml"));
        	fxmlLoader.setController(addAccesory);
        	
        	Parent addProductPane = fxmlLoader.load();
        	menumain.getMainPane().getChildren().clear();
        	menumain.getMainPane().setCenter(addProductPane);
        	break;
    	case "Add a new toy":
    		FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("fxmlFiles/AddNewToyProduct.fxml"));
        	fxmlLoader2.setController(addToy);
        	
        	Parent addProductPane2 = fxmlLoader2.load();
        	menumain.getMainPane().getChildren().clear();
        	menumain.getMainPane().setCenter(addProductPane2);
        	break;
    	case "Add a new food product":
    		FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("fxmlFiles/AddNewFoodProduct.fxml"));
        	fxmlLoader3.setController(addFood);
        	
        	Parent addProductPane3 = fxmlLoader3.load();
        	menumain.getMainPane().getChildren().clear();
        	menumain.getMainPane().setCenter(addProductPane3);
        	break;
        default:
        	break;
    	}
    	
    	
    }

    @FXML
    public void deleteProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/DeleteProduct.fxml"));
    	fxmlLoader.setController(deleteProduct);
    	
    	Parent deleteProductPane = fxmlLoader.load();
    	menumain.getMainPane().getChildren().clear();
    	menumain.getMainPane().setCenter(deleteProductPane);
    }

    @FXML
    public void searchProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/LookForProduct.fxml"));
    	fxmlLoader.setController(searchProduct);
    	
    	Parent searchProductPane = fxmlLoader.load();
    	menumain.getMainPane().getChildren().clear();
    	menumain.getMainPane().setCenter(searchProductPane);
    }

    @FXML
    public void showAllProducts(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/RegisteredProducts.fxml"));
    	fxmlLoader.setController(registeredProducts);
    	
    	Parent registeredProductsPane = fxmlLoader.load();
    	menumain.getMainPane().getChildren().clear();
    	menumain.getMainPane().setCenter(registeredProductsPane);
    	registeredProducts.initializeTableView();
   
    }

    @FXML
    public void showProductsByType(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/RegisteredProducts.fxml"));
    	fxmlLoader.setController(registeredProducts);
    	
    	Parent registeredProductsPane = fxmlLoader.load();
    	menumain.getMainPane().getChildren().clear();
    	menumain.getMainPane().setCenter(registeredProductsPane);
    	registeredProducts.initializeTableView();
    }
    
	public void initializeComboBox() {
		addProducts.getItems().addAll("Add a new accessory","Add a new toy","Add a new food product");
		
	}

}
