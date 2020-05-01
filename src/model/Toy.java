package model;

public class Toy extends Product{
	
	public static final String BIG = "big";
	public static final String MEDIUM = "medium";
	public static final String LITTLE = "little";
	private String color;
	private String size;

	public Toy(String n, int p, int rn, int su, int cos, int stu, String col, String s) {
		super(n,p,rn,stu,su,cos);
		color = col;
		size = s;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
