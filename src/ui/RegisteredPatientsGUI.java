package ui;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Animal;
import model.Product;
import model.Veterinary;
import threads.RegisteredPatientsThread;

public class RegisteredPatientsGUI {
	
	private MainMenuGUI mainMenu;
	private VeterinaryMenuGUI veterinaryMenu;
	private Veterinary veterinary;
	
    @FXML
    private ComboBox<String> comboOrder;

    @FXML
    private Label title;

    @FXML
    private TableView<Animal> table;

    @FXML
    private TableColumn<Animal, String> columnName;

    @FXML
    private TableColumn<Animal, String> columnID;

    @FXML
    private TableColumn<Animal, String> columnAge;

    @FXML
    private TableColumn<Animal, String> columnSpecie;

    @FXML
    private TableColumn<Animal, String> columnStatus;
    
    private RegisteredPatientsThread rpt;

    public RegisteredPatientsGUI(MainMenuGUI mm, VeterinaryMenuGUI vm,Veterinary v) {
    	mainMenu = mm;
    	veterinaryMenu = vm;
    	veterinary = v;
    	
    }
    
    public void initializeTableView(List <Animal> patients) {
    	ObservableList obs = FXCollections.observableArrayList(patients);
	 	table.setItems(obs);
	 	columnName.setCellValueFactory(new PropertyValueFactory<Animal,String>("name"));
	 	columnID.setCellValueFactory(new PropertyValueFactory<Animal,String>("id"));
	 	columnAge.setCellValueFactory(new PropertyValueFactory<Animal,String>("age"));
	 	columnSpecie.setCellValueFactory(new PropertyValueFactory<Animal,String>("specie"));
	 	columnStatus.setCellValueFactory(new PropertyValueFactory<Animal,String>("status"));
	 	
    }
    
    @FXML
    public void returnToPrevScreen(ActionEvent event) throws IOException {
		rpt.setFlag(false);
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VeterinaryMenu.fxml"));
    	fxmlLoader.setController(veterinaryMenu);
    	
    	Parent VeterinaryMenuPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(VeterinaryMenuPane);
    	
    }

    public void showAllOptions(boolean b) {
    	comboOrder.setVisible(b);
    	if(b==false) {
    		title.setText("Hospitalized Patients");
    	}else {
    		title.setText("Registered Patients");
    	}
    }
    
    public void initializeComboBox() {
    	comboOrder.getItems().clear();
    	comboOrder.setValue("Ordenar por ID");
    	comboOrder.getItems().addAll("Ordenar por ID","Ordenar por Especie","Ordenar por Edad");
    }
    
    public int getcomboOrderValue() {
    	int operation = -1;
    	
    	if(title.getText().equalsIgnoreCase("Hospitalized Patients")) {
    		operation = 0;
    	}else if(comboOrder.getValue().equalsIgnoreCase("Ordenar por ID")) {
    		operation = 1;
    	}else if(comboOrder.getValue().equalsIgnoreCase("Ordenar por Especie")) {
    		operation = 2;
    	}else if(comboOrder.getValue().equalsIgnoreCase("Ordenar por Edad")) {
    		operation = 3;
    	}
    	return operation;
    }
    
    public void initialize() {
    	rpt = new RegisteredPatientsThread(veterinary, this);
    	rpt.start();
    }
    
}
