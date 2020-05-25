package customException;

@SuppressWarnings("serial")
public class MedicalRecordDontExistYet extends Exception {
	private String name;
	private String id;
	public MedicalRecordDontExistYet(String name,String id) {
		super("The medical record has not been created yet. ");
		this.name=name;
		this.id=id;
	}
	
	@Override
	public String toString() {
		String msg = "The patient "+name+" identified with the ID "+id+ " dont have a medical record assigned yet";
		return super.toString()+msg;
	}
}
