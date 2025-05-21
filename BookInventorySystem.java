import java.util.*;
class Book {
	
	private String title;
	private String author;
	private double price;
	
	public Book (String title, String author, double price) {
		
		this.title = title;
		this.author = author;
		setPrice(price);
		
	}
	
	public void setPrice (double price) {
		
		if (price >= 0) {
			
			this.price = price;
			return;
			
		}
		
		System.out.println ("Price cannot have negative value");
		
	}
	
	public double getPrice() {
		
		return price;
		
	}
	
	public String getTitle() {
		
		return title;
		
	}
	
	public String getAuthor() {
		
		return author;
		
	}
	
	public String toString() {
		
		return "Book title : "+title+", author : "+author+", price : "+price;
		
	}
	
}

public class BookInventorySystem {
	public static void main (String...args) {
		
	ArrayList<Book> books = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	String continueProgram;
	
	do {
		
		System.out.print("Enter book title : ");
		String title = sc.nextLine();
		
		System.out.print("Enter author name : ");
		String author = sc.nextLine();
		
		System.out.print("Enter book price : ");
		double price = Double.parseDouble(sc.nextLine());
		
		Book b = new Book (title,author,price);
		
		books.add(b);
		
		System.out.print("Do you want to continue this program (y / n) : ");
		continueProgram = sc.next();
		System.out.println();
		sc.nextLine();
		
	} while (continueProgram.equalsIgnoreCase("y"));
		
		for (int i = 1 ; i < books.size(); i++) {
			
			Book keyBook = books.get(i);
			int j = i - 1;
			
			while (j >= 0 && books.get(j).getPrice() > keyBook.getPrice()) {
				
				books.set(j + 1, books.get(j));
				j--;
				
			}
			
			books.set(j + 1, keyBook);
			
		}

	System.out.println ("sorted based on the prices from low to high");
	for (int k = 0; k < books.size(); k++) {
		
		System.out.println(books.get(k));
		System.out.println ();
		
	}
	
	}
	
}

