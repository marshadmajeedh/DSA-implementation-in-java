import java.util.*;
class WebPage {
	
	private String url;
	private String title;
	private static int count = 0;
	
	
	public WebPage (String u, String t) {
		
		this.url = u;
		this.title = t;
		count++;
		
		
	}
	
	public String getUrl() {
		
		return url;
		
	}
	
	public String getTitle() {
		
		return title;
		
	}
	
	public String toString() {
		
		return "Web url : "+url+", Web title : "+title+"\n";
		
	}
	
	public static int getCount() {
		
		return count;
		
	}
	
}

class BrowseHistory {
	
	int top;
	ArrayList<WebPage> pages;
	
	public BrowseHistory () {
		
		this.top = -1;
		this.pages = new ArrayList<>();
				
	}
	
	public boolean isEmpty() {
		
		return top == -1;
		
	}
	
	public void visitPage (WebPage page) {
		
		++top;
		pages.add(page);
		
	}
	
	public WebPage goBack() {
		
		if (isEmpty()) {
			
			System.out.println ("You have not browsed yet");
			return null;
			
		}
		return pages.remove(top--);
		
	}
	
	public WebPage currentPage() {
		
		if (isEmpty()) {
			
			System.out.println ("You have not browsed yet");
			return null;
			
		}
		
		return pages.get(top);
		
	}
	
	public void showHistory() {
		
		System.out.println ("Your browser history : ");
		for (int i = 0; i < pages.size(); i++) {
			
			System.out.print(pages.get(i));
			
		}
		System.out.println();
	}
	
}

public class BrowserHistorySimulation {
	public static void main (String...args) {
		
		Scanner sc = new Scanner (System.in);
		
		BrowseHistory bh = new BrowseHistory();
		
		String continueProgram;
		
		do {
			
			System.out.println ("1) "+". Visit a new page");
			System.out.println ("2) "+". Go back");
			System.out.println ("3) "+". View current page");
			System.out.println ("4) "+". Show full history");
			System.out.println ("5) "+". Exit");
			System.out.println ("\nchoose your interaction : ");
			int choose = Integer.parseInt(sc.nextLine());
			
			switch (choose) {
				
				case 1 : System.out.print("Enter url : ");
						 String url = sc.nextLine();
						
						 System.out.print("Enter title : ");
						 String title = sc.nextLine();
							
						 WebPage page = new WebPage(url,title);
						 
						 bh.visitPage(page);
						 break;
						 
				case 2 :
				
						System.out.println ("previous web page : ");
						System.out.println (bh.goBack());
						break;
						
				case 3 :
						
						System.out.println ("viewing current page : ");
						System.out.println (bh.currentPage());
						break;
						
				case 4 :
						
						bh.showHistory();
						break;
						
				case 5 :
				
						System.out.println("Exiting from the program!");
						break;
						
				default :
				
						System.out.println ("Wrong choice try again by typin 'y'> ");
						
			}
			
			System.out.println ("\nDo you want to continue this program (y/n) : ");
			continueProgram = sc.next();
			sc.nextLine();
			
		} while (continueProgram.equalsIgnoreCase("y"));
				
	}

}	
		
		
		