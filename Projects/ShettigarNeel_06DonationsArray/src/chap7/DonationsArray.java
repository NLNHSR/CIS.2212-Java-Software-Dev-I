/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 06 - Donations Array
 * June 24, 2020
 * -------------------------------
 * Outside resources used:
 * URL-   
 * https://www.avajava.com/tutorials/lessons/how-do-i-use-numberformat-to-format-currencies.html#:~:text=To%20format%20a%20number%20according,currency%20of%20the%20default%20locale.
 * Scope- 
 * I referenced an example given on the website for US currency,
 * and applied the code shown to my project below.
*/

package chap7;
import java.util.Scanner;
import java.text.NumberFormat;

class DonationsArray {
  public static void main(String[] args) {
    final int NUM_DONORS = 17; // constant for number of donors

    // create necessary arrays:
    String[][] donorInfo = input(NUM_DONORS); // call input method to fill donorInfo array
    String[] donorName = new String[NUM_DONORS];
    double[] amtDonated = new double[NUM_DONORS];
    double[] totalDonation = new double[NUM_DONORS];
    int[] numDonations = new int[NUM_DONORS];
    
    // use donorInfo "combined" array to fill up individual arrays:
    for (int i = 0; i < NUM_DONORS; i++){
      donorName[i] = donorInfo[i][0];
      amtDonated[i] = Double.parseDouble(donorInfo[i][1]);
      totalDonation[i] = Double.parseDouble(donorInfo[i][3]);
      numDonations[i] = Integer.parseInt(donorInfo[i][2]);

    }

    printDonors(donorName, amtDonated, totalDonation, numDonations,NUM_DONORS); // call print method to output donors info and grand total

  }

  public static String[][] input(int numDonors){
    Scanner input = new Scanner(System.in); // create scanner object 
    String[][] donorInfo = new String[numDonors][4];

    System.out.println("\n\nPolitical Donations Tracker\n----------------------------");

    // "for loop" for gathering user input and putting it into donorInfo array to return later: 
    for (int i = 0; i < numDonors; i++){
      System.out.print("\nDonor #" + (i + 1) + "\nName of Donor: ");
      donorInfo[i][0] = input.nextLine();
      
      // "while loop" test to make sure donation amount is atleast $5.00:
      System.out.print("Amount of Donation: ");
      while(true){
        donorInfo[i][1] = input.nextLine();
        if (Double.parseDouble(donorInfo[i][1]) < 5.0){
          System.out.print("Minimum donation is $5.00. Please try again: ");
        }else{
          break;
        }
      }
      
      // "while loop" test to make sure amount of donations is atleast 1:
      System.out.print("Number of Donations: ");
      while(true){
        donorInfo[i][2] = input.nextLine();
        if (Integer.parseInt(donorInfo[i][2]) < 1){
          System.out.print("There must be at least 1 donation. Please try again: ");
        }else{
          break;
        }
      }

      // use donor amount and number of donations to calculate total donation amount:
      donorInfo[i][3] = Double.toString(Double.parseDouble(donorInfo[i][1]) * Double.parseDouble(donorInfo[i][2]));

    }

    return donorInfo;
  }

  public static void printDonors(String[] names, double[] amounts, double[] totals, int[] numbers, int numDonors){
    double grandTotalDonations = 0;

    NumberFormat currency = NumberFormat.getCurrencyInstance(); // create currency format object for formatting output to USD

    // output all donor info using individual arrays passed into the method:
    System.out.println("\nPolitical Donations\n--------------------");
    for (int i = 0; i < numDonors; i++){
      System.out.println("Donor #" + (i + 1));
      System.out.println("\tDonor: " + names[i]);
      System.out.println("\tAmount of Donations: " + currency.format(amounts[i]));
      System.out.println("\tNumber of Donations: " + numbers[i]);
      System.out.println("\tTotal from Donor: " + currency.format(totals[i]));
      grandTotalDonations += totals[i];
    }

    System.out.println("\nGrand Total of Donations: " + currency.format(grandTotalDonations));
  }

}