package model;

public class Owner{

	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private Owner parent;
	private Owner left;
	private Owner right;

	public Owner(int i, String n,String a,String pn ){
		id = i;
		name = n;
		address = a;
		phoneNumber = pn;
		parent = null;
		left = null;
		right = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Owner getParent() {
		return parent;
	}

	public void setParent(Owner parent) {
		this.parent = parent;
	}

	public Owner getLeft() {
		return left;
	}

	public void setLeft(Owner left) {
		this.left = left;
	}

	public Owner getRight() {
		return right;
	}

	public void setRight(Owner right) {
		this.right = right;
	}
}