package customException;

@SuppressWarnings("serial")
public class NoItemsInStockException extends Exception{

	String name;
	int stock;
	int uNeeded;
	
	public NoItemsInStockException(String n, int s, int un) {
		super("no se puede vender este producto");
		name = n;
		stock = s;
		uNeeded = un;
	}
	
	@Override
	public String toString() {
		String message = "the product "+name+" have a stock of "+stock+" units, and are needed "+ uNeeded+" units";
		return super.toString()+"\n"+message;
	}
	
}
