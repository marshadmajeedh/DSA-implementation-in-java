import java.util.ArrayList;
class Ticket {
	
	private int ticketID;
	private String customerName;
	private String issueDescription;
	private static int countTicketID = 1 ;
	
	public Ticket(String customerName, String issueDescription) {
		
		this.ticketID = countTicketID++;
		this.customerName = customerName;
		this.issueDescription = issueDescription;
		
	}
	
	public int getTicketID() {
		
		return ticketID;
		
	}
	
	public String getCustomerName() {
		
		return customerName;
		
	}
	
	public String getIssueDescription() {
		
		return issueDescription;
		
	}
	
	public String toString() {
		
		return "Ticket ID : "+ticketID+"\n"
		+"Customer name : "+customerName+"\n"
		+"Issue description : "+issueDescription;
		
	}
	
}

class TicketQueue {
	
	private int front;
	private ArrayList<Ticket>tickets;
	
	public TicketQueue() {
		
		this.tickets = new ArrayList<>();
		this.front = 0;
		
	}
	
	public boolean hasTicket() {
		
		return front < tickets.size();
		
	}
	
	public void addTicket(Ticket ticket) {
		
		tickets.add(ticket);
		
	}
	
	public Ticket getNextTicket() {
		
		
		if (!hasTicket()) {
			
			return null;
			
		}
		
		Ticket t = tickets.get(front++);
		tickets.remove(front);
		return t;
			
	}
	
	public void displayAllTickets() {
		
		if (!hasTicket()) {
			
			System.out.println ("No tickets to display");
			return;
			
		}
		for (int i = front; i < tickets.size(); i++) {
			
			System.out.println();
			System.out.println(tickets.get(i));
			System.out.println();
			
		}
		
	}
	
}
public class CustomerServiceTicketingSystem {
	public static void main (String...args) {
		
		Ticket t1 = new Ticket("Marshad","fianace");
		Ticket t2 = new Ticket("arshad","ianace");
		Ticket t3 = new Ticket("rshad","anace");
		
		TicketQueue tq = new TicketQueue();
		
		System.out.println ("Has ticket : "+(tq.hasTicket() ? "Yes" : "No"));
		System.out.println();
		tq.addTicket(t1);
		tq.addTicket(t2);
		tq.addTicket(t3);
		
		System.out.println ("Has ticket : "+(tq.hasTicket() ? "Yes" : "No"));
		System.out.println();
		System.out.println ("Next ticket is : "+tq.getNextTicket());
		tq.displayAllTickets();
		
	}
	
}