package customException;

@SuppressWarnings("serial")
public class NoItemsInStockException extends Exception{

	String name;
	String stock;
	int uNeeded;
	
	public NoItemsInStockException(String n, String s, int un) {
		super("you have not enough items in stock: \n");
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
