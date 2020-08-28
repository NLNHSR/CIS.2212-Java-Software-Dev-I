/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment Final  
 * July 29, 2020
 */

package application;

public class MediaItem {

	// instance variables 
	private String title, format, loanedTo, dateLoaned;
	private boolean onLoan;
	
	
	// constructors 
	public MediaItem(){
		title = format = loanedTo = dateLoaned = null;
		onLoan = false;
		
	}
	
	public MediaItem(String title, String format){
		this.title = title;
		this.format = format;
		onLoan = false;
	}
	
	
	// setter methods
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setFormat(String format){
		this.format = format;
	}
	
	public void setLoanedTo(String loanedTo){
		this.loanedTo = loanedTo;
	}
	
	public void setDateLoaned(String dateLoaned){
		this.dateLoaned = dateLoaned;
	}
	
	public void setOnLoan(Boolean onLoan){
		this.onLoan = onLoan;
	}
	
	
	// getter methods
	public String getTitle(){
		return this.title;
	}
	
	public String getFormat(){
		return this.format;
	}
	
	public String getLoanedTo(){
		return this.loanedTo;
	}
	
	public String getDateLoaned(){
		return this.dateLoaned;
	}
	
	public boolean getOnLoan(){
		return this.onLoan;
	}
	
	
	// other methods
	void markOnLoan(String name, String date) {
		if(onLoan == false) {
			onLoan = true;
			loanedTo = name;
			dateLoaned = date;
		
		} else {
			Main.dialogAlert(title + " is already on loan to " + loanedTo); // error message dialog box
		
		}
	}
	
	void markReturned() {
		if(onLoan == true) {
			onLoan = false;
			
		} else {
			Main.dialogAlert(title + " is not currently on loan"); // error message dialog box
			
		}
	}
	
}
