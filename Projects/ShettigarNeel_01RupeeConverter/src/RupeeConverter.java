/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 01 - Rupee Converter
 * May 17, 2020
 */

import java.util.Scanner; // Import the scanner class

public class RupeeConverter {

	public static void main(String[] args) {
		
		final float CONVERSION_RATE = (float) 71.23;	// Establishes conversion rate between rupees and dollars
		
		Scanner input = new Scanner(System.in);	// Create a Scanner object
		
		System.out.println("Exchange rate assumed to be 1 US Dollar to 71.23 Rupee");
		System.out.println("");	// Creates a space inbetween lines
		
		System.out.print("How many dollars would you like to convert to rupees: ");
		float dollars = input.nextFloat();	// Assigns input from user to a variable
		System.out.println("You will recieve " + (dollars * CONVERSION_RATE) + " rupee(s) for " +
		dollars + " dollar(s)");	// Outputs completed conversion to the console
		System.out.println("");

		System.out.print("How many rupees would you like to convert to dollars: ");
		float rupees = input.nextFloat();
		System.out.println("You will recieve " + ((double) rupees / CONVERSION_RATE) + " dollars(s) for " +
		rupees + " rupees(s)");

	}

}
