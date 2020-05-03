package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Veterinary {
	private Product firstProd;
	private Product lastProd;
	private Animal firstAnimal;
	private Animal lastAnimal;
	private Owner firstOwner;;
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
	
	public void addProduct(String name, int price, int refNum, int stockUnits, int soldUnits, int cost,String type,String color) {
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
	
	public void addProduct(String name, int price, int refNum, int stockUnits, int soldUnits, int cost,String type,String color,String size) {
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
	public void addProduct(String name, int price, int refNum, int stockUnits, int soldUnits, int cost,String type,String specie,double weight) {
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
	
	public void addPatient(int i, String r, int a, String d, String s, String m, String mh, Owner o, String other, int patientType) {
		
	}
	
	public void addOwner(int i, String n,String a,String pn ){
		
	}
	
	public void CreateMedicalRecord(String generalInf, String detailedInf) {
		//falta hacer la clase de medical record
	}
	
	public void updateMedicalRecord(String generalInf, String detailedInf) {
		//falta crear la clase de medical record
	}
	
	public void ChangePatientStatus(String status) {
		
	}
	
	public void updateMedicalHistory(String newHistory) {
		
	}
	
	public Animal lookForPatient(int id) {
		Animal patient = null;//para que no tire errores por el momento, esta linea se cambiará
		
		return patient;
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
	
	public Product lookForProduct(int refNum) {
		Product p=null;
		
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
	
	public void deleteProduct(int refNum) {
		
	}
	
	public void deletePatient(int id) {
		
	}
	
	public void printMedicalHistory(int id) {
		
	}
	
	public void sendProduct(int refNum) {
		
	}
	
	public void increaseStock(int refNum, int units) {
		
	}
	
}
