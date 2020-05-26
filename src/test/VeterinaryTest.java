package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import customException.MedicalRecordDontExistYet;
import customException.NoItemsInStockException;
import customException.PatientNotFoundException;
import customException.ProductNotFoundException;
import model.Accesory;
import model.Animal;
import model.Owner;
import model.Product;
import model.Veterinary;

class VeterinaryTest {
	
	private Veterinary obj;
	
	public VeterinaryTest() {
		obj=new Veterinary();
	}
	//woohhooas
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
		
		//add 2 dogs
		obj.addPatient("lucas", "1234567", "Akita Inu", 5, "huele a limon :v", Animal.HEALTHY, "dfdas", null, "Dog", 0);
		obj.addPatient("roberto", "9999999", "Bobtail", 10, "le gusta morder zapatos", Animal.HEALTHY, "dsfa", null, "Dog", 0);
		//add 2 cats
		obj.addPatient("pelusa", "0000134", "Savannah", 4, "anda enojado a cada rato", Animal.HEALTHY, "dfg", null, "Cat", 1);
		obj.addPatient("kuro", "2683563", "Gato birmano", 2, "ya no se que inventarme", Animal.HEALTHY, "efs", null, "Cat", 1);
		//add 2 rodents
		obj.addPatient("roberto", "3850275", "Hamster Campbell", 1, "aaaa", Animal.HEALTHY, "gfd", null, "Rodent", 3);
		obj.addPatient("nose", "3920582", "Hamster Roborovski", 2, "bbbb", Animal.HEALTHY, "fgre", null, "Rodent", 3);
		//add 2 birds
		obj.addPatient("Charlie", "4829458", "canario", 2, "cccc", Animal.HEALTHY, "dfgd", null, "Bird", 2);
		obj.addPatient("Kiwi", "3820457", "loro", 3, "dddd", Animal.HEALTHY, "rgea", null, "Bird", 2);
		
		
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
	public void deleteProductTest() throws ProductNotFoundException{
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
		try {
			obj.deleteProduct("241223"); ///////////////
			fail();
		}catch(ProductNotFoundException e) {
			
		}

	
	}
	
	@Test
	public void lookForProductTest() throws ProductNotFoundException {
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
		try {
			p = obj.lookForProduct("0000"); ////////////////////
			fail();
		}catch(ProductNotFoundException e) {
			
		}
			
	}
	
	@Test
	public void increaseStockTest() throws ProductNotFoundException {
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
		setup2();
		Animal current = obj.getFirstAnimal();
		assertTrue(current.getId().equalsIgnoreCase("1234567"));
		current = current.getNext();
		assertTrue(current.getId().equalsIgnoreCase("9999999"));
		current = current.getNext();
		assertTrue(current.getId().equalsIgnoreCase("0000134"));
		current = current.getNext();
		assertTrue(current.getId().equalsIgnoreCase("2683563"));
		current = current.getNext();
		assertTrue(current.getId().equalsIgnoreCase("3850275"));
		current = current.getNext();
		assertTrue(current.getId().equalsIgnoreCase("3920582"));
		current = current.getNext();
		assertTrue(current.getId().equalsIgnoreCase("4829458"));
		current = current.getNext();
		assertTrue(current.getId().equalsIgnoreCase("3820457"));
		current = current.getNext();
		assertTrue(current==null);
	}
	
	@Test
	public void lookForPatientTest() throws PatientNotFoundException {
		setup2();
		Animal look = obj.lookForPatient("1234567");
		assertTrue(look.getName().equalsIgnoreCase("lucas"));////////
		try {
			look = obj.lookForPatient("2343333"); ///////////////
			fail();
		}catch(PatientNotFoundException e) {
			
		}

		look=obj.lookForPatient("3850275");
		assertTrue(look.getName().equalsIgnoreCase("roberto"));
	}
	
