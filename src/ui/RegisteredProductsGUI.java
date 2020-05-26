package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import threads.RegisteredProductsThread;

public class RegisteredProductsGUI	{
	
	private Veterinary vet;
	private StoreMenuGUI storeMenu;
	private MainMenuGUI mainMenu;
	
    public RegisteredProductsGUI(Veterinary vet, StoreMenuGUI storemenu, MainMenuGUI mainmenu) {
		this.vet = vet;
		this.storeMenu = storemenu;
		this.mainMenu = mainmenu;
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
    	fxmlLoader.setController(storeMenu);
    	
    	Parent StoreMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(StoreMenuPane);
    	storeMenu.initializeComboBox();
    }
    
    public void initialize() {
    	RegisteredProductsThread rpt = new RegisteredProductsThread(this, vet);
    	rpt.start();
    }
    
    public void initializeTableView( List <Product> products  ) {
	 	ObservableList obs = FXCollections.observableArrayList(products);
	 	productsList.setItems(obs);
	 	nameTc.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
	 	refTc.setCellValueFactory(new PropertyValueFactory<Product,String>("refNum"));
	 	priceTc.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));
	 	typeTc.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
	 	soldUnitsTc.setCellValueFactory(new PropertyValueFactory<Product,String>("soldUnits"));
	 	profitsTc.setCellValueFactory(new PropertyValueFactory<Product,String>("profits"));
    }
    
 
    public void initializeComboBox() {
    	comboSortBy.getItems().addAll("Ordenar por precio","Ordenar por tipo","Ordenar por referencia","Ordenar por beneficios");
    }
    
    public String getComboBox() {
    	return comboSortBy.getValue();
    }
    
   public void initializeComboBoxType() {
	   comboSortBy.getItems().addAll("Mostrar Accesorios","Mostrar Comida","Mostrar Juguetes");
   }
}
