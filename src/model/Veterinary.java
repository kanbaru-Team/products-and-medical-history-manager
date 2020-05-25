package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import customException.MedicalRecordDontExistYet;
import customException.NoItemsInStockException;
import customException.PatientNotFoundException;

public class Veterinary {
	private Product firstProd;
	private Product lastProd;
	private Animal firstAnimal;
	private Animal lastAnimal;
	private Owner firstOwner;
	private ArrayList <Product> products;
	private ArrayList <Animal> animals;
	public Veterinary() {
		this.firstProd=null;
		this.lastProd=null;
		this.firstAnimal=null;
		this.lastAnimal=null;
		this.firstOwner=null;
		products = new ArrayList<Product>();
		animals = new ArrayList<Animal>();
	}
	public Product getFirstProduct() {
		return firstProd;
	}
	public Product getLastProduct() {
		return lastProd;
	}

	//ya esta hecho
	public void addProduct(String name, int price, String refNum, int stockUnits, int soldUnits, int cost,String type,String color) {
		Accesory a = new Accesory(name,price,refNum,stockUnits,soldUnits,cost,type,color);
		if(firstProd==null) {
			firstProd=a;
			lastProd=a;
		}else {
			if(firstProd.getNext()==null) {
				firstProd.setNext(a);
				a.setPrev(firstProd);
				lastProd=a;
			}else {
				Product last = lastProd;
				last.setNext(a);
				a.setPrev(last);
				lastProd=a;
			}

		}

	}

	//ya esta hecho
	public void addProduct(String name, int price, String refNum, int stockUnits, int soldUnits, int cost,String type,String color,String size) {
		Toy a = new Toy(name,price,refNum,stockUnits,soldUnits,cost,type,color,size);
		if(firstProd==null) {
			firstProd=a;
			lastProd=a;
		}else {
			if(firstProd.getNext()==null) {
				firstProd.setNext(a);
				a.setPrev(firstProd);
				lastProd=a;
			}else {
				Product last = lastProd;
				last.setNext(a);
				a.setPrev(last);
				lastProd=a;
			}

		}

	}

	//ya esta hecho
	public void addProduct(String name, int price, String refNum, int stockUnits, int soldUnits, int cost,String type,String specie,double weight) {
		Food a = new Food(name,price,refNum,stockUnits,soldUnits,cost,type,specie,weight);
		if(firstProd==null) {
			firstProd=a;
			lastProd=a;
		}else {
			if(firstProd.getNext()==null) {
				firstProd.setNext(a);
				a.setPrev(firstProd);
				lastProd=a;
			}else {
				Product last = lastProd;
				last.setNext(a);
				a.setPrev(last);
				lastProd=a;
			}

		}

	}

	//ya esta hecho
	public ArrayList<Product> showAllProducts(){
		ArrayList <Product> prods = new ArrayList<Product>();
		if(firstProd==null) {

		}else {
			if(firstProd.getNext()==null) {
				prods.add(firstProd);
			}else {
				Product current = firstProd;
				boolean val = true;
				while(val) {
					prods.add(current);
					current=current.getNext();
					if(current==null) {
						val=false;
					}
				}
			}
		}
		return prods;

	}

	public void addPatient(String n, String i, String r, int a, String d, String s, String m, String mh, Owner o, String other, int patientType) {
		Animal toAdd = null;
		
		switch(patientType) {
		case 0:
			toAdd = new Dog(n, i, r, a, d, s, m, mh, o, other);
			break;
			
		case 1:
			toAdd = new Cat(n, i, r, a, d, s, m, mh, o, other);
			break;
			
		case 2:
			toAdd = new Bird(n, i, r, a, d, s, m, mh, o, other);
			break;
			
		case 3:
			toAdd = new Rodent(n, i, r, a, d, s, m, mh, o, other);
			break;
		}
		
		if(firstAnimal==null) {
			firstAnimal = toAdd;
			lastAnimal = toAdd;
		}else{
			lastAnimal.setNext(toAdd);
			toAdd.setPrev(lastAnimal);
			lastAnimal = toAdd;
		}
	}

	public boolean addOwner(long id, String name,String adress,String phone ){
		Owner toAdd = new Owner(id,name,adress,phone);
		boolean added = false;
		if(firstOwner==null) {
			firstOwner=toAdd;
			added = true;
		}else {
				added = addOwner(firstOwner,toAdd);
		}
		
		return added;
	}
	
	private boolean addOwner(Owner current,Owner toAdd) {
		
		if(toAdd.getId()>=current.getId()) {
			if(current.getRight()==null) {
				current.setRight(toAdd);
				toAdd.setParent(current);
				return true;
			}else {
				return addOwner(current.getRight(),toAdd);
			}
		}
		else if(toAdd.getId()<current.getId()){
			if(current.getLeft()==null) {
				current.setLeft(toAdd);
				toAdd.setParent(current);
				return true;
			}else {
				return addOwner(current.getLeft(),toAdd);
			}
			
		}else {
			return false;
		}
	}
	
