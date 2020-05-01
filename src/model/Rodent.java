package model;

public class Rodent extends Animal {

	public static final String LARGE_TAIL = "large tail";
	public static final String SHORT_TAIL = "short tail";
	public String tailSize;
	
	public Rodent(int i, String r, int a, String d, String s, String m, String mh, Owner o, String ts) {
		super(i, r, a, d, s, m, mh, o);
		tailSize = ts;
	}

	public String getTailSize() {
		return tailSize;
	}

	public void setTailSize(String tailSize) {
		this.tailSize = tailSize;
	}

}
