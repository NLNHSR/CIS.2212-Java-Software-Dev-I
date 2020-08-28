/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 09 - Employee Class  
 * July 24, 2020
 */


package chap11;

// import libraries 
import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeDriver {

	public static void main(String[] args) {
		
		ArrayList<Employee> employeeList = new ArrayList<>(); // arraylist 
		ShiftWorker worker1 = new ShiftWorker(); // no arg constructor 
		
		// user input
		Scanner input = new Scanner(System.in);
		System.out.print("Employee's first name: ");
		worker1.setFirstName(input.nextLine());
		System.out.print("Employee's last name: ");
		worker1.setLastName(input.nextLine());
		System.out.print("Employee's phone (937-555-1212): ");
		worker1.setPhoneNumber(input.nextLine());
		System.out.print("Shift (1-day or 2-night): ");
		worker1.setShiftNumber(input.nextInt());
		System.out.print("Pay rate per hour: ");
		worker1.setPayRate(input.nextDouble());
		System.out.print("Hours worked this period: ");
		worker1.setHoursWorked(input.nextDouble());
		
		// create workers using overload constructors 
		ShiftWorker worker2 = new ShiftWorker("Don", "Griffith", "937-222-1234", 2, 40.00, 18.75);
		Employee worker3 = new ShiftWorker("Chuck", "Banner", "937-898-4567", 1, 41.75, 25.00); // worker created with declared type as Employee
		
		// add items array list 
		employeeList.add(worker1);
		employeeList.add(worker2);
		employeeList.add(worker3);
		
		System.out.println("\nEmployee List contains " + employeeList.size() + " elements: ");
		System.out.println(employeeList.toString()); // print array list 
		
	}

}
