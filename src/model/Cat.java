package model;

public class Cat extends Animal{

	public final static String HUNTER = "hunter";
	public final static String HOMELIKE = "homelike";
	public final static String SEDENTARY = "sedentary";
	public final static String RESTLESS = "restless";
	private String behavior;
	
	public Cat(String n, String i, String r, int a, String d, String s, String m, String mh, Owner o, String b) {
		super(n, i, r, a, d, s, m, mh, o);
		behavior = b;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	
}
