import java.util.*;
class StackArray {
	
	int rear;
	int[] integers;
	int maxSize;
	
	public StackArray (int maxSize) {
		
		this.rear = -1;
		this.integers = new int [maxSize];
		setMaxSize(maxSize);
	}
	
	public void setMaxSize(int maxSize) {
		
		if (maxSize > 0) {
			
			this.maxSize = maxSize;
			return;
		}
		System.out.println ("Array size cannot be zero or negative");
		
	}
	
	public boolean isEmpty() {
		
		return rear == -1;
		
	}
	
	public boolean isFull() {
		
		return rear == maxSize - 1;
		
	}
	
	public void push(int item) {
		
		if (isFull()) {
			
			System.out.println ("Cant push item : "+item+", stack is full");
			return;
			
		}
		
		integers[++rear] = item;
		System.out.println("pushed : "+item);
		
	}
	
	public int pop() {
		
		if (isEmpty()) {
			
			System.out.println ("Can't pop : stack is empty");
			return -1;
			
		}
		return integers[rear--];
		
	}
	
	public int peek() {
		
		if (isEmpty()) {
			
			System.out.println ("Can't peek : stack is empty");
			return -1;
			
		}
		return integers[rear];
		
	}
	
	public void display() {
		
		System.out.println ("Elements in this stack :");
		for (int i = 0; i <= rear; i++) {
			
			System.out.print(integers[i]+" ");
			
		}
		System.out.println();
		
	}
	
	public int size() {
		
		return rear + 1;
		
	}
	
}

public class StackArrayTest {
	public static void main (String...args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter the stack size : ");
		int maxSize = Integer.parseInt(sc.nextLine());
		
		StackArray sa = new StackArray(maxSize);
		StackArray as = new StackArray(maxSize);
		
		String continueProgram;
		
		do {
			
			System.out.print("Enter a integer to push into the stack : ");
			int item = Integer.parseInt(sc.nextLine());
			
			sa.push(item);
	
			System.out.print("\nDo you want to push more intergers to the stack (y | n) : ");
			continueProgram = sc.next();
			sc.nextLine();
			System.out.println();
			
		} while(continueProgram.equalsIgnoreCase("y"));
		
		sa.display();
		System.out.println();
		
		while (!sa.isEmpty()) {
			
			int poppedInt = sa.pop();
			as.push(poppedInt);
			
		}
		System.out.println();
		
		as.display();
		System.out.println();
		
		if (sa.peek() != -1) {
			
			System.out.println ("peeked element : "+sa.peek());
		
		}
		
		if (as.peek() != -1) {
			
			System.out.println ("peeked element : "+as.peek());
			
		}

	}
	
}