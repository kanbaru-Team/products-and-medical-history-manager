package customException;

@SuppressWarnings("serial")
public class PatientNotFoundException extends Exception {
	
	private int id;
	
	public PatientNotFoundException(int n) {
		super(" was not found.");
		id = n;
	}
	
	@Override
	public String toString() {
		return "patient identified with "+id+super.toString();
	}
	
}
