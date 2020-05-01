package model;

import java.util.ArrayList;

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
	
	public void addProduct(String name, int price, int refNum, int stockUnits, int soldUnits, int cost,String color) {
		Accesory a = new Accesory(name,price,refNum,stockUnits,soldUnits,cost,color);
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
	
	public void addProduct(String name, int price, int refNum, int stockUnits, int soldUnits, int cost,String color,String size) {
		Toy a = new Toy(name,price,refNum,stockUnits,soldUnits,cost,color,size);
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
	public void addProduct(String name, int price, int refNum, int stockUnits, int soldUnits, int cost,String specie,double weight) {
		Food a = new Food(name,price,refNum,stockUnits,soldUnits,cost,specie,weight);
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
	
	public ArrayList<Product> showProducts(){
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
	
}
