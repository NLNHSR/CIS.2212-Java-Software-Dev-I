/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 03 - Days in the Month 
 * June 19, 2020
 */

package chap4;
import java.util.Scanner; // imports scanner class 

class DaysInMonth {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // create scanner object for user input

    int year, days;
    String month, options = "Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec"; // initialize string which contains valid month options used to cross check input later on
    
    System.out.println("How Many Days in a Month\n");

    // request user for year and month input
    System.out.print("Enter a 4-digit year (ex: 2018, 2019): ");
    year = input.nextInt();
    System.out.print("Enter a month (ex: Jan Feb Mar): ");
    month = input.next();

    // checks month input with string created above to ensure it is valid and will allow selection below to work properly 
    if(!options.contains(month)){
      System.out.println(month + " is not a correct month name");
      System.exit(0);
    }

    // checks what month was entered and sets the amount of days accordingly 
    if(month.equals("Sep") || month.equals("Apr") || month.equals("Jun") || month.equals("Nov")){
      days = 30;
    }
    else if(month.equals("Feb")){
      if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){ // leap year test 
        days = 29;
      }
      else{
        days = 28;
      }
    }
    else{
      days = 31;
    }

    // outputs calculated days for user choice 
    System.out.println(month + " " + year + " = " + days + " days");
    System.out.println("\n-------------------------------------");

  }
}