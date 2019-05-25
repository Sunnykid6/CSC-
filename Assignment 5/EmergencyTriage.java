/**
 * EmergencyTriage.java
 * Provided the necessary information here,
 * making sure to delete these lines.
 */

// This is the beginning of the source code to help you get started.
// Do not change the following:

public class EmergencyTriage {
	private Heap<ERPatient> waiting;

	/**
	 * The empty EmergencyTriage is initialized.
	 */
	public EmergencyTriage() {
		waiting = new Heap<>();
	}
	/*
	Registers a patient
	@param Patients lastName
	@param Patients firstName
	@param triageCategory
	*/
	public void register(String lastName, String firstName, String triageCategory){
		waiting.insert(new ERPatient(lastName, firstName, triageCategory));
	}
	/*
	Removes the highest priority patient from the triage
	*/
	public ERPatient admitToER(){
		return waiting.getRootItem();
	}
	/*
	Retrieves the recod of the patient who currently has the highest priority
	*/
	//public ERPatient whoIsNext(){

	//}
	/*
	Finds out how many patients have been registered but
	not yet admitted
	*/
	public int numberOfPatientsWaiting(){
		return waiting.size();
	}
	
	public static void main(String[] args){
		EmergencyTriage w = new EmergencyTriage();
		w.register("Bob", "Smith", "Life-threatening");
		w.register("John", "Deaux", "Ambulatory");
		w.register("Carl", "Sagan", "Chronic");
		w.register("Derek", "Jennejohn", "Major fracture");
		System.out.println(w.numberOfPatientsWaiting());
		System.out.println(w.admitToER());
		System.out.println(w.admitToER());
		System.out.println(w.admitToER());
		System.out.println(w.admitToER());
		
	}
}