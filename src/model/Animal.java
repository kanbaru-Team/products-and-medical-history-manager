package model;

public abstract class Animal {

	private int id;
	private String race;
	private int age;
	private String description;
	private String status;
	private String medicalHistory;
	private Owner owner;
	
	public Animal(int i, String r, int a, String d, String s, String m, String mh,Owner o) {
		id = i;
		race = r;
		age = a;
		description = d;
		status = s;
		medicalHistory = mh;
		owner = o;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	

}