	@Test
	public void changePatientStatusTest() {
		setup2();
		Animal current =null;
		try {
			obj.ChangePatientStatus("1234567", Animal.HOSPITALIZED);
			current=obj.getFirstAnimal();
			assertTrue(current.getStatus().equalsIgnoreCase(Animal.HOSPITALIZED));
			obj.ChangePatientStatus("1234567", Animal.HEALTHY);
			current=obj.getFirstAnimal();
			assertTrue(current.getStatus().equalsIgnoreCase(Animal.HEALTHY));
		} catch (PatientNotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void deletePatientTest() throws PatientNotFoundException {
		setup2();
		//delete the first animal
		obj.deletePatient("1234567");
		try {
			obj.lookForPatient("1234567");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//delete the last animal
		obj.deletePatient("3820457");
		try {
			obj.lookForPatient("3820457");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//delete an animal from the middle
		obj.deletePatient("3850275");
		try {
			obj.lookForPatient("3850275");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//delete the first animal
		obj.deletePatient("9999999");
		try {
			obj.lookForPatient("9999999");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//delete the last animal
		obj.deletePatient("4829458");
		try {
			obj.lookForPatient("4829458");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//delete an animal from the middle
		obj.deletePatient("2683563");
		try {
			obj.lookForPatient("2683563");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//delete the last animal
		obj.deletePatient("3920582");
		try {
			obj.lookForPatient("3920582");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//delete the first and unique animal
		obj.deletePatient("0000134");
		try {
			obj.lookForPatient("0000134");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		//do not delete anything because there are not animals
		
		try {
			obj.lookForPatient("1234567");
			fail();
		}catch(PatientNotFoundException e) {
			
		}
		
	}
	
	@Test 
	public void createMedicalRecordTest() throws MedicalRecordDontExistYet {
		setup2();
		try {
			obj.createMedicalRecord("1234567", "general info", "detallada info");
			assertTrue(obj.getFirstAnimal().getMedicalRecord()!=null);
			assertTrue(obj.getFirstAnimal().getMedicalRecord().getGeneralInfo().equalsIgnoreCase("general info"));
			assertTrue(obj.getFirstAnimal().getMedicalRecord().getDetailInfo().equalsIgnoreCase("detallada info"));
			obj.createMedicalRecord("3820457", "genInfo2", "detInfo2");
			assertTrue(obj.getLastAnimal().getMedicalRecord()!=null);
			assertTrue(obj.getLastAnimal().getMedicalRecord().getGeneralInfo().equalsIgnoreCase("genInfo2"));
			assertTrue(obj.getLastAnimal().getMedicalRecord().getDetailInfo().equalsIgnoreCase("detInfo2"));
		} catch (PatientNotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void  updateMedicalRecordTest() {
		setup2();
		try {
			obj.createMedicalRecord("1234567", "general info", "detallada info");
			obj.updateMedicalRecord("1234567", "newInfo1", "newInfo2");
			assertTrue(obj.getFirstAnimal().getMedicalRecord().getGeneralInfo().equalsIgnoreCase("newInfo1"));
			assertTrue(obj.getFirstAnimal().getMedicalRecord().getDetailInfo().equalsIgnoreCase("newInfo2"));
			obj.updateMedicalRecord("3820457", "fail", "fail");
			fail();
		} catch (MedicalRecordDontExistYet e) {
			
		} catch (PatientNotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void updateMedicalHistoryTest() {
		setup2();
		try {
			obj.updateMedicalHistory("1234567", "History1");
			obj.updateMedicalHistory("1234567", "History2");
			assertTrue(obj.getFirstAnimal().getMedicalHistory().equalsIgnoreCase("dfdas"+"\n"
					+"History1"+"\n"
					+"History2"));
		} catch (PatientNotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void showAllProductsByPriceTest() {
		setup1();
		List<Product> products = obj.showAllProductsByPrice();		
		
		assertTrue(products.get(0).getPrice().equalsIgnoreCase("2000"));
		assertTrue(products.get(1).getPrice().equalsIgnoreCase("2000"));
		assertTrue(products.get(2).getPrice().equalsIgnoreCase("2500"));
		assertTrue(products.get(3).getPrice().equalsIgnoreCase("2500"));
		assertTrue(products.get(4).getPrice().equalsIgnoreCase("3000"));
		assertTrue(products.get(5).getPrice().equalsIgnoreCase("3000"));
		
	}
	@Test
	public void showAllProductsByRefNumTest() {
		setup1();
		List<Product> products = obj.showAllProductsByRefNum();	
		
		assertTrue(products.get(0).getRefNum().equalsIgnoreCase("0134"));
		assertTrue(products.get(1).getRefNum().equalsIgnoreCase("2345"));
		assertTrue(products.get(2).getRefNum().equalsIgnoreCase("3456"));
		assertTrue(products.get(3).getRefNum().equalsIgnoreCase("3498"));
		assertTrue(products.get(4).getRefNum().equalsIgnoreCase("4356"));
		assertTrue(products.get(5).getRefNum().equalsIgnoreCase("4567"));
		
	}
	
	@Test
	public void showAllProductsByType() {
		setup1();
		List<Product> products = obj.showAllProductsByType();

		assertTrue(products.get(0).getType().equalsIgnoreCase("accesory"));
		assertTrue(products.get(1).getType().equalsIgnoreCase("accesory"));
		assertTrue(products.get(2).getType().equalsIgnoreCase("food"));
		assertTrue(products.get(3).getType().equalsIgnoreCase("food"));
		assertTrue(products.get(4).getType().equalsIgnoreCase("toy"));
		assertTrue(products.get(5).getType().equalsIgnoreCase("toy"));
		
	}
	
	@Test
	public void showAllProductsByAge() {
		setup2();
		List<Animal> animals = obj.showAllPatientByAge();
		
		assertTrue(animals.get(0).getAge().equalsIgnoreCase("1"));
		assertTrue(animals.get(1).getAge().equalsIgnoreCase("2"));
		assertTrue(animals.get(2).getAge().equalsIgnoreCase("2"));
		assertTrue(animals.get(3).getAge().equalsIgnoreCase("2"));
		assertTrue(animals.get(4).getAge().equalsIgnoreCase("3"));
		assertTrue(animals.get(5).getAge().equalsIgnoreCase("4"));
		assertTrue(animals.get(6).getAge().equalsIgnoreCase("5"));	
		assertTrue(animals.get(7).getAge().equalsIgnoreCase("10"));
	}
	
	@Test
	public void showAllProductsByProfit() {
		setup1();
		
		Product current = obj.getFirstProduct();
		while(current!=null) {
			current.sellProduct(2);		
			current=current.getNext();
		}
		List<Product> products = obj.showProductsByProfits();
		
		assertTrue(products.get(0).getProfits().equalsIgnoreCase("4000"));//////////
		assertTrue(products.get(1).getProfits().equalsIgnoreCase("4000"));
		assertTrue(products.get(2).getProfits().equalsIgnoreCase("5000"));
		assertTrue(products.get(3).getProfits().equalsIgnoreCase("5000"));
		assertTrue(products.get(4).getProfits().equalsIgnoreCase("6000"));
		assertTrue(products.get(5).getProfits().equalsIgnoreCase("6000"));
	
	}
	
	@Test
	public void showCertainTypeOfProductTest() {
		setup1();
		
		List<Product> products = obj.showCertainTypeOfProduct("Accesory");
		
		assertTrue(products.get(0).getName().equalsIgnoreCase("collar"));
		assertTrue(products.get(1).getName().equalsIgnoreCase("correa"));
		
	
	}
	@Test
	public void showAllPatientsBySpecieTest() {
		setup2();
		
		List<Animal> animals = obj.showAllPatientBySpecie();
		
		
		assertTrue(animals.get(0).getSpecie().equalsIgnoreCase("Bird")); ///////////////
		assertTrue(animals.get(1).getSpecie().equalsIgnoreCase("Bird"));
		assertTrue(animals.get(2).getSpecie().equalsIgnoreCase("Cat"));
		assertTrue(animals.get(3).getSpecie().equalsIgnoreCase("Cat"));
		assertTrue(animals.get(4).getSpecie().equalsIgnoreCase("Dog"));
		assertTrue(animals.get(5).getSpecie().equalsIgnoreCase("Dog"));
		assertTrue(animals.get(6).getSpecie().equalsIgnoreCase("Rodent"));
		assertTrue(animals.get(7).getSpecie().equalsIgnoreCase("Rodent"));
		
	}
	
	@Test
	public void showAllPatientByID() {
		setup2();
		List<Animal> animals = obj.showAllPatientByID();

		assertTrue(animals.get(0).getId().equalsIgnoreCase("0000134"));
		assertTrue(animals.get(1).getId().equalsIgnoreCase("1234567"));
		assertTrue(animals.get(2).getId().equalsIgnoreCase("2683563"));
		assertTrue(animals.get(3).getId().equalsIgnoreCase("3820457"));
		assertTrue(animals.get(4).getId().equalsIgnoreCase("3850275"));
		assertTrue(animals.get(5).getId().equalsIgnoreCase("3920582"));
		assertTrue(animals.get(6).getId().equalsIgnoreCase("4829458"));
		assertTrue(animals.get(7).getId().equalsIgnoreCase("9999999"));
	}
	
	
}
