package model;

public abstract class Product {
	private String name;
	private int price;
	private int refNum;
	private int stockUnits;
	private int soldUnits;
	private int cost;
	
	public Product(String name, int price, int refNum, int stockUnits, int soldUnits, int cost) {
		this.name = name;
		this.price = price;
		this.refNum = refNum;
		this.stockUnits = stockUnits;
		this.soldUnits = soldUnits;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRefNum() {
		return refNum;
	}
	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}
	public int getStockUnits() {
		return stockUnits;
	}
	public void setStockUnits(int stockUnits) {
		this.stockUnits = stockUnits;
	}
	public int getSoldUnits() {
		return soldUnits;
	}
	public void setSoldUnits(int soldUnits) {
		this.soldUnits = soldUnits;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
