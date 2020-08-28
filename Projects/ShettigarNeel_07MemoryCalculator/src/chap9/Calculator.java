/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 07 - Memory calculator  
 * July 20, 2020
 */

package chap9;
import java.util.Scanner; // Import the scanner class

public class Calculator {
	private double currentValue;


	public static int getMenuOption() { // outputs menu and asks user what operations they want to do 
	    Scanner input = new Scanner(System.in);	// Create a Scanner object
	    
	    boolean invalid = true; 
	    int choice = 0;
	    while(invalid){
	      System.out.println("Menu\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Clear\n6. Quit"); // Prints out menu of options
	      System.out.print("What would you like to do? ");
	      choice = input.nextInt();
	      invalid = (choice >= 1 && choice <=6) ? false : true; // checks if choice is valid
	      if (invalid){
	        System.out.println("I'm sorry, " + choice + " wasn't one of the options\n");
	      }

	    }
	    return choice;
	  }
	
	public static double getOperand(String prompt) { // method for operand input
	    Scanner input = new Scanner(System.in);	// Create a Scanner object

	    System.out.print(prompt);
	    double operand = input.nextDouble();
	    return operand; 

	 }
	
	public double getCurrentValue() {
		return currentValue;
	}
	
	public void add(double operand2) {
		currentValue += operand2;

	}
	
	public void subtract(double operand2) {
		currentValue -= operand2;

	}
	
	public void multiply(double operand2) {
		currentValue *= operand2;

	}
	
	public void divide(double operand2) {
		currentValue = (operand2 == 0) ? (0.0 / 0.0) : currentValue / operand2;

	}
	
	public void clear() {
		currentValue = 0;

	}


}
