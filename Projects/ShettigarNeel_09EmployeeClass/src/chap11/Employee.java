/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 09 - Employee Class  
 * July 24, 2020
 */

package chap11;

// superclass 
public class Employee {
	private String firstName, lastName, phoneNumber;
	
	// constructors 
	public Employee(){ // no arg
		
	}
	
	public Employee(String first, String last, String number){ // overloaded 
		firstName = first;
		lastName = last;
		phoneNumber = number;
		
	}

	// getters 
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// setters 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// overloaded to string method 
	@Override
	public String toString() {
		return("\nName: " + firstName + " " + lastName + "\n  Phone: " + phoneNumber);
		
	}
	
}
