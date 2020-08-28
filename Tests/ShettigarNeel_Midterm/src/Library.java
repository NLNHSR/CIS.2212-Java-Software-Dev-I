/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment Midterm  
 * July 21, 2020
 */

import java.util.Scanner; // import scanner class

public class Library {

	MediaItem[] items;
	int numberOfItems;
	
	Library(){ // default constructor to initialize library values 
		items = new MediaItem[100]; 
		numberOfItems = 0;
	}
	int displayMenu() {
		Scanner input = new Scanner(System.in);	// Create a Scanner object
	    
	    boolean invalid = true; 
	    int choice = 0;
	    while(invalid){
	      System.out.println("\n1. Add new item\n2. Mark an item as on loan\n3. List all items\n4. Mark an item as returned\n5. Quit\n"); // Prints out menu of options
	      System.out.print("What would you like to do? ");
	      choice = input.nextInt();
	      invalid = (choice >= 1 && choice <=5) ? false : true; // checks if choice is valid
	      if (invalid){
	        System.out.println("I'm sorry, " + choice + " wasn't one of the options.\n");
	      }

	    }
	    return choice;
	}
	
	// add a new mediaitem to library array
	void addNewItem(String title, String format) {
		MediaItem item = new MediaItem(title, format);
		items[numberOfItems] = item;
		numberOfItems ++;
	}
		
	// mark a mediaitem as on loan
	void markItemOnLoan(String title, String name, String date) {
		boolean found = false;
		for (int i = 0; i < items.length && items[i] != null; i++) {
			if (items[i].getTitle().equalsIgnoreCase(title)) {
				items[i].markOnLoan(name, date);
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Item was not found");
		}
	}
	
	// "to string" method to allow printing list of mediaitems much easier 
	String[] listAllItems() {
		String[] itemStrings = new String[100];
		for (int i = 0; i < items.length && items[i] != null; i++) {
			String temp = items[i].getTitle() + " (" + items[i].getFormat() + ")";
			if (items[i].getOnLoan()) {
				temp += " loaned to " +  items[i].getLoanedTo() + " on " + items[i].getDateLoaned();
			}
			itemStrings[i] = temp;
		}
		return itemStrings;
		
	}
	
	// mark a mediaitem as returned 
	void markItemReturned(String title) {
		boolean found = false;
		for (int i = 0; i < items.length && items[i] != null; i++) {
			if (items[i].getTitle().equalsIgnoreCase(title)) {
				items[i].markReturned();
				found = true;
			}
		}
		if (!found) {
			System.out.println("I'm sorry, I couldn't find " + title + " in the library.\n");
		}
	}
	
	// main method
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		Library library = new Library();
		String title, format, loanedTo, dateLoaned;
		boolean onLoan;
		while(true) {
			switch(library.displayMenu()) { //check which option was chosen
				case 1: 
					System.out.print("What is the title? ");
					title = input.nextLine();
					System.out.print("What is the format? ");
					format = input.nextLine();
					library.addNewItem(title, format);
					break;
				case 2:
					boolean found = false;
					System.out.print("Which item (enter the title)? ");
					title = input.nextLine();
					for (int i = 0; i < library.items.length && library.items[i] != null; i++) {
						if (library.items[i].getTitle().equalsIgnoreCase(title)) {
							found = true;
						}
					}
					if (!found) {
						System.out.print("I'm sorry, I couldn't find " + title + " in the library.\n");
						break;
					}
					System.out.print("Who are you loaning it to? ");
					loanedTo = input.nextLine();
					System.out.print("When did you loan it to them? ");
					dateLoaned = input.nextLine();
					library.markItemOnLoan(title, loanedTo, dateLoaned);
					break;
				case 3:
					String[] print = library.listAllItems();
					for(int i = 0; i < print.length && print[i] != null; i++) {
						System.out.println(print[i]);
					}
					break;
				case 4:
					System.out.print("Which item (enter the title)?");
					title = input.nextLine();
					library.markItemReturned(title);
					break;
				case 5:
					System.out.print("Goodbye!");
					System.exit(0);
					break;
			}
			
		}
		
	}
	
}
