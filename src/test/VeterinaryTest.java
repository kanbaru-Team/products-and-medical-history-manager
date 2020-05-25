package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customException.NoItemsInStockException;
import model.Accesory;
import model.Owner;
import model.Product;
import model.Veterinary;

class VeterinaryTest {
	
	private Veterinary obj;
	
	public VeterinaryTest() {
		obj=new Veterinary();
	}
	
	public void setup1() {
		//add 2 products type accesory
		obj.addProduct("collar", 2500, "0134", 30, 0, 500, "Accesory", "Blue");
		obj.addProduct("correa", 2500, "2345", 30, 0, 500, "Accesory", "Red");
		//add 2 products type toy
		obj.addProduct("muneco", 2000, "4356", 30, 0, 500, "Toy", "White", "grande");
		obj.addProduct("pelota", 2000, "4567", 30, 0, 500, "Toy", "Green", "pequeno");
		//add 2 products type food
		obj.addProduct("croqueta", 3000, "3456", 40, 0, 3600, "Food", "Dog", 10000);
		obj.addProduct("carrot", 3000, "3498", 40, 0, 3600, "Food", "Rodent", 10000);
	}
	
	public void setup2() {
		/*
		//add 2 dogs
		obj.addPatient("lucas", "1234567", "Akita Inu", 5, "huele a limon :v", s, m, mh, o, other, patientType);
		obj.addPatient("roberto", "9999999", "Bobtail", 10, "le gusta morder zapatos", s, m, mh, o, other, patientType);
		//add 2 cats
		obj.addPatient("pelusa", "0000134", "Savannah", 4, "anda enojado a cada rato", s, m, mh, o, other, patientType);
		obj.addPatient("kuro", "2683563", "Gato birmano", 2, "ya no se que inventarme", s, m, mh, o, other, patientType);
		//add 2 rodents
		obj.addPatient("roberto", "3850275", "Hamster Campbell", 1, "aaaa", s, m, mh, o, other, patientType);
		obj.addPatient("nose", "3920582", "Hamster Roborovski", 2, "bbbb", s, m, mh, o, other, patientType);
		//add 2 birds
		obj.addPatient("Charlie", "4829458", "canario", 2, "cccc", s, m, mh, o, other, patientType);
		obj.addPatient("Kiwi", "3820457", "loro", 3, "dddd", s, m, mh, o, other, patientType);
		*/
		
	}
	public void setup3() {
		obj.addOwner((long)5433434246.0, "Marco Vasquez", "en la esquina", "3126323");
		//add right child of the root
		obj.addOwner((long)7033524522.0, "Jose Jose", "la casa", "564321");
		//add left child of the root
		obj.addOwner((long)3356654432.0, "jolyne cujoh", "por ahi", "654212");
		//add right child of the right child of the root
		obj.addOwner((long)8433434246.0, "Araragi Koyomi", "el lado de la tienda de don jose", "31639886825");
		//add left child of the right child of the root
		obj.addOwner((long)6673456645.0, "Carlitos", "hueco", "22234254");
		//add right child of the right left of the root
		obj.addOwner((long)2839393893.0, "Senku Ishigami", "los santons", "1556356");
		//add left child of the right left of the root
		obj.addOwner((long)4938483938.0, "arnold", "pinocho's house", "32446423");	
	}
	public void setup4() {
		
	}
	
