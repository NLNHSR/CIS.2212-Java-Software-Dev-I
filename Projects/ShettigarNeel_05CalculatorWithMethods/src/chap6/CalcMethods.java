/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 05 - Calculator with Methods 
 * June 21, 2020
 */

package chap6;
import java.util.Scanner; // Import the scanner class

public class CalcMethods {

	public static void main(String[] args) {
    double operand1, operand2, lowerLimit, upperLimit;
    while(true){
      switch(getMenuOption()){ // checks users choice
      case 1:
        operand1 = getOperand("What is the first number? ");
        operand2 = getOperand("What is the second number? ");
        System.out.println("Answer: " + add(operand1, operand2)+ " \n");
        break;
      case 2:
        operand1 = getOperand("What is the first number? ");
        operand2 = getOperand("What is the second number? ");
        System.out.println("Answer: " + subtract(operand1, operand2)+ " \n");
        break;
      case 3:
        operand1 = getOperand("What is the first number? ");
        operand2 = getOperand("What is the second number? ");
        System.out.println("Answer: " + multiply(operand1, operand2)+ " \n");
        break;
      case 4:
        operand1 = getOperand("What is the first number? ");
        operand2 = getOperand("What is the second number? ");
        System.out.println("Answer: " + divide(operand1, operand2)+ " \n");
        break;
      case 5:
        operand1 = getOperand("What is the lower limit? ");
        operand2 = getOperand("What is the upper limit? ");
        System.out.println("Answer: " + random(operand1, operand2) + " \n");
        break;
      case 6:
        System.out.println("Goodbye!");
        System.exit(0);
    }
    }

	}

  public static int getMenuOption() { // outputs menu and asks user what operations they want to do 
    Scanner input = new Scanner(System.in);	// Create a Scanner object

    boolean invalid = true; 
    int choice = 0;
    while(invalid){
      System.out.println("Menu\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Generate Random Number\n6. Quit"); // Prints out menu of options
      System.out.print("What would you like to do? ");
      choice = input.nextInt();
      invalid = (choice >= 1 && choice <=6) ? false : true;
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
  // methods for math operations 
  public static double add(double operand1, double operand2) {
    return operand1 + operand2;

  }

  public static double subtract(double operand1, double operand2) {
    return operand1 - operand2;

  }

  public static double multiply(double operand1, double operand2) {
    return operand1 * operand2;

  }

  public static double divide(double operand1, double operand2) {
      return (operand2 == 0) ? (0.0 / 0.0) : (operand1 / operand2);

  }

  public static double random(double lowerLimit, double upperLimit) {
    return lowerLimit + ((double)(Math.random() * (upperLimit - lowerLimit)));

  }


}
