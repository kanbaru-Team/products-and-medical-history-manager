package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RegisteredPatientsGUI {
	
    @FXML
    private ComboBox<?> comboOrder;

    @FXML
    private Label title;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnID;

    @FXML
    private TableColumn<?, ?> columnAge;

    @FXML
    private TableColumn<?, ?> columnSpecie;

    @FXML
    private TableColumn<?, ?> columnStatus;

    @FXML
    void returnToPrevScreen(ActionEvent event) {

    }


}
