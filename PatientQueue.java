import java.util.ArrayList;
class Patient {
	
	private int patientID;
	private String name;
	private String conditionSeverity;
	private static int uniqueID = 1;
	
	public Patient(String name, String conditionSeverity) {
		
		this.patientID = uniqueID++;
		this.name = name;
		this.conditionSeverity = conditionSeverity;
		
	}
	
	public String toString() {
		
		return "Patient ID : "+patientID+"\n"+
				"Patient name : "+name+"\n"+
				"Patient condition severity "+conditionSeverity;
				
	}
	
}

class PatientQueue {
	
	private ArrayList<Patient>patients;
	private int front;
	
	public PatientQueue() {
		
		this.patients = new ArrayList<>();
		this.front = 0;
		
	}
	
	public void addPatient(Patient p) {
		
		patients.add(p);
		
	}
	
	public boolean hasPatients() {
		
		return front < patients.size();
		
	}
	
	public Patient getNextPatient() {
		
		if (!hasPatients()) {
			
			return null;
			
		}
		
		Patient p = patients.remove(front);
		
		return p;
		
	}
	
	public void displayAllPatients() {
		
		if (!hasPatients()) {
			
			System.out.println("No patients to display.");
			return;
			
		}
		
		for (int i = front; i < patients.size(); i++) {
			
			System.out.println(patients.get(i));
			
		}
	}
}
	
	
		