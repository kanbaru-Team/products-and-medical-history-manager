package customException;

@SuppressWarnings("serial")
public class MedicalRecordDontExistYet extends Exception {
	private String id;
	public MedicalRecordDontExistYet(String id) {
		super("The medical record has not been created yet or already exist. ");
		this.id=id;
	}
	
	@Override
	public String toString() {
		String msg = "The patient identified with the ID "+id+ " dont have a medical record assigned yet or you're trying to create a new Medical Record in this case you have to update it.";
		return super.getMessage()+msg;
	}
}
