package model;

public class Bird extends Animal{

	public static final String YELLOW = "Amarillo";
	public static final String BLUE = "Azul";
	public static final String GREEN = "verde";
	public static final String RED = "Rojo";
	private String featherColor;
	
	public Bird(String n, String i, String r, int a, String d, String s, String mh, Owner o,String specie, String fc) {
		super(n, i, r, a, d, s, mh, o,specie);
		featherColor = fc;
	}

	public String getFeatherColor() {
		return featherColor;
	}

	public void setFeatherColor(String featherColor) {
		this.featherColor = featherColor;
	}

}
