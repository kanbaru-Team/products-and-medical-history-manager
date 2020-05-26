package customException;

@SuppressWarnings("serial")
public class PatientNotFoundException extends Exception {
	
	private String id;
	
	public PatientNotFoundException(String n) {
		super(" was not found.");
		id = n;
	}
	
	@Override
	public String toString() {
		return "patient identified with "+id+super.getMessage();
	}
	
}
