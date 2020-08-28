/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 08 - Students Class  
 * July 23, 2020
 */


package chap10;

import java.util.Scanner;

public class Students {

	// initialize variables
	private String firstName, lastName;
	private int studentID, birthYear;
	private final int CURRENT_YEAR = 2020, YOUNGEST_AGE = 13, OLDEST_AGE = 100, LOW_ID = 54000, HIGH_ID = 54999;
	
	// constructors
	Students(){
		
	}
	
	Students(String first, String last, int studentID, int birthYear){
		firstName = first;
		lastName = last;
		this.studentID = studentID;
		this.birthYear = birthYear;
		
	}

	// getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getStudentID() {
		return studentID;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getCURRENT_YEAR() {
		return CURRENT_YEAR;
	}

	public int getYOUNGEST_AGE() {
		return YOUNGEST_AGE;
	}

	public int getOLDEST_AGE() {
		return OLDEST_AGE;
	}

	public int getLOW_ID() {
		return LOW_ID;
	}

	public int getHIGH_ID() {
		return HIGH_ID;
	}

	// setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStudentID(int studentID) {
		this.studentID = validateID(studentID);
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = validateYr(birthYear);
	}
	
	// other methods
	Scanner input = new Scanner(System.in);		

	public int validateID(int id) { //ID validation
		while(true) {
			if (id >= LOW_ID && id <= HIGH_ID) {
				return id;
			} 
			else {
				System.out.print("ID range is " + LOW_ID + " to " + HIGH_ID + ". Please try again: ");
				id = input.nextInt();
			}
		}
 
	}
	
	public int validateYr(int yr) { // year validation
		int lowYr = CURRENT_YEAR - OLDEST_AGE;
		int highYr = CURRENT_YEAR - YOUNGEST_AGE;
		
		while(true) {
			if (yr >= lowYr && yr <= highYr) {
				return yr;
			} 
			else {
				System.out.print("Range is " + lowYr + " to " + highYr + ". Please try again: ");
				yr = input.nextInt();
			}
		}
 
	}
	
	public int calcAge() { // calulate current age
		return CURRENT_YEAR - birthYear;
		
	}
	
	public String toString() { // overload to string to print custom students object properly 
		StringBuilder string = new StringBuilder();
		string.append("\n" + firstName + " " + lastName);
		string.append("\n  Student ID: " + studentID);
		string.append("\n  Age in " + CURRENT_YEAR + ": " + calcAge() + " years old");
		return string.toString();
		
	}
	
}
