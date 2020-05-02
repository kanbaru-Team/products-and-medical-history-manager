package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Accesory;
import model.Product;
import model.Veterinary;

class VeterinaryTest {
	
	private Veterinary obj;
	
	Accesory n1 = new Accesory("hola", 2500, 0100, 20, 35, 1500,"blue");
	Accesory n2 = new Accesory("uwu", 2500, 0100, 20, 35, 1500,"blue");
	Accesory n3 = new Accesory("mid", 2500, 0100, 20, 35, 1500,"blue");
	Accesory n4 = new Accesory("nicer", 2500, 0100, 20, 35, 1500,"blue");
	Accesory n5 = new Accesory("frt", 2500, 0100, 20, 35, 1500,"blue");
	Accesory n6 = new Accesory("pro", 2500, 0100, 20, 35, 1500,"blue");
	
	public void setup1() {
		obj.addProduct("hola", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("uwu", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("mid", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("nicer", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("frt", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("pro", 2500, 0100, 20, 35, 1500,"blue");
	}
	
	public void setup2() {
		obj.addProduct("hola", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("uwu", 2500, 0100, 20, 35, 1500,"blue");
	}
	
	public void setup3() {
		obj.addProduct("hola", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("uwu", 2500, 0100, 20, 35, 1500,"blue");
		obj.addProduct("mid", 2500, 0100, 20, 35, 1500,"blue");
	}

	
	@Test
	void test() {
		Product current = obj.getFirstProduct();
		assertTrue(current.getName().equalsIgnoreCase(n1.getName()));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase(n2.getName()));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase(n3.getName()));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase(n4.getName()));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase(n5.getName()));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase(n6.getName()));
		
	}

}
