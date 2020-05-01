package model;

public class Dog extends Animal {

	public static final String PUPPY = "puppy";
	public static final String ADULT_BIG_RACE = "adult big race";
	public static final String ADULT_LITTLE_RACE = " adult little race";
	private String size;
	
	public Dog(int i, String r, int a, String d, String s, String m, String mh, Owner o, String si) {
		super(i, r, a, d, s, m, mh, o);
		size = si;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	

}
