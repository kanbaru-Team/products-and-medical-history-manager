package threads;


import java.util.List;

import javafx.application.Platform;
import model.Product;
import model.Veterinary;
import ui.RegisteredProductsGUI;

public class RegisteredProductsThread extends Thread{
	
	private RegisteredProductsGUI registeredProductsGUI;
	private Veterinary veterinary;
	private boolean flag = true;
	private List<Product> products;
	
	public RegisteredProductsThread(RegisteredProductsGUI rpGUI, Veterinary vet) {
		registeredProductsGUI = rpGUI;
		veterinary = vet;
	}
	
	@Override
	public void run() {
		
		while(flag) {
			String operation = registeredProductsGUI.getComboBox();
			
			if(operation.equalsIgnoreCase("all")) {
				products = veterinary.showAllProducts();
			}else if(operation.equalsIgnoreCase("Ordenar por precio")) {
				products = veterinary.showAllProductsByPrice();
			}else if(operation.equalsIgnoreCase("Ordenar por tipo")) {
				products = veterinary.showAllProductsByType();
			}else if(operation.equalsIgnoreCase("Ordenar por referencia")) {
				products = veterinary.showAllProductsByRefNum();
			}else if(operation.equalsIgnoreCase("Ordenar por beneficios")) {
				products = veterinary.showProductsByProfits();
			}else if(operation.equalsIgnoreCase("Mostrar Accesorios")) {
				products = veterinary.showCertainTypeOfProduct("Accesory");
			}else if(operation.equalsIgnoreCase("Mostrar Comida")) {
				products = veterinary.showCertainTypeOfProduct("Food");
			}else if(operation.equalsIgnoreCase("Mostrar Juguetes")) {
				products = veterinary.showCertainTypeOfProduct("Toy");
			}
			
			Platform.runLater(new Thread() {
				@Override
				public void run() {
					registeredProductsGUI.initializeTableView(products);
				}
			});
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setFlag(boolean f) {
		flag = f;
	}
	
}
