package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Veterinary;

public class Main extends Application {

	Veterinary veterinary;
	MainMenuGUI MainMenuGUI;
	/*
	 * private VeterinaryMenuGUI veterinaryMenu;
	 * private AddOwnerAndPatientGUI addOwnerAndPatient;
	 * 
	 */
	public Main() {
		veterinary = new Veterinary();
		try {
			chargeData();
		} catch (ClassNotFoundException | IOException e) {
			veterinary = new Veterinary();
		}
		MainMenuGUI = new MainMenuGUI(veterinary);
		
	}
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
		primaryStage.setResizable(true);
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		    	try {
					saveData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        Platform.exit();
		        System.exit(0);
		    }
		});
		
	}
	
	public void saveData() throws IOException {
		FileOutputStream fos = new FileOutputStream("data/status");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(veterinary);
		oos.close();
		fos.close();
	}
	
	public void chargeData() throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream("data/status");
        ObjectInputStream ois = new ObjectInputStream(file);
        Veterinary aux = (Veterinary) ois.readObject();
        
        if(aux!=null) {
            veterinary = aux;
        }
        ois.close();
        file.close();
	}
	

}

