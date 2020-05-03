package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
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
			addAccesory = new AddNewAccesoryProductGUI(v,this,mm);
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
	
	ObservableList <String> list=  FXCollections.observableArrayList("Add an accessory","Add a toy","Add food");
	public void initialize() {
		if(comboAddProduct!=null) {
			comboAddProduct.setItems(list);
		}
	}
    @FXML
    private ComboBox<String> comboAddProduct;

    @FXML
    void addProduct(ActionEvent event) {
    	
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("fxmlFiles/"));
    }

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void searchProduct(ActionEvent event) {

    }

    @FXML
    void showAllProducts(ActionEvent event) {

    }

    @FXML
    void showProductsByType(ActionEvent event) {

    }

}
