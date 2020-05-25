package model;

public class Food extends Product implements Species{

	private String species;
	private double weight;

	public Food(String n, int p, String rn, int su, int cos,int stu,String type, String s, double w) {
		super(n,p,rn,su,su,cos,type);
		species = s;
		weight = w;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