	@Test
	public void addProductTest() {
		setup1();
		Product current = obj.getFirstProduct();
		assertTrue(current.getName().equalsIgnoreCase("collar"));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase("correa"));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase("muneco"));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase("pelota"));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase("croqueta"));
		current=current.getNext();
		assertTrue(current.getName().equalsIgnoreCase("carrot"));

	}
	
	@Test
	public void deleteProductTest() {
		setup1();
		obj.deleteProduct("0134");
		assertTrue(obj.getFirstProduct().getRefNum().equalsIgnoreCase("2345"));
		//borrar el ultimo
		obj.deleteProduct("3498");
		assertTrue(obj.getLastProduct().getRefNum().equalsIgnoreCase("3456"));
		//borrar el antepenultimo
		obj.deleteProduct("4567");
		assertTrue(obj.getLastProduct().getPrev().getRefNum().equalsIgnoreCase("4356"));
		//borrar el de la mitad
		obj.deleteProduct("4356");
		assertTrue(obj.getFirstProduct().getNext()==obj.getLastProduct());
		//borrar primero
		obj.deleteProduct("2345");
		assertTrue(obj.getFirstProduct().getRefNum().equalsIgnoreCase("3456"));
		//borrar primero, despues de esto tanto primero tienen que ser null
		obj.deleteProduct("3456");
		assertTrue(obj.getFirstProduct()==null);
		//borrar uno inexistente
		obj.deleteProduct("241223");
	
	}
	
	@Test
	public void lookForProductTest() {
		setup1();
		Product p = null;
		//buscar el primero
		p = obj.lookForProduct("0134");
		assertTrue(p.getName().equalsIgnoreCase("collar"));
		assertTrue(p.getRefNum().equalsIgnoreCase("0134"));
		//buscar el ultimo
		p = obj.lookForProduct("3498");
		assertTrue(p.getName().equalsIgnoreCase("carrot"));
		assertTrue(p.getRefNum().equalsIgnoreCase("3498"));
		//buscar el de la mitad
		p = obj.lookForProduct("4356");
		assertTrue(p.getName().equalsIgnoreCase("muneco"));
		assertTrue(p.getRefNum().equalsIgnoreCase("4356"));
		//buscar uno inexistente
		p = obj.lookForProduct("0000");
		assertTrue(p==null);
			
	}
	
	@Test
	public void increaseStockTest() {
		setup1();
		obj.increaseStock("0134", 5);
		assertTrue(obj.getFirstProduct().getStockUnits().equalsIgnoreCase("35"));
		obj.increaseStock("0134", 3);
		assertTrue(obj.getFirstProduct().getStockUnits().equalsIgnoreCase("38"));
	}
	
	@Test
	public void sellProductTest() {
		setup1();
		try {
			obj.sellProduct("0134", 5);
		} catch (NoItemsInStockException e) {
			fail();
		}
		assertTrue(obj.getFirstProduct().getSoldUnits().equalsIgnoreCase("5"));
		assertTrue(obj.getFirstProduct().getStockUnits().equalsIgnoreCase("25"));
		try {
			obj.sellProduct("0134", 15);
		} catch (NoItemsInStockException e) {
			fail();
		}
		assertTrue(obj.getFirstProduct().getSoldUnits().equalsIgnoreCase("20"));
		assertTrue(obj.getFirstProduct().getStockUnits().equalsIgnoreCase("10"));
		try {
			obj.sellProduct("0134", 30);
			fail();
		}catch (NoItemsInStockException e) {
			System.out.println(e.toString());
		}
		
	}
	
	@Test
	public void addOwnerTest() {
		//add root
		assertTrue(obj.addOwner((long)5433434246.0, "Marco Vasquez", "en la esquina", "3126323"));
		//add right child of the root
		assertTrue(obj.addOwner((long)7033524522.0, "Jose Jose", "la casa", "564321"));
		//add left child of the root
		assertTrue(obj.addOwner((long)3356654432.0, "jolyne cujoh", "por ahi", "654212"));
		//add right child of the right child of the root
		assertTrue(obj.addOwner((long)8433434246.0, "Araragi Koyomi", "el lado de la tienda de don jose", "31639886825"));
		//add left child of the right child of the root
		assertTrue(obj.addOwner((long)6673456645.0, "Carlitos", "hueco", "22234254"));
		//add right child of the right left of the root
		assertTrue(obj.addOwner((long)2839393893.0, "Senku Ishigami", "los santons", "1556356"));
		//add left child of the right left of the root
		assertTrue(obj.addOwner((long)4938483938.0, "arnold", "pinocho's house", "32446423"));	
		
		Owner current = obj.getFirstOwner();
		assertTrue(current.getId()==(long)5433434246.0);
		assertTrue(current.getRight().getId()==(long)7033524522.0);
		assertTrue(current.getRight().getRight().getId()==(long)8433434246.0);
		assertTrue(current.getRight().getLeft().getId()==(long)6673456645.0);
		assertTrue(current.getLeft().getId()==(long)3356654432.0);
		assertTrue(current.getLeft().getLeft().getId()==(long)2839393893.0);
		assertTrue(current.getLeft().getRight().getId()==(long)4938483938.0);
		
	}
	
	@Test
	public void lookForOwnerTest() {
		setup3();
		assertTrue(obj.lookForOwner((long)5433434246.0).getName().equalsIgnoreCase("Marco Vasquez"));
		assertTrue(obj.lookForOwner((long)1673456645.0)==null);
		assertTrue(obj.lookForOwner((long)973324645.0)==null);
		assertTrue(obj.lookForOwner((long)2839393893.0).getName().equalsIgnoreCase("Senku Ishigami"));
		assertTrue(obj.lookForOwner((long)8433434246.0).getName().equalsIgnoreCase("Araragi Koyomi"));
		assertTrue(obj.lookForOwner((long)6673456645.0).getName().equalsIgnoreCase("Carlitos"));
		assertTrue(obj.lookForOwner((long)6455345445.0)==null);
		
		//luz verde
	}
	
	@Test
	public void addPatientTest() {
		
	}
}
