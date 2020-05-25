package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
	public Veterinary() {
		this.firstProd=null;
		this.lastProd=null;
		this.firstAnimal=null;
		this.lastAnimal=null;
		this.firstOwner=null;
	}
	public Product getFirstProduct() {
		return firstProd;
	}
	public Product getLastProduct() {
		return lastProd;
	}
	
	public Animal getLastAnimal() {
		return lastAnimal;
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

	public void addPatient(String n, String i, String r, int a, String d, String s, String mh, Owner o, String other, int patientType) {
		Animal toAdd = null;
		
		switch(patientType) {
		case 0:
			toAdd = new Dog(n, i, r, a, d, s, mh, o, other);
			break;
			
		case 1:
			toAdd = new Cat(n, i, r, a, d, s, mh, o, other);
			break;
			
		case 2:
			toAdd = new Bird(n, i, r, a, d, s, mh, o, other);
			break;
			
		case 3:
			toAdd = new Rodent(n, i, r, a, d, s, mh, o, other);
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
	public void createMedicalRecord(String id,String generalInf, String detailedInf) throws PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.createMedicalRecord(generalInf, detailedInf);
		}else {
			throw new PatientNotFoundException(id);
		}
	}

	public void updateMedicalRecord(String id,String generalInf, String detailedInf) throws MedicalRecordDontExistYet, PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.updateMedicalRecord(generalInf, detailedInf);
		}else {
			throw new PatientNotFoundException(id);
		}
	}

	public void ChangePatientStatus(String id,String status) throws PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.setStatus(status);
		}else {
			throw new PatientNotFoundException(id);
		}
	}

	public void updateMedicalHistory(String id,String newHistory) throws PatientNotFoundException {
		Animal ani = lookForPatient(id);
		if(ani!=null) {
			ani.setMedicalHistory("\n"+newHistory);
		}else {
			throw new PatientNotFoundException(id);
		}
	}
	//
	public Animal lookForPatient(String id) {
		Comparator <Animal> comp = new Comparator <Animal> () {

			@Override
			public int compare(Animal o1, Animal o2) {
				String id1 = o1.getId();
				String id2 = o2.getId();			
				return id1.compareToIgnoreCase(id2);
			}
			
		};		
		ArrayList <Animal> animals = turnPatientsIntoArrayList();
		Collections.sort(animals,comp);
		return lookForPatient(animals,id);
		
	}
	
	private Animal lookForPatient(ArrayList <Animal> animals,String id) {
		Animal a =null;
		int mid;
		int low=0;
		int max=animals.size()-1;
		boolean val =false;
		while(max>=low && !val) {
			mid=(max+low)/2;
			if(animals.get(mid).getId().compareToIgnoreCase(id)>0) {
				max = --mid;
			}else if(animals.get(mid).getId().compareToIgnoreCase(id)<0) {
				low = ++mid;
			}else {
				a=animals.get(mid);
				val=true;
			}
		}
		return a;
	}
	public List<Animal> showAllHospitalizedPatients(){
		ArrayList<Animal> patients = new ArrayList<Animal>();
		patients = turnPatientsIntoArrayList();

		return patients;
	}

	public List<Animal> showAllPatientByID(){
		ArrayList<Animal> patients = new ArrayList<Animal>();
		patients = turnPatientsIntoArrayList();

		return patients;
	}

	public List<Animal> showAllPatientByAge(){
		ArrayList<Animal> patients = new ArrayList<Animal>();
		patients = turnPatientsIntoArrayList();
		for(int i=0;i<patients.size();i++) {
			int minIndex = i;
			
			for(int j=i+1;j<patients.size();j++) {
				int minPatientAge = Integer.parseInt(patients.get(minIndex).getAge());
				int currentPatientAge = Integer.parseInt(patients.get(j).getAge());
				
				if(minPatientAge>currentPatientAge) {
					minIndex = j;
				}
			}
			
			Animal aux = patients.get(i);
			patients.set(i, patients.get(minIndex));
			patients.set(minIndex, aux);
			
		}
		return patients;
		
	}

	public List<Animal> showAllPatientBySpecies(){
		ArrayList<Animal> patients = new ArrayList<Animal>();
		patients = turnPatientsIntoArrayList();

		return patients;
	}
