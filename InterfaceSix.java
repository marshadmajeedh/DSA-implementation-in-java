interface Notifiable {
	
	void sendNotification();
	int getPriority();// High = 1 , Medium = 2, Low = 3
	
}

class EmailNotification implements Notifiable {
	
	private int priority;
	private String message;
	
	public EmailNotification() {
		
		this.priority = 2;
		
	}
	
	public void sendNotification() {
		
		this.message = priority == 1 ? "High" : (priority == 2 ? "Medium" : (priority == 3 ? "Low" : "priority invalid"));
		
		System.out.println (message);
		
	}
	
	public int getPriority() {
		
		return priority;
		
	}
	
}

class SMSNotification implements Notifiable{
	
	private int priority;
	private String message;
	
	public SMSNotification() {
		
		this.priority = 1;
		
	}
	
	public void sendNotification() {
		
		this.message = priority == 1 ? "High" : (priority == 2 ? "Medium" : (priority == 3 ? "Low" : "priority invalid"));
		
		System.out.println (message);
		
	}
	
	public int getPriority() {
		
		return priority;
		
	}
	
}

class PushNotification implements Notifiable {
	
	private int priority;
	private String message;
	
	public PushNotification() {
		
		this.priority = 3;
		
	}
	
	public void sendNotification() {
		
		this.message = priority == 1 ? "High" : (priority == 2 ? "Medium" : (priority == 3 ? "Low" : "priority invalid"));
		
		System.out.println (message);
		
	}
	
	public int getPriority() {
		
		return priority;
		
	}
	
}

public class InterfaceSix {
	public static void main (String...args) {
		
		Notifiable[] notify = {
			
			new EmailNotification(),// priority - 2 
			new SMSNotification(),//priority - 1 
			new PushNotification()//priority - 3
			
		};
		
		//assigning object by prioritizing there priority value
		for (int i = 1; i < notify.length; i++) {
			
			Notifiable key = notify[i];
			int j = i - 1;
			
			while (j >= 0 && notify[j].getPriority() > key.getPriority()) {
				
				notify[j + 1] = notify[j];
				j--;
			}
			
			notify[j + 1] = key;
			
		}
		
		for (Notifiable n : notify) {
			
			n.sendNotification();
			
		}
		
	}
	
}