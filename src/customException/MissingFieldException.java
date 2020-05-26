package customException;

@SuppressWarnings("serial")
public class MissingFieldException extends Exception{

	public MissingFieldException() {
		super("Algunos campos estan vacios. Por favor diligencie todos los campos");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
