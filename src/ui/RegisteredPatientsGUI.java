package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Animal;
import model.Veterinary;

public class RegisteredPatientsGUI {
	
	private MainMenuGUI mainMenu;
	private VeterinaryMenuGUI veterinaryMenu;
	private Veterinary veterinary;
	
    @FXML
    private ComboBox<?> comboOrder;

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

    public RegisteredPatientsGUI(MainMenuGUI mm, VeterinaryMenuGUI vm,Veterinary v) {
    	mainMenu = mm;
    	veterinaryMenu = vm;
    	veterinary = v;
    	
    }
    
    public void initializeTableView() {
    	
    }
    
    @FXML
    public void returnToPrevScreen(ActionEvent event) throws IOException {
		
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
    

}
