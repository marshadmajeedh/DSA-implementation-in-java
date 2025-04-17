class Link {
	
	String bookID;
	String bookTitle;
	int nOfCopies;
	Link next;
	
	public Link (String bookID, String bookTitle, int nOfCopies) {
		
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.nOfCopies = nOfCopies;
		this.next = null;
		
	}
	
	public String toString() {
		
	return "Book details -> "+"\n"+
	"ID : "+bookID+"\n"+
	"Title : "+bookTitle+"\n"+
	"Copies available : "+nOfCopies+"\n";
	
	}
}

class LinkedList {
	
	Link head;
	
	public boolean isEmpty() {
		
		return head == null;
		
	}
	
	public void insertFirst(String bookID,String bookTitle, int nOfCopies) {
		
		Link newLink = new Link (bookID,bookTitle,nOfCopies);//100,101,102
		
		newLink.next = head;//null,100,101
		head = newLink;// head = 100,101,102
		System.out.println (newLink.toString());
		
	}
	
	public void insertAfter(String key,String bookID,String bookTitle, int nOfCopies) {
		
		Link newLink = new Link (bookID,bookTitle,nOfCopies);
		
		Link current = head;
		boolean isFound = false;
		
		while (current != null) {
			
			if (key.equalsIgnoreCase(current.bookID)) {
				
				isFound = true;
				break;
				
			}
			
			current = current.next;
			
		}
		
		if (isFound) {//101(insert) // 102
			
			newLink.next = current.next; // now current = 101 insert at after 101 so newLink.next = current.next(102) noew newlink next pois to 102
			current.next = newLink;// here current.next after 101 point to new link //101,103,102
			System.out.println (newLink.toString());
			
		} else {
			
			System.out.println ("Given ID "+key+" has not found in the library system");
			
		}
		
	}
	
	public void findBook (String key) {
		
		Link current = head;
		boolean isFound = false;
		
		while (current != null) {
			
			if (key.equalsIgnoreCase(current.bookID)) {
				
				isFound = true;
				break;
				
			}
			
			current = current.next;
			
		}
		
		if (isFound) {
			
			System.out.println ("Found - ");
			System.out.println ("Book title : "+current.bookTitle+", number of copies available : "+current.nOfCopies);
			
		} else {
			
			System.out.println ("Given ID "+key+" has not found in the library system");
			
		}
		
	}
	
	public String deleteFirst() {
		
		if (isEmpty()) {
			
			return "List is Empty";
			
		}
		
		String ID = head.bookID;
		head = head.next;
		return ID;
		
	}
		
	public String delete (String key) {
		
		Link current = head;
		Link previous = head;
		
		while (current != null && !key.equalsIgnoreCase(current.bookID)) {
			
			previous = current;//this point to previous Link
			current = current.next;
			
		}
		
		if (current == head) {
			
			head = head.next;
			return key;
			
		}
		
		if (current == null) {
			
			return "Given book ID not found in the list";
			
		}
		
		previous.next = current.next;
		
		return key;
		
	}
	
	public void displayList() {
		
		Link current = head;
		
		System.out.println ("Books available ->");
		while (current != null) {
			
			System.out.println ("Book ID : "+current.bookID+", Book title : "+current.bookTitle+", Number of copies available : "+current.nOfCopies);
			
			current = current.next;
			
		}
		
	}
	
}

public class ListMain {
	
	public static void main (String...args) {
		
		LinkedList list = new LinkedList ();
		
		list.insertFirst("ISBN1010","Money",2);
		list.insertFirst("ISBN1030","soney",4);
		list.insertAfter("ISBN1010","ISBN1020","Johnny",5);
		System.out.println();
		list.displayList();
		System.out.println();
		
		list.insertAfter("ISBN1040","ISBN1050","fohnny",6);
		System.out.println();
		
		list.findBook("ISBN1020");
		System.out.println();
		
		System.out.println("Deleted : "+list.deleteFirst());
		System.out.println("Deleted : "+list.delete("ISBN1020"));
		System.out.println();
		System.out.println("Deleted : "+list.delete("ISBN1050"));
		System.out.println();
		
		list.displayList();
		
	}
	
}
		
		
		
		
		
		
	