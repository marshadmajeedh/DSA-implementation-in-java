class Appointment {
	
	private int appointmentID;
	private String patientName;
	private String doctorName;
	private String timeSlot;
	private static int provideuniqueID = 1;
	
	public Appointment(String patientName, String doctorName, String timeSlot) {
		
		this.appointmentID = provideuniqueID++;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.timeSlot = timeSlot;
		
	}
	
	public int getAppID() {
		
		return appointmentID;
		
	}
	
	public String getPName() {
		
		return patientName;
		
	}
	
	public String getDName() {
		
		return doctorName;
		
	}
	
	public String getTimeSlot() {
		
		return timeSlot;
		
	}
	
	public String toString() {
		
		return "[ID : "+appointmentID+"]"+" "+
				patientName+" - "+" "+
				doctorName+" "+
				"at " +timeSlot+"AM";
				
	}
	
}

class AppointmentNode {
	
	Appointment data;
	AppointmentNode next;
	
	public AppointmentNode(Appointment data) {
		
		this.data = data;
		this.next = null;
		
	}
	
}

class AppointmentList {
	
	AppointmentNode head;
	
	public void addAppointment(Appointment data) {
		
		AppointmentNode newAppNode = new AppointmentNode(data);
		
		if (head == null) {
		
			head = newAppNode;
			return;
			
		}
		
		AppointmentNode current = head;
		
		while (current.next != null) {
			
			current = current.next;
			
		}
		
		current.next = newAppNode;
		
	}
	
	public Appointment getNextAppointMent() {
		
		if (head == null) {
			
			System.out.println ("Appointment list is empty!");
			return null;
			
		}
		
		Appointment a = head.data;
		head = head.next;
		return a;
		
	}
	
	public void displayAllAppointment() {
		
		if (head == null) {
			
			System.out.println ("Appointment list is empty!");
			return;
			
		}
		
		AppointmentNode current = head;
		
		while (current != null) {
			
			System.out.println (current.data);
			System.out.println();
			current = current.next;
			
		}
		
	}
	
	public boolean hasAppointment() {
		
		return head != null;
		
	}
	
	public void cancelAppointment(int id) {
		
		AppointmentNode current = head;
		AppointmentNode previous = head;
		
		if (head.data.getAppID() == id) {
			
			System.out.println (head.data);
			head = head.next;
			return;
			
		}
		
		while (current != null && current.data.getAppID() != id) {
			
			previous = current;
			current = current.next;
			
		}
		
		if (current == null) {
			
			System.out.println ("Given appointment id "+id+" not found in appointment list");
			return;
			
		}
		
		previous.next = current.next;
		
		System.out.println("Canceled : "+id);
	}
	
	public void addUrgentAppointment(Appointment a) {
		
		AppointmentNode newNode = new AppointmentNode(a);
		if (head == null) {
			
			head = newNode;
			return;
			
		}
		
		newNode.next = head;
		head = newNode;
	
		System.out.println (a);
	}		
	
}

public class AppointmentManagementSystem {
	public static void main (String...args) {
		
		AppointmentList aList = new AppointmentList();
		
		Appointment a1 = new Appointment("Alice","Dr. Smith","10:00");
		Appointment a2 = new Appointment("Bob","Dr. Pathirana","10:30");
		Appointment a3 = new Appointment("Charlie","Dr. Wilsom","11:00");
		Appointment a4 = new Appointment("Logan","Dr. Johnny","11:30");
		
		aList.addAppointment(a1);
		aList.addAppointment(a2);
		aList.addAppointment(a3);
		
		System.out.println ("All appointments->");
		aList.displayAllAppointment();
		System.out.println();
		
		System.out.println("Next appointment->");
		System.out.println(aList.getNextAppointMent());
		System.out.println();
		
		System.out.println ("Canceled appointment->");
		aList.cancelAppointment(2);
		System.out.println();
		
		System.out.println("Urgent appointment added->");
		aList.addUrgentAppointment(a4);
		System.out.println();
		
		System.out.println("Remaining appointments :");
		aList.displayAllAppointment();
		
	}
	
}