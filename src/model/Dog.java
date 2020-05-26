package model;

public class Dog extends Animal {

	public static final String PUPPY = "puppy";
	public static final String ADULT_BIG_RACE = "adult big race";
	public static final String ADULT_LITTLE_RACE = " adult little race";
	private String size;
	
	public Dog(String n,String i, String r, int a, String d, String s, String mh, Owner o,String specie, String si) {
		super(n,i, r, a, d, s, mh, o,specie);
		size = si;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	

}
