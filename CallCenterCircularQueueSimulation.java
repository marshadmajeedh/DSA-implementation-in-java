import java.util.Scanner;
class Call {
	
	private String callerID;
	private String issueType;
	private String timestamp;
	
	public Call (String ci, String it, String tt) {
		
		this.callerID = ci;
		this.issueType = it;
		this.timestamp = tt;
		
	}
	
	public String getCallerID() {
		
		return callerID;
		
	}
	
	public String getIssueType() {
		
		return issueType;
		
	}
	
	public String getTimestamp() {
		
		return timestamp;
		
	}
	
	public String toString() {
		
		return "Caller id : "+callerID+"\n"+
				"Issue type : "+issueType+"\n"+
				"Timestamp : "+timestamp+"\n";
				
	}
	
}

class CallCenterQueue {
	
	int front;
	int rear;
	int size;
	Call[] calls;
	
	public CallCenterQueue(int size) {
		
		this.size = size;
		this.front = -1;
		this.rear = -1;
		this.calls = new Call[size];
		
	}
	
	public boolean isEmpty() {
		
		return front == -1;
		
	}
	
	public boolean isFull() {
		
		return (rear + 1) % size == front;
		
	}
	
	public void receiveCall(Call call) {
		
		if (isFull()) {
			
			System.out.println ("Cannot receive call : circular queue is full");
			return;
			
		}
		
		if (front == -1) {
			
			front = 0;
		}
		
		rear = (rear + 1) % size;
		calls[rear] = call;
		System.out.println ("Recieved call added to the circular queue");
		
	}
	
	public Call answerCall() {
		
		if (isEmpty()) {
			
			System.out.println ("Cannot answer call : circular queue is empty");
			return null;
			
		}
		
		Call dequeueCall = calls[front];
		
		if (front == rear) {
			
			front = rear = -1;
			
		} else {
			
			front = (front + 1) % size;
			
		}
		
		System.out.println ("Answered next call: ");
		return dequeueCall;
		
	}
	
	public Call peekNextCall() {
		
		if (isEmpty()) {
			
			System.out.println ("Cannot peek next call : circular queue is empty");
			return null;
			
		}
		
		return calls[front];
		
	}
	
	public void displayAllCalls() {
		
		if (isEmpty()) {
			
			System.out.println ("Cannot display all calls : circular queue is empty");
			return ;
			
		}
		
		int temp = front;
		
		System.out.println ("Displaying all calls : ");
		do {
			
			System.out.println(calls[temp]);
			temp = (temp + 1) % size;
			
		} while (temp != (rear + 1) % size);
		
	}
	
}

public class CallCenterCircularQueueSimulation {
	public static void main (String...args) {
		
		Scanner sc = new Scanner (System.in);
		
		String  continueProgram;
		int choice;
		
		CallCenterQueue ccq = new CallCenterQueue(5);
		
		do {
			
			System.out.println ("\n1) "+". Recieve new call");
			System.out.println ("2) "+". Answer next call");
			System.out.println ("3) "+". Peek next call");
			System.out.println ("4) "+". Show all calls in queue");
			System.out.println ("5) "+". Exit");
			
			System.out.print("\nChoose your choice : ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch (choice) {
				
				case 1 : 
						System.out.print("\nEnter caller ID : ");
						String callerID = sc.nextLine();
						
						System.out.print("Enter issue type : ");
						String issueType = sc.nextLine();
						
						System.out.print("Enter timestamp : ");
						String timestamp = sc.nextLine();
						
						Call call = new Call(callerID,issueType,timestamp);
						
						ccq.receiveCall(call);
						break;
						
				case 2 : 
						System.out.print(ccq.answerCall());
						break;
						
				case 3 :
						System.out.print(ccq.peekNextCall());
						break;
						
				case 4 :
						ccq.displayAllCalls();
						break;
						
				case 5 :
						System.out.print("Exiting from the program");
						break;
						
			}
			System.out.println();
			
			System.out.print("Do you want to continue this program ('y' || 'n') : ");
			continueProgram = sc.next();
			sc.nextLine();
			
		} while (continueProgram.equalsIgnoreCase("y"));
		
	}
	
}