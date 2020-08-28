/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 11 - Random Numbers  
 * July 25, 2020
 */

package chap12;

// import classes 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RandomNumbers {

	public static void main(String[] args) throws Exception {
		double[] randNums = new double[25]; // array to hold random numbers
		
		// fill array with random numbers and display to console
		for (int i = 0; i < 25; i++) {
			randNums[i] = Double.parseDouble((String.format("%10.4f", Math.random() * 250))); 
			System.out.format("%10.4f", randNums[i]);System.out.println();
			
		}
		
		PrintWriter output = null; // object to write to file
		Scanner input = new Scanner(System.in); // object for user input
		//java.io.File file = new java.io.File("C:\\Users\\Neel Shettigar\\Desktop\\randNums.txt"); // my local file
		java.io.File file = new java.io.File("C:\\Users\\John\\Desktop\\myJavaWorkspace\\SmithJohn11\\ randNums.txt"); 

		// exception handling
		try {
			output = new PrintWriter(file);
			// write to file 
			for (int i = 0; i < 25; i++) {
				output.println(randNums[i]);
			}
			
			System.out.print("\nEnter an index: ");
			int index = input.nextInt();
			System.out.println("\nThe element at index " + index + " is " + randNums[index]);

		} catch(ArrayIndexOutOfBoundsException ex) { // index is out of bounds
			System.out.println("The index chosen is out of bounds\n" + ex.toString() + "\n");
			
		} catch(FileNotFoundException ex) { // file not found
			System.out.println("The file chose was not found\n" + ex.toString() + "\n");
			
		} finally { // always executes 
			input.close();
			System.out.println("(finally clause) Scanner object is closed");
			System.out.println("File path: " + file.getAbsolutePath());
			
		}

	}

}
