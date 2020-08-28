/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment Final  
 * July 29, 2020
 */

package application;

// import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.ListView;

public class Library {

	ArrayList<MediaItem> items = new ArrayList<MediaItem>(); // arraylist of mediaitems to bypass size limit and make manipulation easier
	
	public Library(){ // default constructor to initialize library values 		

	}
	
	// add a new mediaitem to library array
	public void addNewItem(String title, String format) {
		MediaItem item = new MediaItem(title, format);
		items.add(item);
	}
		
	// mark a mediaitem as on loan
	public void markItemOnLoan(String title, String name, String date) {
		for (int i = 0; i < items.size() && items.get(i) != null; i++) {
			if (items.get(i).getTitle().equalsIgnoreCase(title)) {
				items.get(i).markOnLoan(name, date);
			}
		}
	}
	
	// print arraylist of mediaitems to listview display 
	public void printDisplay(ListView display) {
		display.getItems().clear();
		for (int i = 0; i < items.size() && items.get(i) != null; i++) {
			String temp = items.get(i).getTitle() + " (" + items.get(i).getFormat() + ")";
			if (items.get(i).getOnLoan()) {
				temp += " loaned to " +  items.get(i).getLoanedTo() + " on " + items.get(i).getDateLoaned();
			}
			display.getItems().add(temp);
		}
	}
	
	// mark a mediaitem as returned 
	public void markItemReturned(String title) {
		for (int i = 0; i < items.size() && items.get(i) != null; i++) {
			if (items.get(i).getTitle().equalsIgnoreCase(title)) {
				items.get(i).markReturned();
			}
		}
	}
	
	// delete a mediaitem from arraylist
	public void deleteItem(String title) {
		for (int i = 0; i < items.size() && items.get(i) != null; i++) {
			if (items.get(i).getTitle().equalsIgnoreCase(title)) {
				items.remove(i);
			}
		}
	}
	
	// save arraylist of mediaitems to a text file
	public void save() {
		File file = new File("library.txt");
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
			for (int i = 0; i < items.size(); i++) {
				String temp = items.get(i).getTitle() + "#" + items.get(i).getFormat();
				if (items.get(i).getOnLoan()) {
					temp += "#" + items.get(i).getLoanedTo() + "#" + items.get(i).getDateLoaned();
				}
				output.println(temp);
			}
		} catch (FileNotFoundException e) {
			Main.dialogAlert("There was a problem saving the library to a file");
			System.exit(0);

		} finally {
			output.close();
			
		}
		
	}
	
	// open a text file and read contents into arraylist of mediaitems
	public void open(){
		
		File file = new File("library.txt");
		Scanner input = null;
		try {
			input = new Scanner(file);
			while(input.hasNext()) {  
				String line = input.nextLine();
				String[] properties = line.split("#");
				MediaItem temp = new MediaItem(properties[0], properties[1]);
				if (properties.length == 4) {
					temp.markOnLoan(properties[2], properties[3]);
				}
				items.add(temp);
				
			}
		} catch (FileNotFoundException e) {
			Main.dialogAlert("There was a problem opening the library file");
			System.exit(0);
			
		} finally {
			input.close();

		}
		
	}
	
}
