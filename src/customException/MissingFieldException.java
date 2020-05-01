package customException;

@SuppressWarnings("serial")
public class MissingFieldException extends Exception{

	public MissingFieldException() {
		super("algunos campos estan vacios");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
