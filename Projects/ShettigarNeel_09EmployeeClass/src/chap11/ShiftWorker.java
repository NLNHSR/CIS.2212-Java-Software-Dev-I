/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 09 - Employee Class  
 * July 24, 2020
 */

package chap11;

// import libraries 
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

// subclass 
public class ShiftWorker extends Employee {
	private int shiftNumber; 
	private double payRate, hoursWorked;
	
	// constructors 
	public ShiftWorker(){ // no arg
		super();
		
	}
	
	public ShiftWorker(String first, String last, String number, int shiftNum, double hrsWork, double pay){ // overloaded 
		super(first, last, number);
		shiftNumber = shiftNum;
		hoursWorked = hrsWork;
		payRate = pay;
		
	}

	// getters 
	public int getShiftNumber() {
		return shiftNumber;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public double getPayRate() {
		return payRate;
	}

	// setters 
	
	Scanner input = new Scanner(System.in);
	public void setShiftNumber(int shiftNumber) {
		while(!(shiftNumber == 1 || shiftNumber == 2)) { // shift number validation
			System.out.print("Shift number is 1 or 2. Please try again: ");
			shiftNumber = input.nextInt();
		}
		this.shiftNumber = shiftNumber;
	}

	public void setHoursWorked(double hoursWorked) {
		while(!(hoursWorked >= 0)) { // hours validation
			System.out.print("Hours worked should be 0 or greater. Please try again: ");
			hoursWorked = input.nextDouble();
		}

		this.hoursWorked = hoursWorked;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	
	
	public double calcTotalPay() {
		double shiftDiff = (shiftNumber == 1) ? 1 : 1.5;
		return (payRate * shiftDiff * hoursWorked);
		
	}
	
	@Override
	public String toString() { // overloaded to string 
		StringBuilder output = new StringBuilder();
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		output.append(super.toString());
		output.append("\n  Shift Worked: " + shiftNumber);
		output.append("\n  Pay Rate: " + currency.format(payRate));
		output.append("\n  Hours Worked: " + (new DecimalFormat("0.00").format(hoursWorked)));
		output.append("\n  Total Pay for Period: " + currency.format(calcTotalPay()));
		
		return output.toString();
		
	}
	
}
