package model;

public abstract class Animal {

	private int id;
	private String race;
	private int age;
	private String description;
	private String status;
	private String medicalHistory;
	private Owner owner;
	private Animal next;
	private Animal prev;
	private MedicalRecord medicalRecord;
	
	public Animal(int i, String r, int a, String d, String s, String m, String mh,Owner o) {
		id = i;
		race = r;
		age = a;
		description = d;
		status = s;
		medicalHistory = mh;
		owner = o;
		prev = null;
		next = null;
		medicalRecord=null;
	}

	public Animal getNext() {
		return next;
	}

	public void setNext(Animal next) {
		this.next = next;
	}

	public Animal getPrev() {
		return prev;
	}

	public void setPrev(Animal prev) {
		this.prev = prev;
	}

	public String getId() {
		return String.valueOf(id);
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

	public String getAge() {
		return String.valueOf(age);
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