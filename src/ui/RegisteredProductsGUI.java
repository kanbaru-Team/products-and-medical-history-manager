package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
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
    private TableView<Product> productsList;

    @FXML
    private TableColumn<Product, String> nameTc;

    @FXML
    private TableColumn<Product, String> refTc;

    @FXML
    private TableColumn<Product, String> priceTc;

    @FXML
    private TableColumn<Product, String> typeTc;

    @FXML
    private TableColumn<Product, String> soldUnitsTc;

    @FXML
    private TableColumn<Product, String> profitsTc;
    
    @FXML
    private ComboBox<String> comboSortBy;

    @FXML
    public void goBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/StoreMenu.fxml"));
    	fxmlLoader.setController(storemenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainmenu.getMainPane().getChildren().clear();
    	mainmenu.getMainPane().setCenter(StoreMenuPane);
    }
    
 public void initializeTableView() {
	 	ObservableList obs = FXCollections.observableArrayList(vet.showAllProducts());
	 	productsList.setItems(obs);
	 	nameTc.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
	 	refTc.setCellValueFactory(new PropertyValueFactory<Product,String>("refnum"));
	 	priceTc.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));
	 	typeTc.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
	 	soldUnitsTc.setCellValueFactory(new PropertyValueFactory<Product,String>("soldunits"));
	 	profitsTc.setCellValueFactory(new PropertyValueFactory<Product,String>("profits"));
    }
    
    

}
