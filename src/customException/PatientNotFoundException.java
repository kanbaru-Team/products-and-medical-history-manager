package customException;

@SuppressWarnings("serial")
public class PatientNotFoundException extends Exception {
	
	private String name;
	
	public PatientNotFoundException(String n) {
		super(" was not found.");
		name = n;
	}
	
	@Override
	public String toString() {
		return "patient "+name+super.toString();
	}
	
}
