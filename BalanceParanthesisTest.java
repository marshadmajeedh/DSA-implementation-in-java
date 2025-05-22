import java.util.*;
class StackArray {
	
	int maxSize;
	int rear;
	char[] paranthesis;
	
	public StackArray (int maxSize) {
		
		this.rear = -1;
		this.maxSize = maxSize;
		this.paranthesis = new char[maxSize];
		
	}
	
	public boolean isEmpty() {
		
		return rear == -1;
		
	}
	
	public boolean isFull() {
		
		return rear == maxSize - 1;
		
	}
	
	public void push (char ch) {
		
		if (isFull()) {
			
			System.out.println ("cannot push : stack is full");
			return;
		}
		
		paranthesis[++rear] = ch;
		System.out.println ("pushed : "+ch);
		
	}
	
	public char pop() {
		
		if (isEmpty()) {
			
			System.out.println ("connot pop : stack is empty");
			return '0';
		}
		
		return paranthesis[rear--];
		
	}
	
	public boolean isBalancedParanthesis(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if (ch == '(' || ch == '[' || ch == '{') {
				
				push(ch);
				
			} else if (ch == ')' || ch == ']' || ch == '}') {
				
				if (isEmpty()) {
					
					return false;
					
				}
				
				char poppedChar = pop();
				
				if (ch == ')' && poppedChar != '(' || ch == ']' && poppedChar != '[' || ch == '}' && poppedChar != '{') {
					
					return false;
					
				}
			
			}
		}
		
		return isEmpty();
		
	}
	
	public boolean isBalanced (String string) {
		
		for (int i = 0; i < str.length(); i++) {
			
			char currentChar = str.charAt(i);
			
			if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
				
				push(currentChar);
				
			} else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
				
				if (isEmpty()) {
					
					return false;
					
				}
				
				char poopedTop = pop();
				
				if (currentChar == ')' && poopedTop != '(' || currentChar == ']' && poopedTop != '[' || currentChar == '}' && poopedTop != '{') {
					
					return false;
					
				}
				
				}
		}
		
		return isEmpty();
		
	}
		
}

public class BalanceParanthesisTest {
	
	public static void main (String...args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter an expression with balanced paranthesis : ");
		String str = sc.nextLine();
		
		StackArray ib = new StackArray (str.length());
		
		System.out.println ("Is this "+str+", has balanced paranthesis : "+(ib.isBalancedParanthesis(str) ? "Yes " : "No"));
		
	}
	
}