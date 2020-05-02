package customException;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{

	private String name;
	
	public ProductNotFoundException(String n) {
		super(" was not found.");
		name = n;
	}
	
	@Override
	public String toString() {
		return "patient "+name+super.toString();
	}
	
}
