class Stack {
	
	private char[] array;
	private int maxSize;
	private int top;
	
	public Stack(int maxSize) {
		
		this.array = new char[maxSize];
		this.maxSize = maxSize;
		this.top = -1;
		
	}
	
	public void push(char character) {
		
		if (top == maxSize - 1) {
			
			System.out.println ("Stack is full");
			return;
			
		}
		
		array[++top] = character;
		System.out.println ("pushed element : "+array[top]);
		
	}
	
	public char pop() {
		
		if (top == -1) {
			
			System.out.println("Stack is empty!");
			return '-';
			
		}
		
		char remove = array[top];
		top = top - 1;
		return remove;
		
	}
	
	public char peek() {
		
		if (top == -1) {
			
			return '-';
			
		}
		
		return array[top];
		
	}
	
	public int size() {
		
		return maxSize;
		
	}
	
}

public class StackPractice {
	
	public static void main (String...args) {
		
		Stack newStack = new Stack(11);
		
		System.out.println ("poped character : "+newStack.pop());
		System.out.println();
		
		newStack.push('m');
		newStack.push('a');
		newStack.push('r');
		newStack.push('s');
		newStack.push('h');
		newStack.push('a');
		newStack.push('d');
		newStack.push('2');
		newStack.push('0');
		newStack.push('0');
		newStack.push('4');
		
		System.out.println();
		
		System.out.println ("poped characters : ");
		for (int c = 0; c < newStack.size(); c++ ) {
			
			System.out.print (newStack.pop()+" ");
		
		}
		
		System.out.println ("\nPeeked character : "+newStack.peek());// return the index [top ] element
		
	}
}
	

/*OUTPUT FORMAT

Stack is empty!
poped character : -				 //here top == -1 so stack is empty

pushed element : m
pushed element : a
pushed element : r
pushed element : s
pushed element : h
pushed element : a
pushed element : d
pushed element : 2
pushed element : 0
pushed element : 0
pushed element : 4

poped characters :
4 0 0 2 d a h s r a m

Peeked character : - 			//here also after popping all the characters top becomes -1 so stack is empty

*/
	