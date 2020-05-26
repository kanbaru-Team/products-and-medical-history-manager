package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock {

	private long hour;
	private long seconds;
	private long minutes;

	public Clock() {
		hour = 0;
		seconds = 0;
		minutes = 0;
		
	}
	//cambiar por diferencia entre timpos
	
	public void run() {
		reset();
		Calendar calendar = new GregorianCalendar();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		seconds = calendar.get(Calendar.SECOND);
		minutes = calendar.get(Calendar.MINUTE);
	}
	
	public void reset() {
		hour = 0;
		seconds = 0;
		minutes = 0;
	}
	
	public String toString() {
		String hour = "";
		String seconds = "";
		String minutes = "";

		
		if(this.hour<10) {
			hour = "0"+this.hour;
		}else {
			hour = ""+this.hour;
		}
		
		if(this.seconds<10) {
			seconds = "0"+this.seconds;
		}else {
			seconds = ""+this.seconds;
		}
		
		if(this.minutes<10) {
			minutes = "0"+this.minutes;
		}else {
			minutes = ""+this.minutes;
		}
		return (hour+":"+minutes+":"+seconds);
	}
	
	
}