/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 08 - Students Class  
 * July 23, 2020
 */

package chap10;

import java.util.Scanner;

public class StudentsDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // scanner object

		Students student1 = new Students(); // new student with no arg constructor
		// new students with overload constructor 
		Students student2 = new Students("Lisa Ann", "Larraby", 54321, 1993);
		Students student3 = new Students("Karl", "Van der Hutten", 54123, 1983);
		
		// filling out student1 with user input
		System.out.print("Enter First Name: ");
		student1.setFirstName(input.nextLine());
		System.out.print("Enter Last Name: ");
		student1.setLastName(input.nextLine());
		
		System.out.print("\nEnter Student ID: ");
		student1.setStudentID(input.nextInt());
		
		System.out.print("\nEnter 4-Digit Year of Birth: ");
		student1.setBirthYear(input.nextInt());
		
		// printing with overload toString()
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);

	}

}