////////////////////////////////////////////////////////////////////////////////////
	//ya esta hecho (falta hacer pruebas)
	public Product lookForProduct(String rn) {
		Product p = null;
		
		if(firstProd!=null) {
			ArrayList<Product> products = turnProductsIntoArrayList();
			
			Comparator<Product> co = new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					String id1 = o1.getRefNum();
					String id2 = o2.getRefNum();
					int comparation = id1.compareToIgnoreCase(id2);
					if(comparation>0) {
						comparation = 1;
					}else if(comparation<0) {
						comparation = -1;
					}else {
						comparation = 0;
					}
					
					return comparation;
				}
			};
			Collections.sort(products,co);
			p = lookForProductBinary(products, rn);
		}
		return p;
	}
	
	private Product lookForProductBinary(ArrayList<Product> products,String rn) {
		Product p = null;
		int min = 0;
		int max = products.size()-1;
		int middle;
		boolean flag = false;
		
		while(max>=min && !flag) {
			middle = ((max+min)/2);
			if(products.get(middle).getRefNum().equalsIgnoreCase(rn)) {
				p = products.get(middle);
				flag = true;
			}else if(products.get(middle).getRefNum().compareToIgnoreCase(rn)<0) {
				min = ++middle;
			}else if(products.get(middle).getRefNum().compareToIgnoreCase(rn)>0){
				max = --middle;
			}
		}
		return p;
	}

	public List<Product> showCertainTypeOfProduct(String type){
		ArrayList<Product> products = new ArrayList<Product>();
		products = turnProductsIntoArrayList();
		
		for(int i=0;i<products.size();i++) {
			
			if(!(products.get(i).getType().equalsIgnoreCase(type))) {
				products.remove(i);
				i--;
			}
			
		}
		
		return products;
	}

	public List<Product> showAllProductsByPrice(){
		ArrayList<Product> products = new ArrayList<Product>();
		products = turnProductsIntoArrayList();
		//bubble
		
		for(int i=0;i<products.size();i++) {
			
			for(int j=0;j<products.size()-(i+1);j++) {
				int currentProductPrice = Integer.parseInt(products.get(j).getPrice());
				int nextProductPrice = Integer.parseInt(products.get(j+1).getPrice());
				
				if(currentProductPrice>nextProductPrice) {
					Product aux = products.get(j);
					products.set(j, products.get(j+1));
					products.set(j+1, aux);
				}
			}
		}
		
		return products;
	}

	public List<Product> showAllProductsByRefNum(){
		ArrayList<Product> products = new ArrayList<Product>();
		products = turnProductsIntoArrayList();
		//bubble
		for(int i=0;i<products.size();i++) {
			for(int j=0;j<products.size()-(i+1);j++) {
				String currentRefNum = products.get(j).getRefNum();
				String nextRefNum = products.get(j+1).getRefNum();
				
				if(currentRefNum.compareToIgnoreCase(nextRefNum)>0) {
					Product aux = products.get(j);
					products.set(j, products.get(j+1));
					products.set(j+1, aux);
				}
			}
		}
		return products;
	}

	public List<Product> showAllProductsByType(){
		ArrayList<Product> products = new ArrayList<Product>();
		products = turnProductsIntoArrayList();

		for(int i=0;i<products.size();i++) {
			int minIndex = i;
			
			for(int j=i+1;j<products.size();j++) {
				String minProductType = products.get(minIndex).getType();
				String currentProductType = products.get(j).getType();
				
				if(minProductType.compareToIgnoreCase(currentProductType)>0) {
					minIndex = j;
				}
			}
			
			Product aux = products.get(i);
			products.set(i, products.get(minIndex));
			products.set(minIndex, aux);
			
		}
		return products;
	}

	public List<Product> showProductsByProfits(){
		ArrayList<Product> products = new ArrayList<Product>();
		products = turnProductsIntoArrayList();
		for(int i=0;i<products.size();i++) {
			int minIndex = i;
			
			for(int j=i+1;j<products.size();j++) {
				int minProductProfit = Integer.parseInt(products.get(minIndex).getProfits());
				int currentProductProfit = Integer.parseInt(products.get(j).getProfits());
				
				if(minProductProfit>currentProductProfit) {
					minIndex = j;
				}
			}
			
			Product aux = products.get(i);
			products.set(i, products.get(minIndex));
			products.set(minIndex, aux);
			
		}
		return products;

	}
//////////////////////////////////////////////////////////////////////////////////////

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

	public void deletePatient(String id) {
		if(firstAnimal!=null) {
			Animal toDelete = lookForPatient(id);
			Animal prev = toDelete.getPrev();
			Animal next = toDelete.getNext();
			
			if(prev!=null) {
				prev.setNext(next);
			}
			if(next!=null) {
				next.setPrev(prev);
			}
			if(toDelete==firstAnimal) {
				firstAnimal = next;
			}
			if(toDelete==lastAnimal) {
				lastAnimal = prev;
			}
		}
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
					current.sellProduct(unitsToSold);
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
	
	public ArrayList<Product> turnProductsIntoArrayList(){
		ArrayList<Product> products = new ArrayList<Product>();
		
		Product current = firstProd;
		
		while(current!=null) {
			products.add(current);
			current = current.getNext();
		}
		
		return products;
	}
	
	
	
	public ArrayList<Animal> turnPatientsIntoArrayList(){
		ArrayList <Animal> animals= new ArrayList<Animal>();
		
		Animal current = firstAnimal;
		
		while(current!=null) {
			animals.add(current);
			current=current.getNext();
		}
		
		return animals;
	}
	
}
