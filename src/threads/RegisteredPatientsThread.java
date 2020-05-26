package threads;

import java.util.List;

import javafx.application.Platform;
import model.Animal;
import model.Veterinary;
import ui.RegisteredPatientsGUI;

public class RegisteredPatientsThread extends Thread{

	private Veterinary veterinary;
	private RegisteredPatientsGUI registeredPatientsGUI;
	private boolean flag = true;
	private List<Animal> patients;
	
	public RegisteredPatientsThread( Veterinary vet,RegisteredPatientsGUI rpGUI) {
		veterinary = vet;
		registeredPatientsGUI = rpGUI;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(flag) {
			
			int operation = registeredPatientsGUI.getcomboOrderValue();
			
			switch(operation) {
			case 0:
				patients = veterinary.showAllHospitalizedPatients();
				break;
			case 1:
				patients = veterinary.showAllPatientByID();
				break;
			case 2:
				patients = veterinary.showAllPatientBySpecie();
				break;
			case 3:
				patients = veterinary.showAllPatientByAge();
				break;
			}
			
			Platform.runLater(new Thread() {
				@Override
				public void run() {
					registeredPatientsGUI.initializeTableView(patients);
				}
			});
			
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public void setFlag(boolean f) {
		flag = f;
	}
}
