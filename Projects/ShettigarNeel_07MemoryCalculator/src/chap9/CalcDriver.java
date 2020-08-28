/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 07 - Memory calculator  
 * July 20, 2020
 */

package chap9;
import java.util.Scanner; // Import the scanner class

public class CalcDriver {
	public static void main(String[] args) {
		Calculator calc = new Calculator(); // create instance of calculator class
		double operand2;
	    while(true){
	      System.out.println("\nThe current value is " + calc.getCurrentValue() + "\n"); // print out the current value
	      
	      	  // ".getMenuOption()" and ".getOperand" are called directly from the class since they are static
		      switch(Calculator.getMenuOption()){ // checks users choice
			      case 1: // add
			        operand2 = Calculator.getOperand("What is the second number? ");
			        calc.add(operand2);
			        break;
			      case 2: // subtract
			        operand2 = Calculator.getOperand("What is the second number? ");
			        calc.subtract(operand2);
			        break;
			      case 3: // multiply
			        operand2 = Calculator.getOperand("What is the second number? ");
			        calc.multiply(operand2);
			        break;
			      case 4: // divide
			        operand2 = Calculator.getOperand("What is the second number? ");
			        calc.divide(operand2);
			        break;
			      case 5: // clear
			        calc.clear();
			        break;
			      case 6: // exit
			        System.out.println("Thanks for using the memore calculator!");
			        System.exit(0);
		      }
	    }
	}
}
