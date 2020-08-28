/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment Midterm  
 * July 21, 2020
 */


public class MediaItem {

	// instance variables 
	private String title, format, loanedTo, dateLoaned;
	private boolean onLoan;
	
	
	// constructors 
	MediaItem(){
		title = format = loanedTo = dateLoaned = null;
		onLoan = false;
		
	}
	
	MediaItem(String title, String format){
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
			System.out.println(title + " is already on loan to " + loanedTo);
			
		}
	}
	
	void markReturned() {
		if(onLoan == true) {
			onLoan = false;
			
		} else {
			System.out.println(title + " is not currently on loan");
			
		}
	}
	
}
