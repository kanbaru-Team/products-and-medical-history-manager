package model;

public class Accesory extends Product{
	private String color;
	public Accesory(String name, int price, int refNum, int stockUnits, int soldUnits, int cost,String type,String color) {
		super(name, price, refNum, stockUnits, soldUnits, cost,type);
		this.color=color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

	

}
