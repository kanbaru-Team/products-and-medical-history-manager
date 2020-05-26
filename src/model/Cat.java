package model;

public class Cat extends Animal{

	public final static String HUNTER = "hunter";
	public final static String HOMELIKE = "homelike";
	public final static String SEDENTARY = "sedentary";
	public final static String RESTLESS = "restless";
	private String behavior;
	
	public Cat(String n, String i, String r, int a, String d, String s, String mh, Owner o,String specie, String b) {
		super(n, i, r, a, d, s, mh, o,specie);
		behavior = b;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	
}
