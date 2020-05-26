package model;

import customException.MedicalRecordDontExistYet;

public abstract class Animal {
	
	public final static String HEALTHY = "Saludable";
	public final static String HOSPITALIZED = "Hospitalizado";
	public final static String TREATMENT = "Tratamiento";
	
	private String specie;
	private String name;
	private String id;
	private String race;
	private int age;
	private String description;
	private String status;
	private String medicalHistory;
	private Owner owner;
	private Animal next;
	private Animal prev;
	private MedicalRecord medicalRecord;
	
	public Animal(String name,String i, String r, int a, String d, String s, String mh,Owner o,String specie) {
		this.name=name;
		id = i;
		race = r;
		age = a;
		description = d;
		status = s;
		this.specie=specie;
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
		return id;
	}

	public void setId(String id) {
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
		this.medicalHistory += medicalHistory;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public void createMedicalRecord(String genInf,String detInf)  {
		medicalRecord= new MedicalRecord(genInf,detInf);	
	}
	public void updateMedicalRecord(String genInf,String detInf) throws MedicalRecordDontExistYet {
		if(medicalRecord!=null) {
			medicalRecord.setGeneralInfo(genInf);
			medicalRecord.setDetailInfo(detInf);
		}else {
			throw new MedicalRecordDontExistYet(id);
		}
	}

	public String getName() {
		return name;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public String getSpecie() {
		return specie;
	}
	

}