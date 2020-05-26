package threads;

import javafx.application.Platform;
import model.Veterinary;
import ui.MainMenuGUI;

public class ClockThread extends Thread{
	private MainMenuGUI menu;
	private Veterinary veterinary;
	private String time = "";
	
	public ClockThread(MainMenuGUI m,Veterinary v) {
		menu = m;
		veterinary = v;
	}
	
	@Override
	public void run() {

		while(true) {
			time = veterinary.runClock();
			
			Platform.runLater(new Thread() {
				
				@Override
				public void run() {
					menu.setChronometer(time);
				}
				
			});
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}