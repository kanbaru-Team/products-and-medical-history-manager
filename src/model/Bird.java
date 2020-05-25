package model;

public class Bird extends Animal{

	private String featherColor;
	
	public Bird(String n, String i, String r, int a, String d, String s, String m, String mh, Owner o, String fc) {
		super(n, i, r, a, d, s, m, mh, o);
		featherColor = fc;
	}

	public String getFeatherColor() {
		return featherColor;
	}

	public void setFeatherColor(String featherColor) {
		this.featherColor = featherColor;
	}

}
