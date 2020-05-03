package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Veterinary;

public class Main extends Application {

	Veterinary veterinary = new Veterinary();
	MainMenuGUI MainMenuGUI = new MainMenuGUI(veterinary);
	/*
	 * private VeterinaryMenuGUI veterinaryMenu;
	 * private AddOwnerAndPatientGUI addOwnerAndPatient;
	 * 
	 */
	
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/MainView.fxml"));
		fxmlLoader.setController(MainMenuGUI);
		
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,900,500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("veterinary");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}

