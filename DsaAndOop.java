import java.util.*;
class MyStack {
	
	int topElement;
	ArrayList<Character>stack;
	
	public MyStack() {
		
		this.topElement = -1;
		this.stack = new ArrayList<>();
		
	}
	
	public boolean isEmpty() {
		
		return topElement == -1;
		
	}
	
	public String getStackAsString() {
		
        StringBuilder sb = new StringBuilder();
		
        for (char c : stack) {
			
            sb.append(c);
			
        }
		
        return sb.toString();
    }
	
	public void addLastElement(char character) {
		
		stack.add(character);
		topElement++;
		
	}
	
	public char removeLastElement() {
		
		if (isEmpty()) {
			
			return '0';
			
		}
		
		char removed = stack.remove(topElement);
		topElement--;
		return removed;	
		
	}
	
}

class SimpleTextEditor {
	
	private MyStack stack = new MyStack();
	
	public void typeCharacter(char character) {
		
		stack.addLastElement(character);
		
	}
	
	public char undo() {
		
		char removed = stack.removeLastElement();
		
		if (removed == '0') {
			
			System.out.println ("No existing character in the stack");
			
		}
		
		return removed;
	}
	
	public String getText() {
		
		return stack.getStackAsString();
		
	}
	
	
}

public class DsaAndOop {
	
	public static void main (String...args) {
		
		SimpleTextEditor editor = new SimpleTextEditor();
		
		editor.typeCharacter('h');
		editor.typeCharacter('e');
		editor.typeCharacter('y');
		editor.getText();
		System.out.println();
		
		System.out.println ("Removed : "+editor.undo());
		System.out.println ("Removed : "+editor.undo());
		System.out.println ("Removed : "+editor.undo());
		System.out.println ("Removed : "+editor.undo());
		
		editor.getText();
	
	}
	
}
	
	