	public Owner lookForOwner(long id) {
		if(firstOwner!=null) {
			return lookForOwner(firstOwner,id);
		}
		return null;
	}
	
	private Owner lookForOwner(Owner current,long id) {
		if(current==null) {
			return current;
		}else if(current.getId()==id) {
			return current;
		}else if(current.getId()>id) {
			return lookForOwner(current.getLeft(),id);
		}else if(current.getId()<id){
			return lookForOwner(current.getRight(),id);
		}else {
			return current;
		}
	}
	
	//
	public void createMedicalRecord(int id,String generalInf, String detailedInf) throws PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.createMedicalRecord(generalInf, detailedInf);
		}else {
			throw new PatientNotFoundException(id);
		}
	}

	public void updateMedicalRecord(int id,String generalInf, String detailedInf) throws MedicalRecordDontExistYet, PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.updateMedicalRecord(generalInf, detailedInf);
		}else {
			throw new PatientNotFoundException(id);
		}
	}

	public void ChangePatientStatus(int id,String status) throws PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.setStatus(status);
		}else {
			throw new PatientNotFoundException(id);
		}
	}

	public void updateMedicalHistory(int id,String newHistory) throws PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.setMedicalHistory(newHistory+"\n");
		}else {
			throw new PatientNotFoundException(id);
		}
	}
	//
	public Animal lookForPatient(int id) {
		if(firstAnimal!=null) {
			return lookForPatient(firstAnimal,id);
		}else {
			return null;
		}
	}
	private Animal lookForPatient(Animal current,int id) {
		if(current==null) {
			return null;
		}else if(current.getId()==String.valueOf(id)) {
			return current;
		}else {
			return lookForPatient(current.getNext(),id);
		}
		
	}
	public List<Animal> showAllHospitalizedPatients(){
		LinkedList<Animal> patients = null;

		return patients;
	}

	public List<Animal> showAllPatientByID(){
		LinkedList<Animal> patients = null;

		return patients;
	}

	public List<Animal> showAllPatientByAge(){
		LinkedList<Animal> patients = null;

		return patients;
	}

	public List<Animal> showAllPatientBySpecies(){
		LinkedList<Animal> patients = null;

		return patients;
	}
////////////////////////////////////////////////////////////////////////////////////
	//ya esta hecho (falta hacer pruebas)
	public Product lookForProduct(String rn) {
		Product p = null;
		
		if(firstProd!=null) {
			Product current = firstProd;
			boolean flag = false;
			
			while(current!=null && !flag) {
				if(current.getRefNum().equalsIgnoreCase(rn)) {
					flag = true;
					p = current;
				}
				else {
					current = current.getNext();
				}
			}
			
		}
		return p;
	}

	public List<Product> showCertainTypeOfProduct(int type){
		LinkedList<Product> products = null;

		return products;
	}

	public List<Product> showAllProductsByPrice(){
		LinkedList<Product> products = null;

		return products;
	}

	public List<Product> showAllProductsByRefNum(){
		LinkedList<Product> products = null;

		return products;
	}

	public List<Product> showAllProductsByType(){
		LinkedList<Product> products = null;

		return products;
	}

	public List<Product> showProductsByProfits(){
		LinkedList<Product> products = null;

		return products;

	}
//////////////////////////////////////////////////////////////////////////////////////
	//ya esta hecho (falta probarlo)
	public void deleteProduct(String rn) {
		if(firstProd!=null) {
			Product toDelete = lookForProduct(rn);
			Product prev = toDelete.getPrev();
			Product next = toDelete.getNext();
			
			if(prev!=null) {
				prev.setNext(next);
			}
			if(next!=null) {
				next.setPrev(prev);
			}
			if(toDelete==firstProd) {
				firstProd = next;
			}
			if(toDelete==lastProd) {
				lastProd = prev;
			}
		}
	}

	public void deletePatient(int id) {
		
	}

	public void printMedicalHistory(int id) {

	}


	public void sellProduct(String refNum, int unitsToSold) throws NoItemsInStockException {		
		boolean val=false;
		if(firstProd!=null) {
			Product current = firstProd;
			while(current!=null && !val) {
				if(current.getRefNum().equalsIgnoreCase(refNum)) {
					if(unitsToSold>Integer.parseInt(current.getStockUnits())) {
						throw new NoItemsInStockException(current.getName(), current.getStockUnits(), unitsToSold);
					}
					current.increaseSoldUnits(unitsToSold);
					current.decreaseStockUnits(unitsToSold);
					val=true;
				}else {
					current=current.getNext();  
				}
			}
		}
	}

	public void increaseStock(String refNum, int units) {

		if(firstProd!=null) {
			Product p = lookForProduct(refNum);
			
			if(p!=null) {
				units+=Integer.parseInt(p.getStockUnits());
				p.setStockUnits(units);
			}
		}
	}
	
	public Owner getFirstOwner() {
		return firstOwner;
	}
	
	public Animal getFirstAnimal() {
		return firstAnimal;
	}
}
