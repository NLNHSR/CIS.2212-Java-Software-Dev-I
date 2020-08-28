/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 04 - Menu-Driven Calculator 
 * June 20, 2020
 */

package chap5;
import java.util.Scanner; // Import the scanner class

public class MenuDrivenCalc {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);	// Create a Scanner object
    int incorrectCount = 0;
    while(true) { // loop
      System.out.println("Menu\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Generate Random Number\n6. Quit"); // Prints out menu of options
      System.out.print("What would you like to do? ");
          
      int choice = input.nextInt();
      double num1 = 0, num2 = 0, result = 0; // Initializes variables 
      
      if (choice > 0 && choice < 5) { // Test to see how to request both numbers based on user choice
        System.out.print("What is the first number? ");
        num1 = input.nextDouble();
        System.out.print("What is the second number? ");
        num2 = input.nextDouble();
        incorrectCount = 0; // reset incorrect count 

      } else if (choice == 5) {
        System.out.print("What is the lower limit? ");
        num1 = input.nextDouble();
        System.out.print("What is the upper limit? ");
        num2 = input.nextDouble();
        incorrectCount = 0; // reset incorrect count 

      } else if (choice == 6){
        System.out.println("Goodbye!");
        System.exit(0);

      } else { // Handles error of unlisted choice
        System.out.println("I'm sorry, " + choice + " wasn't one of the options");
        System.out.println("");
        incorrectCount++;

        if(incorrectCount ==  3){ // checks if user entered invalid option 3 times in a row
          System.out.print("Please try again later.");
          System.exit(0);      
       }
        continue; // breaks out of current iteration in loop
      }

      switch(choice) { // Test to see which basic arithmetic to apply to both numbers based off user choice
        case 1: 
          result = num1 + num2; break;
        case 2:
          result = num1 - num2; break;
        case 3:
          result = num1 * num2; break;
        case 4:
          if (num2 != 0) {
            result = num1 / num2; break;
          } else { // Handles error of trying to divide by zero
            System.out.println("I'm sorry, you can't divide by zero.\n");
            continue;
          }
          
        case 5:
          result = num1 + ((double)(Math.random() * (num2 - num1))); break; // Generates a random number with a lower and upper bound
      }
      
      System.out.println("Answer: " + result + "\n"); // Outputs final answer to user  
    } // end while loop 


	}

}
