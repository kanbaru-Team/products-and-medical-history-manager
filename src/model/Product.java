package model;

public abstract class Product implements CalculateProfit, SellProduct, CalculateEarnings{
	private String name;
	private int price;
	private String refNum;
	private int stockUnits;
	private int soldUnits;
	private int cost;
	private int profits;
	private String type;
	private Product next;
	private Product prev;
	
	public Product(String name, int price, String refNum, int stockUnits, int soldUnits, int cost,String type) {
		this.name = name;
		this.price = price;
		this.refNum = refNum;
		this.stockUnits = stockUnits;
		this.soldUnits = soldUnits;
		this.cost = cost;
		this.profits=0;
		this.next=null;
		this.prev=null;
		this.type=type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return String.valueOf(price);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getStockUnits() {
		return String.valueOf(stockUnits);
	}
	public void setStockUnits(int stockUnits) {
		this.stockUnits = stockUnits;
	}
	public String getSoldUnits() {
		return String.valueOf(soldUnits);
	}
	public void setSoldUnits(int soldUnits) {
		this.soldUnits = soldUnits;
	}
	public String getCost() {
		return String.valueOf(cost);
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getProfits() {
		return String.valueOf(price*soldUnits);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Product getNext() {
		return next;
	}
	public void setNext(Product next) {
		this.next = next;
	}
	public Product getPrev() {
		return prev;
	}
	public void setPrev(Product prev) {
		this.prev = prev;
	}

	public void calculateProfit() {
		profits = (price*soldUnits)-(cost*soldUnits);
		
	}
	public void sellProduct(int units) {
		soldUnits+=units;
		stockUnits-=units;
		
	}
	public String calculateEarnings() {
		int earnings = price*soldUnits;
		
		return String.valueOf(earnings);
	}
	
	@Override
	public String toString() {
		return "Name: "+ name + "\n"+"Reference: "+refNum+"\n"
				+"Type: "+type+"\n"+"Units in stock: "+stockUnits
				+"\n"+"Profits : "+ profits;
	}
}
